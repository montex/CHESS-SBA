/*
-----------------------------------------------------------------------
-- Copyright (C) 2011-2016                                           --
-- University of Firenze, Italy	                                     --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
--                                                                   --
-- Contributors:                                                     --
-- Leonardo Montecchi 	lmontecchi@unifi.it                          --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.statebased;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.misc.ProgramImageDescriptor;
import org.polarsys.chess.service.utils.CHESSEditorUtils;
import org.polarsys.chess.statebased.daemon.ParameterList;

public class PeriodicExecutionDialog extends Dialog implements Runnable {
	private Text txtParams;
	private Text txtResults;
	private Text txtPeriod;
	private String user = "";
	private String password = "";
	
	private Button btnParams;
	private Button btnResults;
	private Button btnPeriodic;
	private Button btnCancel;
	private Button btnProceed;
	
	private Label lblParams;
	private Label lblResults;
	private Label lblPeriod;
	private Label lblMessage;
	private Label lblSeconds;
	
	private Button chkSaveParamsPath;
	private Button chkSaveResultsPath;

	private Composite container;
	
	private int iInterval = 0;
	private boolean bIsPeriodic = false;
	
	private ProgressMonitorPart monitor;
	
	private ScheduledExecutorService executorService;
	private Future<?> currentJob;
	
	/* Inner class used to correctly update the lblMessage label in the
	 * dialog from other threads (avoids InvalidThreadAccess exceptions) */
	private class MessageLabelUpdater implements Runnable {
		private String m;
		public MessageLabelUpdater(String message) {
			super();
			m = message;
		}
		@Override
		public void run() {
			if(!lblMessage.isDisposed())
				lblMessage.setText(m);
		}
	}
	/* Inner class used to correctly update the enabled state of controls
	 * from other threads (avoids InvalidThreadAccess exceptions) */	
	private class EnabledStateUpdater implements Runnable {
		private boolean s;
		public EnabledStateUpdater(boolean state) {
			super();
			s = state;
		}
		@Override
		public void run() {
			if(!container.isDisposed()) {
				Control[] children = container.getChildren();
				for(int i = 0; i < children.length; i++) {
					children[i].setEnabled(s);
				}
				if(s) {
					txtPeriod.setEnabled(btnPeriodic.getSelection());
				}
				lblMessage.setEnabled(true);
				btnCancel.setText(IDialogConstants.CANCEL_LABEL);
				btnCancel.setEnabled(s);
				btnProceed.setEnabled(s);
			}
		}
	}
	/* Inner class used to correctly begin a new task in the
	 * bar (avoids InvalidThreadAccess exceptions) */	
	private class ProgressTaskBegin implements Runnable {
		private String taskName;
		private int totalWork;
		public ProgressTaskBegin(String name, int work) {
			super();
			taskName = name;
			totalWork = work;
		}
		@Override
		public void run() {
			if(!monitor.isDisposed()) {
				monitor.setVisible(true);
				monitor.beginTask(taskName, totalWork);
			}
		}
	}
	
	
	public PeriodicExecutionDialog(Shell parentShell) {
		super(parentShell);
		executorService = Executors.newSingleThreadScheduledExecutor();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(3, false);
		layout.marginRight = 5;
		layout.marginLeft = 10;
		container.setLayout(layout);
		
		lblParams = new Label(container, SWT.NONE);
		GridData gd_lblParams = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblParams.horizontalIndent = 1;
		lblParams.setLayoutData(gd_lblParams);
		lblParams.setText("Parameters File:");
		
		txtParams = new Text(container, SWT.BORDER);
		txtParams.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,	1, 1));
		txtParams.setText(Activator.getDefault().getPreferenceStore().getString("PARAMFILE"));
		
		btnParams = new Button(container, SWT.NONE);
		btnParams.setText("Browse");
		btnParams.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
		        FileDialog fd = new FileDialog(PeriodicExecutionDialog.this.getParentShell());
		        fd.setText("Select Parameters File");
		        fd.setFileName(txtParams.getText());
		        txtParams.setText(fd.open());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub				
			}
		});
		
		chkSaveParamsPath = new Button(container, SWT.CHECK);
		chkSaveParamsPath.setText("Save as default");
		chkSaveParamsPath.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 3, 1));

		lblResults = new Label(container, SWT.NONE);
		GridData gd_lblPassword = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPassword.horizontalIndent = 1;
		lblResults.setLayoutData(gd_lblPassword);
		lblResults.setText("Results File:");

		txtResults = new Text(container, SWT.BORDER);
		txtResults.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtResults.setText(Activator.getDefault().getPreferenceStore().getString("RESULTFILE"));
		
		btnResults = new Button(container, SWT.NONE);
		btnResults.setText("Browse");
		btnResults.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
		        FileDialog fd = new FileDialog(PeriodicExecutionDialog.this.getParentShell());
		        fd.setText("Select Results File");
		        fd.setFileName(txtResults.getText());
		        fd.setOverwrite(true);
		        txtResults.setText(fd.open());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub				
			}
		});
		
		chkSaveResultsPath = new Button(container, SWT.CHECK);
		chkSaveResultsPath.setText("Save as default");
		chkSaveResultsPath.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 3, 1));

		Label lblPeriodic = new Label(container, SWT.NONE);
		GridData gd_lblPeriodic = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPeriodic.horizontalIndent = 1;
		lblPeriodic.setLayoutData(gd_lblPeriodic);
		lblPeriodic.setText("Periodic:");

		btnPeriodic = new Button(container, SWT.CHECK);
		btnPeriodic.setSelection(Activator.getDefault().getPreferenceStore().getBoolean("RUNPERIODIC"));
		btnPeriodic.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnPeriodic.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtPeriod.setEnabled(btnPeriodic.getSelection());				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		lblPeriod = new Label(container, SWT.NONE);
		GridData gd_lblPeriod = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblPeriod.horizontalIndent = 1;
		lblPeriod.setLayoutData(gd_lblPeriod);
		lblPeriod.setText("Period:");
		
		txtPeriod = new Text(container, SWT.BORDER);
		iInterval = Activator.getDefault().getPreferenceStore().getInt("EXECPERIOD");
		txtPeriod.setText(Integer.toString(iInterval));
		txtPeriod.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		txtPeriod.addVerifyListener(new VerifyListener() {		
			@Override
			public void verifyText(VerifyEvent e) {
				String string = e.text;
		        char[] chars = new char[string.length()];
		        string.getChars(0, chars.length, chars, 0);
		        for (int i = 0; i < chars.length; i++) {
		          if (!('0' <= chars[i] && chars[i] <= '9')) {
		            e.doit = false;
		            return;
		          }
		        }
			}
		});
		txtPeriod.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setMessage("");
				if(btnPeriodic.getSelection()) {
					try {
						iInterval = Integer.parseInt(txtPeriod.getText());
					}catch(NumberFormatException ex) {
						setMessage("Period is invalid");
					}
					
					if(iInterval < 60) {
						setMessage("A period of at least 60 seconds is strongly recommended");
					}
				}
			}
		});
		
		lblSeconds = new Label(container, SWT.NONE);
		lblSeconds.setText("seconds");
		
		lblMessage = new Label(container, SWT.NONE);
		lblMessage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
		monitor = new ProgressMonitorPart(container, new GridLayout());
		monitor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		
		setControlsEnabledState(true);
		
		return container;
	}

	private void setMessage(String m) {
		// Avoids InvalidThreadAccess exceptions when called from another thread
		Display.getDefault().asyncExec(new MessageLabelUpdater(m));
	}
	
	private void setControlsEnabledState(boolean enabled) {
		// Avoids InvalidThreadAccess exceptions when called from another thread
		Display.getDefault().asyncExec(new EnabledStateUpdater(enabled));
	}
	
	private void beginTask(String name, int totalWork) {
		// Avoids InvalidThreadAccess exceptions when called from another thread
		Display.getDefault().asyncExec(new ProgressTaskBegin(name, totalWork));
	}	
	
	private void resetControls() {
		setMessage("");
		setControlsEnabledState(true);
	}
	
	// override method to use "Login" as label for the OK button
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		btnProceed = createButton(parent, IDialogConstants.PROCEED_ID, IDialogConstants.PROCEED_LABEL, true);
		btnCancel = createButton(parent, IDialogConstants.STOP_ID, IDialogConstants.CANCEL_LABEL, false);
		
		btnProceed.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setControlsEnabledState(false);
				
				setMessage("Waiting...");
		
				if(chkSaveParamsPath.getSelection()) {
					Activator.getDefault().getPreferenceStore().setValue("PARAMFILE", txtParams.getText());
				}
				if(chkSaveResultsPath.getSelection()) {
					Activator.getDefault().getPreferenceStore().setValue("RESULTFILE", txtResults.getText());					
				}
				
				bIsPeriodic = btnPeriodic.getSelection();
				
				StateBasedWithParametersCommand.acquireModel();
				StateBasedWithParametersCommand.setParamsFilePath(txtParams.getText());
				StateBasedWithParametersCommand.setResultsFilePath(txtResults.getText());
				
				btnCancel.setText(IDialogConstants.STOP_LABEL);
				btnCancel.setEnabled(true);
				btnProceed.setEnabled(false);
				if(bIsPeriodic) {				
					currentJob = executorService.scheduleAtFixedRate(PeriodicExecutionDialog.this, 0, iInterval, TimeUnit.SECONDS);
				}else{
					currentJob = executorService.submit(PeriodicExecutionDialog.this);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCancel.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancelPressed();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	protected IProgressMonitor getMonitor() {
		return monitor;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(650, 390);
	}

	@Override
	protected void okPressed() {
		super.okPressed();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void run() {
		Date nextRun = new Date(new Date().getTime() + iInterval*1000);
			
		setMessage("Running...");
		beginTask("Analysis", 100);
	
		StateBasedWithParametersCommand.runStateBased();
		
		if(bIsPeriodic) {
			setMessage("Waiting until... " + nextRun + " (estimated)");
		}else{
			setMessage("Done.");
			setControlsEnabledState(true);
		}
	}
	
	@Override
	protected void cancelPressed() {
		if(currentJob != null)
			currentJob.cancel(true);
					
		resetControls();
		if(btnCancel.getText() == IDialogConstants.STOP_LABEL) {		
			btnCancel.setText(IDialogConstants.CANCEL_LABEL);
			btnProceed.setEnabled(true);
			setControlsEnabledState(true);
		}else{
			executorService.shutdownNow();
			super.cancelPressed();
		}
	};
	
	@Override
	protected boolean isResizable() {
	    return true;
	}
	
	protected void progress(final int work) {
		if(monitor != null) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					if(!monitor.isDisposed())
						monitor.worked(work);
				}
			});
		}
	}
	
	protected void subTask(final String name) {
		if(monitor != null) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					if(!monitor.isDisposed())
						monitor.subTask(name);
				}
			});
		}
			
	}
	
	protected void stopMonitor() {
		if(monitor != null) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					if(!monitor.isDisposed())
						monitor.setVisible(false);
				}
			});
		}
			
	}
	
	

}