/*------------------------------------------------------------------------------
 -
 - Copyright (c) 2013, 2015 Intecs SpA 
 - All rights reserved. This program and the accompanying materials
 - are made available under the terms of the Eclipse Public License v1.0
 - which accompanies this distribution, and is available at
 - http://www.eclipse.org/legal/epl-v10.html
 -
 - Contributors:
 - 
 - Stefano Puri stefano.puri@intecs.it
 -  
 - Initial API and implementation and/or initial documentation
 ------------------------------------------------------------------------------*/
package org.polarsys.chess.tabbedproperties.widgets;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Component;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FLABehavior;
import org.polarsys.chess.chessmlprofile.Dependability.FailurePropagation.FPTC;
import org.polarsys.chess.tabbedproperties.xtext.XtextInputDialog;
import org.polarsys.chess.xtext.global.utils.XtextUtils;


public class FLAReferenceDialogEditor extends ReferenceDialog {

	private Shell shell;
	private XtextInputDialog xtextDialog;

	public FLAReferenceDialogEditor(Composite parent, int style) {
		super(parent, style);
		shell = parent.getShell();
	}
	
	
	@Override
	protected void editAction() {
		System.out.println(modelProperty.getValue());
		setContext(); 
		if(getValue() != null){
			xtextDialog = new XtextInputDialog(shell, "Edit FLA Expression", null, getValue().toString(), null);
		}else{
			xtextDialog = new XtextInputDialog(shell, "Edit FLA Expression", null, null, null);
		}
		int result = xtextDialog.open();
		if (result == Window.OK) {
			String newValue = xtextDialog.getValue();
			if (newValue == null) {
				return;
			}
			setValue(newValue);
		}
	}

	
	@Override
	public void updateControls() {
		setExclusion(browseValuesButton, true);
		setExclusion(editInstanceButton, false);
		setExclusion(createInstanceButton, true);
		setExclusion(unsetButton, true);
	}

	/**
	 * This method is used in order to get the Stereotype whose property we are editing
	 * Reflection has been used to deal with runtime issues
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setContext() {
		//org.eclipse.papyrus.infra.tools.databinding.DelegatingObservableValue is not available in Papyrus 1.0.0
		//commented temporary waiting for Papyrus (> 1.0.0) CHESS alignement
		XtextUtils.setContextElement(this.getContextElement());
		/*
		if(contextElement instanceof FPTC){
			Component compContext = ((FPTC)contextElement).getBase_Component();
//			System.out.println(compContext.getQualifiedName());
			XtextUtils.setFptcComponent(compContext);
		}else if(contextElement instanceof FLABehavior){
			Component compContext = ((FLABehavior)contextElement).getBase_Class();
//			System.out.println(compContext.getQualifiedName());
			XtextUtils.setFptcComponent(compContext);
		}*/
		
		/*
		//try reflection
		try {
//			System.out.println(modelProperty.getClass().getName());	
			Object h = Proxy.getInvocationHandler(modelProperty);
//			System.out.println(h);
//			Field[] fields = h.getClass().getDeclaredFields();
//			for(Field field : fields){
//				System.out.println("field = " + field.getName());
//			}

			Field delagatorField = h.getClass().getDeclaredField("delegator");
			delagatorField.setAccessible(true);

			Object delegator = delagatorField.get(h);
//			System.out.println(delegator);

			Class ReflectionClass = DelegatingObservableValue.class;
//			System.out.println(ReflectionClass.getName());
			Method m = ReflectionClass.getMethod("getDelegate");
//			System.out.println(m.getName());
			Object result = m.invoke(delegator);
//			System.out.println(result);

			Object obj = result;
			ReflectionClass = PapyrusObservableValue.class;
//			System.out.println(ReflectionClass.getName());
			m = ReflectionClass.getMethod("getEObject");
//			System.out.println(m.getName());
			result = m.invoke(obj);
//			System.out.println(result);

			//result should be the stereotype of the property tab (FPTC or FLASpecification)
			if(result instanceof FPTC){
				Component compContext = ((FPTC)result).getBase_Component();
//				System.out.println(compContext.getQualifiedName());
				XtextUtils.setFptcComponent(compContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		*/
	}
}
