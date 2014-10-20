package org.polarsys.chess.m2m;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;

public class AnalysisContextSelectionDialog extends Dialog {

	private Combo chooseContextField;
	private String context;
	private String title;
	private List<org.eclipse.uml2.uml.Class> contextList;
	
	public AnalysisContextSelectionDialog(Shell parentShell, List<Class> selection, String title) {
		super(parentShell);
		contextList = selection;
		this.title = title;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout(1, false);

		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;
	
		parent.setLayout(layout);
		new Label(parent, SWT.NONE).setText("Contexts found in model: ");
		
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		chooseContextField = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		for(org.eclipse.uml2.uml.Class scenario : contextList){
			chooseContextField.add(scenario.getQualifiedName());
		}
		chooseContextField.setLayoutData(gridData);
		
		new Label(parent, SWT.NONE).setText("");
		
		return parent;	
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(title);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
	protected void okPressed() {
		setContext(chooseContextField.getText());
		super.okPressed();
	}
	
	public void setContext(String qname) {
		this.context = qname;
	}

	public String getContext() {
		return context;
	}
}
