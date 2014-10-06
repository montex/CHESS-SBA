/*
-----------------------------------------------------------------------
--          			CHESS core plugin							 --
--                                                                   --
--                    Copyright (C) 2011-2012                        --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Alessandro Zovi         azovi@math.unipd.it 		         --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------
*/

package org.polarsys.chess.core.util.uml;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

public class ResourceUtils {

	public static Model getModel(Resource res) {
		return (Model) EcoreUtil.getObjectByType(res.getContents(),
				UMLPackage.Literals.MODEL);
	}

	public static Resource getUMLResource(ServicesRegistry editor)
			throws ServiceException {
		return ((UmlModel) (editor.getService(ModelSet.class))
				.getModel(UmlModel.MODEL_ID)).getResource();
	}

	public static Resource getNotationResource(ServicesRegistry editor) throws ServiceException {
		return ((NotationModel) (editor.getService(ModelSet.class))
		.getModel(NotationModel.MODEL_ID)).getResource();
	}

	public static Resource getNotationResource(IEditorPart editor) throws ServiceException {
		return ((NotationModel) (((ServicesRegistry) editor
		.getAdapter(ServicesRegistry.class)).getService(ModelSet.class))
		.getModel(NotationModel.MODEL_ID)).getResource();
	}
}
