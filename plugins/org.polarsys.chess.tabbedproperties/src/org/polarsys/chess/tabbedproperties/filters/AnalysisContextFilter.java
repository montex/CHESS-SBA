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
package org.polarsys.chess.tabbedproperties.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.chessmlprofile.util.Constants;

public class AnalysisContextFilter implements IFilter {
	
	public boolean select(Object toTest) {	
		boolean test = false;
		
		if (toTest instanceof EObjectTreeElement) {
			EObject eobj = ((EObjectTreeElement) toTest).getEObject();
			
			if (eobj instanceof Class){
				if(((Class)eobj).getAppliedStereotype(Constants.MARTE_SaAnalysisContext) != null){
					test=true;
				}
			}
		}
		return test;
	}

}
