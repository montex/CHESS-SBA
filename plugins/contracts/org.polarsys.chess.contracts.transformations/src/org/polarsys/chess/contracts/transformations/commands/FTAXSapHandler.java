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
package org.polarsys.chess.contracts.transformations.commands;

import org.eclipse.uml2.uml.Class;
import org.polarsys.chess.contracts.transformations.utils.AnalysisResultUtil;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.sirius.business.api.query.DViewQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.factory.SessionFactory;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.eclipse.sirius.viewpoint.DRepresentation;

/**
 * This command permits the execution of FTA using the xSAP tool.
 * @author cristofo
 *
 */
public class FTAXSapHandler extends AbstractXSapHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final String storeResultParam = "store_result";
		
		// Get the root component of the package
		//FIXME: potrebbe diventare inutile se metto l'analysis context...
		final Class systemComponent = analysisResultUtil.getSystemComponentFromEvent(event);
		
		// Compute all the required files for the analysis
		if (!prepareExpandedFiles(event)) {
			return null;
		}

		final boolean storeResult = (event.getParameter(storeResultParam) != null && 
				event.getParameter(storeResultParam).equals("true")) ? true : false;

		// Compute and display the FTA for each condition requested
		int index = 0;
		for (String condition : ftaFmeaCond.split(", ")) {
			final String ftFileName = fileNamesUtil.computeFtFileName(editor, modelName, ++index, storeResult);
			if (!xSapExecService.computeFt(extendedSmvFileName, fmsFileName, condition, ftFileName, false)) {
				return null;
			}
			
			// FIXME: ftaCond potrebbe diventare inutile se metto l'analysis context...
			
			// If requested, store the data
			if (storeResult) {
				analysisResultUtil.storeResult(AnalysisResultUtil.FTA_ANALYSIS, ftaFmeaCond, 
						ftFileName, systemComponent, analysisContext);
			}
		}
		
//		// Get session from an absolute path (not in a workspace)
//        URI sessionResourceURI = URI.createFileURI("D:/folder/representations.aird");
//        Session session = SessionFactory.INSTANCE.createSession(sessionResourceURI, new NullProgressMonitor());
//        session.open(new NullProgressMonitor());
//        // Get the expected representation (here the first of the first DView)
//        DViewQuery query = new DViewQuery(session.getOwnedViews().iterator().next());
//        DRepresentation representation = query.getLoadedRepresentations().get(0);
//        // Export it as SVG image
//        ImageFileFormat f;
//        
//        ExportFormat exportFormat = new ExportFormat(ExportDocumentFormat.NONE, f);
//        DialectUIManager.INSTANCE.export(representation, session, new Path("D:/folder/image.svg"), exportFormat,
//                new NullProgressMonitor());
//		
		
		
		
		
		
		
		return null;
	}
}

