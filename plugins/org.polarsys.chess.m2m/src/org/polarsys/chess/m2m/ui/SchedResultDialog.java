package org.polarsys.chess.m2m.ui;

import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.util.HWAnalysisResultData;
import org.polarsys.chess.core.util.uml.UMLUtils;

public class SchedResultDialog extends Dialog {

	private Shell shell;
	private String result;
	private List<CHRtPortSlot> specifications;
	//private List<CH_HwProcessor> cpus;
	private List<HWAnalysisResultData> hwResults;

	public SchedResultDialog(Shell parentShell, String result, List<CHRtPortSlot> specifications, 
			//List<CH_HwProcessor> cpus,
			List<HWAnalysisResultData> hwResults) {
		super(parentShell);
		this.shell = parentShell;
		this.result = result;
		this.specifications = specifications;
		//this.cpus = cpus;
		this.hwResults = hwResults;

		Image image = null;
		URL url = FileLocator.find(Activator.getDefault().getBundle(), new Path("/resources/CHESSicon.gif"), null);
		try {
			url = FileLocator.toFileURL(url);
			//URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), null);

			image = Activator.getImageDescriptor(url.toString()).createImage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.setDefaultImage(image);
	}

	/** 
	 * Create the dialog area for displaying schedulability analysis results
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		//GridLayout layout = new GridLayout(1, false);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;
		parent.setLayout(layout);

		Device display = shell.getDisplay();
		Color green = display.getSystemColor(SWT.COLOR_GREEN);
		Color red = display.getSystemColor(SWT.COLOR_RED);

		Label resultLabel = new Label(parent, SWT.NONE);
		resultLabel.setFont(new Font(display,"Tahoma", 14, SWT.BOLD));
		if(result != null){
			resultLabel.setText(result);
		}

		Table cpuTable = new Table (parent, SWT.BORDER | SWT.NO_SCROLL);
		cpuTable.setLinesVisible (true);
		cpuTable.setHeaderVisible (true);
		GridData data = new GridData(GridData.FILL, 
				GridData.BEGINNING, true, false, 1, 1);
		cpuTable.setLayoutData(data);
		//cpuTable.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false));
		String[] cpuTitles = {"HW Instance", "Utilization", "Result"};
		for (int i = 0; i < cpuTitles.length; i++) {
			TableColumn column = new TableColumn(cpuTable, SWT.NONE);
			column.setText(cpuTitles[i]);
		}

		// Show utilization results for each Processor/Core
		for ( HWAnalysisResultData hwRes : hwResults) {
			//			TableItem item = new TableItem(cpuTable, SWT.NONE);
			String utilization = hwRes.hw_utilization;
			if(utilization != null){				
				String utilValue = UMLUtils.getValue(utilization, "value");
				if (utilValue!=null && utilValue.length()>0) {
					TableItem item = new TableItem(cpuTable, SWT.NONE);
					item.setText(0, hwRes.hw_instance);
					//String utilValue = getValue(utilization, "value");
					if(utilValue != null && !utilValue.isEmpty()){
						item.setText(1, utilValue  + "%");
						if(Float.parseFloat(utilValue) <= 100){
							item.setText(2, "OK");
							item.setForeground(2, green);
						}else{
							item.setText(2, "NOT OK: utiliaztion over 100%");
							item.setForeground(2, red);
						}
					}
				}
			}
		}
		for (int i = 0; i < cpuTitles.length; i++) {
			cpuTable.getColumn(i).pack();
		}

		Table slotTable = new Table (parent, SWT.BORDER | SWT.NO_SCROLL);
		slotTable.setLinesVisible (true);
		slotTable.setHeaderVisible (true);

		data = new GridData(GridData.FILL, 
				GridData.BEGINNING, true, false, 1, 1);
		slotTable.setLayoutData(data);
		//slotTable.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false));
		String[]slotTitles = {"SW Instance", "Operation", "Response Time", "Deadline", "Result"};
		for (int i = 0; i < slotTitles.length; i++) {
			TableColumn column = new TableColumn(slotTable, SWT.NONE);
			column.setText(slotTitles[i]);
		}

		for (CHRtPortSlot slot : specifications) {
			EList<CHRtSpecification> specifications = slot.getCH_RtSpecification();
			for (CHRtSpecification spec : specifications) {

				if (spec.getRlDl() == null || spec.getRlDl().isEmpty())
					continue;

				TableItem item = new TableItem (slotTable, SWT.NONE);
				item.setText(0, slot.getBase_Slot().getOwningInstance().getName());
				item.setText(1, spec.getContext().getName());

				String rldl = spec.getRlDl();
				String rldlUnit = UMLUtils.getValue(rldl, "unit");
				String rldlValue = UMLUtils.getValue(rldl, "value");
				String deadline = rldlValue + rldlUnit;
				item.setText(3, deadline);

				String respT = "";
				String respUnit = "";
				String respValue ="";

				if (spec.getRespT().size()>0){
					respT = spec.getRespT().get(0);
					respUnit = UMLUtils.getValue(respT, "unit");
					respValue = UMLUtils.getValue(respT, "worst");
				}

				//if rldl is expressed in ms by the user convert respT in ms too
				if(respValue != null && !respValue.isEmpty() && rldlUnit.equals("ms")){
					double conv = Float.parseFloat(respValue)*1000;
					conv = Math.round(conv*100)/100.0d;
					respValue = Double.toString(conv);
					respUnit = "ms";
				}

				//if rldl is expressed in us by the user convert respT in us too
				if(respValue != null && !respValue.isEmpty() && rldlUnit.equals("us")){
					double conv = Float.parseFloat(respValue)*1000000;
					conv = Math.round(conv*100)/100.0d;
					respValue = Double.toString(conv);
					respUnit = "us";
				}

				String responseTime = respValue + respUnit;
				item.setText(2, responseTime);
				if (!respValue.isEmpty() && !rldlValue.isEmpty() ){
					if(Float.parseFloat(respValue) <= Float.parseFloat(rldlValue)){
						item.setText(4, "OK");
						item.setForeground(4, green);
					}else{
						item.setText(4, "NOT OK: Response Time > Deadline");
						item.setForeground(4, red);
					}
				}
			}
		}

		for (int i = 0; i < slotTitles.length; i++) {
			slotTable.getColumn(i).pack();
		}

		return super.createDialogArea(parent);
	}


	/**
	 * Configure shell for displaying schedulability results
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Schedulability Analysis Report");
		shell.setSize(650, 350);
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
