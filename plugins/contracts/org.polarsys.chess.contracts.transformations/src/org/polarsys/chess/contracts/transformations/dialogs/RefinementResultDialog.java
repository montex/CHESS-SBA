/*******************************************************************************
 *
 * Copyright (c) 2013, 2015 Intecs SpA 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Nicholas Pacini nicholas.pacini@intecs.it 
 * Stefano Puri stefano.puri@intecs.it
 * Laura Baracchi  laura.baracchi@intecs.it  
 * Initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.chess.contracts.transformations.dialogs;

import org.polarsys.chess.core.Activator;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class RefinementResultDialog extends Dialog {

	private Shell shell;
	private String resultText;

	public RefinementResultDialog(Shell parentShell, String result) {
		super(parentShell);
		this.shell = parentShell;
		this.resultText = result;
		
		Image image = null;
		URL url = FileLocator.find(Activator.getDefault().getBundle(), new Path("/resources/CHESSicon.gif"), null);
    	try {
			url = FileLocator.toFileURL(url);			
	    	image = Activator.getImageDescriptor(url.toString()).createImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		super.setDefaultImage(image);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {

		Display display = shell.getDisplay();
		Color green = display.getSystemColor(SWT.COLOR_GREEN);
		Color red = display.getSystemColor(SWT.COLOR_RED);
		Color blue = display.getSystemColor(SWT.COLOR_BLUE);
		GridLayout layout = new GridLayout(1, false);
		parent.setLayout(layout);
		GridData data =  new GridData();
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		data.grabExcessHorizontalSpace = true;
		data.grabExcessVerticalSpace = true;
		StyledText text = new StyledText (parent, SWT.BORDER | SWT.H_SCROLL | SWT.MULTI | SWT.V_SCROLL);
		text.setText(resultText);
		String match = "[OK]";
		for (int i = -1; (i = resultText.indexOf(match, i + 1)) != -1;) {
		    StyleRange style = new StyleRange();
			style.start = i;
			style.length = 4;
			style.fontStyle = SWT.BOLD;
			style.foreground = green;
			text.setStyleRange(style);
		}
		match = "[BOUND OK]";
		for (int i = -1; (i = resultText.indexOf(match, i + 1)) != -1;) {
		    StyleRange style = new StyleRange();
			style.start = i;
			style.length = 10;
			style.fontStyle = SWT.BOLD;
			style.foreground = blue;
			text.setStyleRange(style);
		}
		match = "[NOT OK]";
		for (int i = -1; (i = resultText.indexOf(match, i + 1)) != -1;) {
		    StyleRange style = new StyleRange();
			style.start = i;
			style.length = 8;
			style.fontStyle = SWT.BOLD;
			style.foreground = red;
			text.setStyleRange(style);
		}
		text.setEditable(false);
		text.setLayoutData(data);
		
		return super.createDialogArea(parent);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Check Contract Refinement Report");
		shell.setSize(500, 350);
		Monitor primary = shell.getDisplay().getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}
}
