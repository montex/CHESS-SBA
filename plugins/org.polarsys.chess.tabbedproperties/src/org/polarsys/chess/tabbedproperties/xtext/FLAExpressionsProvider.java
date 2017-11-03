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
package org.polarsys.chess.tabbedproperties.xtext;



import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import com.google.inject.Inject;

public class FLAExpressionsProvider implements IEditedResourceProvider{
	
	@Inject private IResourceSetProvider resourceSetProvider;
	@Inject private FileExtensionProvider ext;

	public XtextResource createResource() {
		ResourceSet resourceSet = resourceSetProvider.get(null);
		URI uri = URI.createURI("synthetic:/temp."+ext.getPrimaryFileExtension());
		XtextResource result = (XtextResource) resourceSet.createResource(uri);
		resourceSet.getResources().add(result);
		return result;
		
	}

}
