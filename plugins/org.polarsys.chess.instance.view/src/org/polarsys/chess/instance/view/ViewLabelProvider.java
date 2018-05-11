/*****************************************************************************
 * Copyright (c) 2016 Budapest University of Technology and Economics, Intecs
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/

package org.polarsys.chess.instance.view;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

//import org.eclipse.incquery.viewers.runtime.model.ViewerState;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.viatra.addon.viewers.runtime.model.ViewerState;
import org.eclipse.viatra.addon.viewers.runtime.notation.Item;
import org.eclipse.viatra.addon.viewers.runtime.sources.QueryLabelProvider;


/**
 * @author BME, Intecs
 * This class provides images and text rendering for the queried entities
 *
 */
public class ViewLabelProvider extends QueryLabelProvider {
	
	public ViewLabelProvider(ViewerState state) {
		//TODO Display???
		super(state, null);
	}

	/**
	 * The <code>LabelProvider</code> implementation of this
	 * <code>ILabelProvider</code> method returns <code>null</code>.
	 * Subclasses may override.
	 */
	@Override
	public Image getImage(Object element) {
		if(element instanceof Item) {
			Item item = (Item) element;
			Object object = item.getParamEObject();
			
			if (object instanceof Slot){
				object = ((Slot)object).getDefiningFeature();
			}
			else {
				if (object instanceof InstanceSpecification){
					InstanceSpecification inst = (InstanceSpecification) object;
					if (inst.getClassifiers() != null && inst.getClassifiers().size()>0){
						object = inst.getClassifiers().get(0);
					}
				}
			}
			
			
			ILabelProvider labelProvider = null;
			try {
				labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class,(EObject) object).getLabelProvider();
			} catch (ServiceException e) {
				System.out.println("catched exception:");
				e.printStackTrace();
			}
			if (labelProvider != null){
				return labelProvider.getImage(object);
			}
		}
		//return super.getImage(element);
		return null;
	}

	/**
	 * The <code>LabelProvider</code> implementation of this
	 * <code>ILabelProvider</code> method returns the element's
	 * <code>toString</code> string. Subclasses may override.
	 */
	@Override
	public String getText(Object element) {
		if(element instanceof Item) {
			Item item = (Item) element;
			Object object = item.getParamEObject();
			
			
			//LabelProviderService service = (LabelProviderService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(LabelProviderService.class);
			ILabelProvider labelProvider = null;
			try {
				labelProvider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class,(EObject) object).getLabelProvider();
			} catch (ServiceException e) {
				System.out.println("catched exception:");
				e.printStackTrace();
			}

			String stereos = "";
			
			//display applied stereotypes
			if (object instanceof Element){
				Element elem = (Element) object;
				EList<Stereotype> listStereo = elem.getAppliedStereotypes();
				for (Stereotype stereo : listStereo){
					stereos += "<<"+stereo.getName()+">>";
				}
			}
			
			if (labelProvider != null){
				String full = labelProvider.getText(object);

				if (full.contains("."))
					return stereos +" "+full.substring(full.lastIndexOf(".")+1);
				return stereos +" " +full;
			}
		}
	
		return super.getText(element);
	}
	
}
