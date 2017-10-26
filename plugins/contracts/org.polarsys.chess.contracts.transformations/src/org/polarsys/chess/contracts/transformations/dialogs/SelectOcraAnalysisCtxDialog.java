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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GaAnalysisContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.chessmlprofile.Core.CHGaResourcePlatform;

public class SelectOcraAnalysisCtxDialog extends Dialog {
	
	private static final String REFANALYSIS = "CHESSContract::ContractRefinementAnalysisContext";
	private Combo chooseAnalysisCtxField;
	private StyledText rootSystemText;
	private Model model;
	private String system;
	private List<GaAnalysisContext> contextList;
	private ModifyListener modAnalysisCtxListener;

	public SelectOcraAnalysisCtxDialog(Shell shell, Model model) {
		super(shell);
		this.model = model;
		
		this.modAnalysisCtxListener = new ModifyListener(){
			public void modifyText(ModifyEvent e) {
				String selectedCtx = chooseAnalysisCtxField.getText();
				for (GaAnalysisContext ctx : contextList) {
					if (ctx.getBase_NamedElement().getQualifiedName().equals(selectedCtx)){
						CHGaResourcePlatform plat = (CHGaResourcePlatform) ctx.getPlatform().get(0);
						rootSystemText.setText(plat.getBase_Classifier().getQualifiedName());
					}
				}			
			}
		};
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout = new GridLayout(2, false);

		layout.horizontalSpacing = 4;
		layout.verticalSpacing = 4;
		layout.marginBottom = 5;
		layout.marginTop = 5;
	
		parent.setLayout(layout);
		new Label(parent, SWT.NONE).setText("Analysis contexts found in model:");
		
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		chooseAnalysisCtxField = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		contextList = getAnalysisContexts(model);
		for(GaAnalysisContext ctx : contextList){
			if (ctx.getPlatform().size() > 0){
				chooseAnalysisCtxField.add(ctx.getBase_NamedElement().getQualifiedName());
			}
		}
		chooseAnalysisCtxField.addModifyListener(modAnalysisCtxListener);
		chooseAnalysisCtxField.setLayoutData(gridData);
		
		new Label(parent, SWT.NONE).setText("Root element:");
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		rootSystemText = new StyledText(parent, SWT.SINGLE | SWT.READ_ONLY | SWT.BORDER);
		rootSystemText.setText("");
		rootSystemText.setLayoutData(gridData);
		
		return parent;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Select Analysis Context for Contracts Refinement Analysis");
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
	protected void okPressed() {
		setSystem(rootSystemText.getText());
		super.okPressed();
	}

	public String getSystem() {
		return system;
	}

	private void setSystem(String system) {
		this.system = system;
	}
	

	private List<GaAnalysisContext> getAnalysisContexts(Model model) {
		List<GaAnalysisContext> result = new ArrayList<GaAnalysisContext>();
		for (Element elem : model.allOwnedElements()){
			Stereotype stereo = elem.getAppliedStereotype(REFANALYSIS);
			if(stereo != null){
				result.add((GaAnalysisContext) elem.getStereotypeApplication(stereo));			
			}
		}
		return result;
	}
}
