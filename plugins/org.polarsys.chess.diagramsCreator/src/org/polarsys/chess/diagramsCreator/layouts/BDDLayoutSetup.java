/*******************************************************************************
 * Copyright (C) 2018 Fondazione Bruno Kessler.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *     Luca Cristoforetti - initial API and implementation
 ******************************************************************************/
package org.polarsys.chess.diagramsCreator.layouts;

import java.util.Collection;

import org.eclipse.core.runtime.Platform;
//import org.eclipse.elk.conn.gmf.GmfLayoutConfigurationStore;
import org.eclipse.elk.core.service.IDiagramLayoutConnector;
import org.eclipse.elk.core.service.ILayoutSetup;
//import org.eclipse.elk.core.service.ILayoutConfigurationStore;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.ui.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.BlockDefinitionDiagramForMultiEditor;
import org.eclipse.ui.IEditorPart;
import org.polarsys.chess.diagramsCreator.connectors.BDDDiagramLayoutConnector;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class BDDLayoutSetup implements ILayoutSetup {
	
	@Override
	public boolean supports(Object object) {
		if (object instanceof Collection) {
			Collection<?> collection = (Collection<?>) object;
			for (Object o : collection) {
				if (isEditPart(o)) {
					return true;
				}
			}
			return false;
		}
		return getBDDDiagramEditor(object) != null || isEditPart(object);
	}

	protected boolean isEditPart(Object o) {
		if (o instanceof IGraphicalEditPart) {
			try {
				return ServiceUtilsForEditPart.getInstance().getServiceRegistry((IGraphicalEditPart) o) != null;
			} catch (ServiceException ex) {
				return false;
			}
		}
		return false;
	}

	protected DiagramEditor getBDDDiagramEditor(Object object) {
		if (object == null) {
			return null;
		}
		IEditorPart activeEditor = Platform.getAdapterManager().getAdapter(object, IEditorPart.class);
		if (activeEditor instanceof IMultiDiagramEditor) {
			activeEditor = ((IMultiDiagramEditor) activeEditor).getActiveEditor();
		}
	
		if (activeEditor instanceof DiagramEditor && activeEditor instanceof BlockDefinitionDiagramForMultiEditor) {
			return (DiagramEditor) activeEditor;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Injector createInjector(final Module defaultModule) {	
		return Guice.createInjector(Modules.override(defaultModule).with(new BDDLayoutModule()));
	}

	/**
	 * Guice module for the generic GMF connector.
	 */
	public static class BDDLayoutModule implements Module {

		@Override
		public void configure(final Binder binder) {
			binder.bind(IDiagramLayoutConnector.class).to(BDDDiagramLayoutConnector.class);
			
			// Uncomment the following to get the Layout tab
//			binder.bind(ILayoutConfigurationStore.Provider.class).to(GmfLayoutConfigurationStore.Provider.class);
		}
	}
}
