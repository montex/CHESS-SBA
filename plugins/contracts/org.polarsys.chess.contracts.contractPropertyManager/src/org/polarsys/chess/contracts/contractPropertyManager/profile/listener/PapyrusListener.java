/*******************************************************************************
 * Copyright (C) 2017 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Alberto Debiasi - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.contracts.contractPropertyManager.profile.listener;

import org.eclipse.papyrus.uml.diagram.composite.part.Messages;
import org.eclipse.uml2.uml.Class;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.chess.contracts.profile.chesscontract.ContractProperty;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.eclipse.papyrus.uml.tools.listeners.StereotypeElementListener.StereotypeExtensionNotification;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class PapyrusListener implements IPapyrusListener {

	private ContractEntityUtil contractEntityUtil = ContractEntityUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	@Override
	public void notifyChanged(Notification notification) {

		Object notifier = notification.getNotifier();
		int eventType = notification.getEventType();

		if (eventType == Notification.SET) {

			if (notifier instanceof Property) {
				Object oldValue = notification.getOldValue();
				Object newValue = notification.getNewValue();

				if ((oldValue != null) & (newValue == null)) {
					if (oldValue instanceof Class) {
						Class oldUmlClass = (Class) oldValue;
						if (contractEntityUtil.isContract(oldUmlClass)) {
							oldUmlClass.destroy();
						}
					}
				}
			}
		}

		if (notifier instanceof Property) {

			if (eventType == StereotypeExtensionNotification.STEREOTYPE_APPLIED_TO_ELEMENT) {

				Property umlProperty = (Property) notifier;

				if (contractEntityUtil.isContractProperty(umlProperty)) {

					if (notification.getNewValue() instanceof ContractProperty) {
						ContractProperty newContractProperty = (ContractProperty) notification.getNewValue();

						if (newContractProperty.getBase_Property().getType() == null) {

							Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

							boolean res = MessageDialog.openQuestion(shell, "Question",
									"Do you want to create a new contract or instantiate an existing one?");

							Class contract;

							if (res) {
								String contractName = newContractProperty.getBase_Property().getName()
										.replace("Property", "") + "Type";
								// create the class that will be converted as
								// contract
								contract = createContract((Class) umlProperty.getOwner(), contractName);
							} else {
								// assign as type of the new contract property
								// the
								// selected contract
								contract = selectContract(umlProperty);
							}
							// assign to the type of the contractproperty the
							// contract
							newContractProperty.getBase_Property().setType((Type) contract);
						}
					}
				}

			}
		}

	}

	private Class createContract(Class owner, String contractName) {

		Class newUmlClass = UMLFactory.eINSTANCE.createClass();
		Classifier newClass = owner.createNestedClassifier(contractName, newUmlClass.eClass());
		// ASSIGN STEREOTYPE 'CONTRACT' to the CLASS
		contractEntityUtil.applyContractStereotype((Class) newClass);
		return (Class) newClass;
	}

	private Class selectContract(Element element) {
		TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());

		UMLContentProvider provider = new UMLContentProvider(entityUtil.getToPackage(element),
				// contract.getOwner(),
				UMLPackage.eINSTANCE.getPackage_PackagedElement());

		dialog.setContentProvider(provider);
		dialog.setLabelProvider(new UMLLabelProvider());
		dialog.setMessage(Messages.UMLModelingAssistantProviderMessage);
		dialog.setTitle(Messages.UMLModelingAssistantProviderTitle);
		if (dialog.open() == org.eclipse.jface.window.Window.OK) {
			Object[] result = dialog.getResult();
			if (result != null && result.length > 0 && result[0] instanceof EObject) {
				return (Class) result[0];
			}
		}
		return null;
	}

}
