package org.polarsys.chess.m2m;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaAnalysisContext;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.SAM.SaEndtoEndFlow;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.polarsys.chess.chessmlprofile.Predictability.DeploymentConfiguration.HardwareBaseline.CH_HwProcessor;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtPortSlot;
import org.polarsys.chess.chessmlprofile.Predictability.RTComponentModel.CHRtSpecification;
import org.polarsys.chess.core.Activator;
import org.polarsys.chess.core.util.CHESSProjectSupport;

public class End2EndResultDialog extends Dialog {

	private List<CH_HwProcessor> cpus;
	private List<CHRtPortSlot> specifications;
	private SaAnalysisContext saAnalysisCtx;
	private SaEndtoEndFlow saE2EFlow;
	private List<Operation> messages;
	private List<Assign> assigns;
	private Shell shell;
	private Model model;
	private Label resultLabel;
	private Table cpuTable;
	private Label e2eLabel;
	private Table e2eTable;
	private Label addinfoLabel;
	private Table slotTable;
	private Label cpuLabel;
	private String[] cpuTitles = {"HW Instance", "Utilization", "Result"};
	private String[] e2eTitles = {"End-To-End Scenario", "Operation Sequence", "Response Time", "Deadline", "Result"};
	private String[]slotTitles = {"SW Instance", "Operation", "Deployed On", "Response Time", "Deadline", "Result"};
	
	protected End2EndResultDialog(Shell parentShell, Model model) {
		super(parentShell);
		this.shell = parentShell;
		this.model = model;
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
		
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;
		container.setLayout(layout);
		
		Device display = shell.getDisplay();
		Color green = display.getSystemColor(SWT.COLOR_GREEN);
		Color red = display.getSystemColor(SWT.COLOR_RED);
		
		resultLabel = new Label(container, SWT.NONE);
		resultLabel.setFont(new Font(display,"Tahoma", 12, SWT.BOLD));
		
		String e2eTime = null;
		String e2eTimeUnit = null;
		String e2eTimeVal = null;

		String e2eDl = null;
		String e2eDlVal =null; 
		String e2eDlUnit = null;
		//compute e2e analysis results:
		if(saE2EFlow.getEnd2EndT().size() > 0){
			e2eTime = saE2EFlow.getEnd2EndT().get(0);
			e2eTimeUnit = getValue(e2eTime, "unit");
			e2eTimeVal = getValue(e2eTime, "worst");

			e2eDl = saE2EFlow.getEnd2EndD().get(0);
			e2eDlVal = getValue(e2eDl, "value"); 
			e2eDlUnit =  getValue(e2eDl, "unit");
		}

		boolean e2eResult = false;
		if(e2eTimeVal == null){
			resultLabel.setText("Problems while performing the analysis. Results not significant");
		}else{

			//if deadline is expressed in ms and response time is in s, use ms (other cases?)
			if(e2eTimeVal != null && !e2eTimeVal.isEmpty() && e2eTimeUnit.equals("s")){
				double conv = Float.parseFloat(e2eTimeVal)*1000;
				conv = Math.round(conv*100)/100.0d;
				e2eTimeVal = Double.toString(conv);
				e2eTimeUnit = "ms";
			}
			if (e2eTimeVal != null && !e2eTimeVal.isEmpty() && !e2eDlVal.isEmpty() && Float.parseFloat(e2eTimeVal) <= Float.parseFloat(e2eDlVal)){
				e2eResult = true;
			}
			if(e2eResult){
				resultLabel.setText("End-To-End Timing Constraints are Satisfied by the System");
			}else{
				resultLabel.setText("End-To-End Timing Constraints are NOT Satisfied by the System");
			}
		}
		cpuLabel = new Label(container, SWT.NONE);
		cpuLabel.setFont(new Font(display,"Tahoma", 12, SWT.ITALIC));
		cpuLabel.setText("HW Resources:");
		
		cpuTable = new Table (container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		cpuTable.setLinesVisible (true);
		cpuTable.setHeaderVisible (true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		cpuTable.setLayoutData(data);
		for (int i = 0; i < cpuTitles.length; i++) {
			TableColumn column = new TableColumn(cpuTable, SWT.NONE);
			column.setText(cpuTitles[i]);
		}
		for (CH_HwProcessor processor : cpus) {
			TableItem item = new TableItem(cpuTable, SWT.NONE);
			String utilization = processor.getUtilization();
			if(utilization != null){
				item.setText(0, processor.getBase_InstanceSpecification().getName());
				String utilValue = getValue(utilization, "value");
				if(utilValue != null){
				item.setText(1, utilValue  + "%");
					if(Float.parseFloat(utilValue) <= 100){
						item.setText(2, "OK");
						item.setForeground(2, green);
					}else{
						item.setText(2, "NOT OK: utilization over 100%");
						item.setForeground(2, red);
					}
				}
			}
		}
		for (int i = 0; i < cpuTitles.length; i++) {
			cpuTable.getColumn(i).pack();
		}
		
		e2eLabel = new Label(container, SWT.NONE);
		e2eLabel.setFont(new Font(display,"Tahoma", 12, SWT.ITALIC));
		e2eLabel.setText("End-To-End Scenario: ");
		
		e2eTable = new Table (container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		e2eTable.setLinesVisible (true);
		e2eTable.setHeaderVisible (true);
		
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		e2eTable.setLayoutData(data);
		for (int i = 0; i < e2eTitles.length; i++) {
			TableColumn column = new TableColumn(e2eTable, SWT.NONE);
			column.setText(e2eTitles[i]);
		}

		//set the scenario
		TableItem item = new TableItem (e2eTable, SWT.NONE);
		Activity e2eActivity = (Activity) saE2EFlow.getBase_NamedElement();
		CallBehaviorAction callbehaviour = null;
		for (ActivityNode activityNode : e2eActivity.getNodes()) {
			if(activityNode instanceof CallBehaviorAction){
				callbehaviour = (CallBehaviorAction)activityNode;
			}
		}
		item.setText(0, callbehaviour.getBehavior().getName());
		StringBuilder opSequence = new StringBuilder();
		String delim = "";
		for (Operation msg : messages) {
			opSequence.append(delim).append(msg.getName());
		    delim = ", ";
		}

		item.setText(1, opSequence.toString());
		
		if(e2eTimeVal != null){
		//set the response time and deadline
		item.setText(2, e2eTimeVal + e2eTimeUnit);
		item.setText(3, e2eDlVal + e2eDlUnit);
		
		//set the result
			if(e2eResult){
				item.setText(4, "OK");
				item.setForeground(4, green);
			}else{
				item.setText(4, "NOT OK: Response Time > Deadline");
				item.setForeground(4, red);
			}
		}
		
		for (int i = 0; i < e2eTitles.length; i++) {
			e2eTable.getColumn(i).pack();
		}
		
		addinfoLabel = new Label(container, SWT.NONE);
		addinfoLabel.setFont(new Font(display,"Tahoma", 12, SWT.ITALIC));
		addinfoLabel.setText("Additional Model Info: ");
		
		slotTable = new Table (container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		slotTable.setLinesVisible (true);
		slotTable.setHeaderVisible (true);
		
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		slotTable.setLayoutData(data);
		for (int i = 0; i < slotTitles.length; i++) {
			TableColumn column = new TableColumn(slotTable, SWT.NONE);
			column.setText(slotTitles[i]);
		}
		
		for (CHRtPortSlot slot : specifications) {
			EList<CHRtSpecification> specifications = slot.getCH_RtSpecification();
			for (CHRtSpecification spec : specifications) {
				
				if (spec.getRlDl() == null || spec.getRlDl().isEmpty() || messages.contains(spec.getContext()))
					continue;
				
				item = new TableItem (slotTable, SWT.NONE);
				item.setText(0, slot.getBase_Slot().getOwningInstance().getName());
				item.setText(1, spec.getContext().getName());
				
				InstanceSpecification deployInst = getDeployment(slot.getBase_Slot().getOwningInstance());
				if(deployInst != null){
					item.setText(2, deployInst.getName());
				}
				String rldl = spec.getRlDl();
				String rldlUnit = getValue(rldl, "unit");
				String rldlValue = getValue(rldl, "value");
				String deadline = rldlValue + rldlUnit;
				item.setText(4, deadline);
				
				String respT = "";
				String respUnit = "";
				String respValue ="";
				
				if (spec.getRespT().size()>0){
					respT = spec.getRespT().get(0);
					respUnit = getValue(respT, "unit");
					respValue = getValue(respT, "worst");
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
				item.setText(3, responseTime);
				if (!respValue.isEmpty() && !rldlValue.isEmpty() ){
					if(Float.parseFloat(respValue) <= Float.parseFloat(rldlValue)){
						item.setText(5, "OK");
						item.setForeground(5, green);
					}else{
						item.setText(5, "NOT OK: Response Time > Deadline");
						item.setForeground(5, red);
					}
				}
			}
		}
		
		for (int i = 0; i < slotTitles.length; i++) {
			slotTable.getColumn(i).pack();
		}
		
		return container;
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("End-To-End Schedulability Analysis Report");
		Monitor primary = shell.getDisplay().getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setSize(bounds.width/2, bounds.height/2);
	    shell.setLocation(x, y);
	}
	
	@Override
	protected void setShellStyle(int newShellStyle) {
		super.setShellStyle(getShellStyle() | SWT.CLOSE | SWT.MAX | SWT.APPLICATION_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		setBlockOnOpen(false);
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}
	
	
	@Override
	protected void okPressed() {
		try {
			IFile modelFile = CHESSProjectSupport.resourceToFile(model.eResource());
			IFolder resultFolder =  modelFile.getProject().getFolder(TransUtil.RESULTS_DIR_E2E);
			if(!resultFolder.exists()){
				resultFolder.create(IResource.NONE, true, null);
			}
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			IFile reportFile = resultFolder.getFile(model.getName() + "_e2eAnalysisResult_" + timestamp);
			if(!reportFile.exists()){
				String initalContent = "Results of End-To-End Analysis on model: " + modelFile.getLocation().toString() + " @ " + timestamp;
				StringBuilder sb = new StringBuilder(initalContent);
				fillContent(sb);
				byte[] bytes = sb.toString().getBytes();
			    InputStream source = new ByteArrayInputStream(bytes);
				reportFile.create(source, IResource.NONE, null);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		super.okPressed();
	}

	@Override
	protected Button createButton(Composite parent, int id,
			String label, boolean defaultButton) {
		if (id == IDialogConstants.CANCEL_ID)
			return null;
		return super.createButton(parent, id, label, defaultButton);
	}

	public List<CH_HwProcessor> getCpus() {
		return cpus;
	}

	public void setCpus(List<CH_HwProcessor> cpus) {
		this.cpus = cpus;
	}

	public List<CHRtPortSlot> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(List<CHRtPortSlot> specifications) {
		this.specifications = specifications;
	}

	public SaAnalysisContext getSaAnalysisCtx() {
		return saAnalysisCtx;
	}

	public void setSaAnalysisCtx(SaAnalysisContext saAnalysisCtx) {
		if(saAnalysisCtx != null && saAnalysisCtx.eIsProxy()){
			saAnalysisCtx = (SaAnalysisContext) EcoreUtil.resolve(saAnalysisCtx, saAnalysisCtx.eResource());
		}
		this.saAnalysisCtx = saAnalysisCtx;
	}
	
	public SaEndtoEndFlow getSaE2EFlow() {
		return saE2EFlow;
	}

	public void setSaE2EFlow(SaEndtoEndFlow saE2EFlow) {
		this.saE2EFlow = saE2EFlow;	
	}
	
public List<Operation> getMessages() {
		return messages;
	}

	public void setMessages(List<Operation> messages) {
		this.messages = messages;
	}

	public List<Assign> getAssigns() {
		return assigns;
	}

	public void setAssigns(List<Assign> assigns) {
		this.assigns = assigns;
	}

	private static String getValue(String s, String match) {

		if (s== null)
			return"";

		String found = null;
		String[] splits = s.split(",");
		for (String split : splits) {
			if(split.contains(match)){
				String[] ssplits = split.split("=");
				for (String str : ssplits) {
					if(!str.contains(match)){
						found =  str;
					}
				}
			}
		}
		if(found != null){
			found = found.trim();
			if (found.startsWith("(")){
				found = found.substring(1, found.length());
			}
			if (found.endsWith(")")){
				found = found.substring(0, found.length()-1);
			}
		}
		return found;
	}
	
	private InstanceSpecification getDeployment(InstanceSpecification fromInst) {
		InstanceSpecification toInst = null;
		for (Assign assign : assigns) {
			if(assign.getFrom().get(0).equals(fromInst)){
				toInst = (InstanceSpecification) assign.getTo().get(0);
			}
		}
		return toInst;
	}
	
	private void fillContent(StringBuilder sb) {

		appendNewLines(sb, 2);
		sb.append(resultLabel.getText());
		
		appendNewLines(sb, 2);
		sb.append(cpuLabel.getText());
	
		appendNewLines(sb, 2);
		for (int i = 0; i < cpuTitles.length; i++) {
			sb.append(cpuTitles[i] + "\t");
		}
		appendNewLines(sb, 1);
		TableItem[] items = cpuTable.getItems();
		for (int i = 0; i < items.length; i++) {
			sb.append(items[i].getText() + "\t");
			sb.append(items[i].getText(1) + "\t");
			sb.append(items[i].getText(2) + "\t");
			appendNewLines(sb, 1);
		}
		
		appendNewLines(sb, 1);
		sb.append(e2eLabel.getText());
		
		appendNewLines(sb, 2);
		for (int i = 0; i < cpuTitles.length; i++) {
			sb.append(e2eTitles[i] + "\t");
		}
		
		appendNewLines(sb, 1);
		items = e2eTable.getItems();
		for (int i = 0; i < items.length; i++) {
			sb.append(items[i].getText() + "\t");
			sb.append(items[i].getText(1) + "\t");
			sb.append(items[i].getText(2) + "\t");
			sb.append(items[i].getText(3) + "\t");
			sb.append(items[i].getText(4) + "\t");
			appendNewLines(sb, 1);
		}
		
		appendNewLines(sb, 1);
		sb.append(addinfoLabel.getText());
		
		appendNewLines(sb, 2);
		for (int i = 0; i < slotTitles.length; i++) {
			sb.append(slotTitles[i] + "\t");
		}
		
		appendNewLines(sb, 1);
		items = slotTable.getItems();
		for (int i = 0; i < items.length; i++) {
			sb.append(items[i].getText() + "\t");
			sb.append(items[i].getText(1) + "\t");
			sb.append(items[i].getText(2) + "\t");
			sb.append(items[i].getText(3) + "\t");
			sb.append(items[i].getText(4) + "\t");
			sb.append(items[i].getText(5) + "\t");
			appendNewLines(sb, 1);
		}
	}
	
	private void appendNewLines(StringBuilder sb, int numLines){
		for (int i = 0; i < numLines; i++) {
			sb.append(System.lineSeparator());
		}
	}
}
