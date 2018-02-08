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
package org.polarsys.chess.diagram.ui.services;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import eu.fbk.eclipse.standardtools.diagram.DiagramDescriptor;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.BlockDefinitionDiagramGeneratorService;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.InternalBlockDiagramGeneratorService;
import eu.fbk.eclipse.standardtools.diagram.ui.model.AbstractBlockDefinitionDiagramModel;
import eu.fbk.eclipse.standardtools.diagram.ui.model.AbstractInternalBlockDiagramModel;

public class CHESSDiagramsGeneratorService {

	private static CHESSDiagramsGeneratorService instance;

	final private static String IBD = "InternalBlock";
	final private static String BDD = "BlockDefinition";

	private static final Logger logger = Logger.getLogger(CHESSDiagramsGeneratorService.class);

	public static CHESSDiagramsGeneratorService getInstance(AbstractInternalBlockDiagramModel ibdModel,
			AbstractBlockDefinitionDiagramModel bddModel) {
		if (instance == null) {
			instance = new CHESSDiagramsGeneratorService(ibdModel, bddModel);
		}
		return instance;
	}

	public CHESSDiagramsGeneratorService(AbstractInternalBlockDiagramModel ibdModel,
			AbstractBlockDefinitionDiagramModel bddModel) {
		super();
		ibdGeneratorService = InternalBlockDiagramGeneratorService.getInstance(ibdModel);
		bddGeneratorService = BlockDefinitionDiagramGeneratorService.getInstance(bddModel);
	}

	private InternalBlockDiagramGeneratorService ibdGeneratorService;
	private BlockDefinitionDiagramGeneratorService bddGeneratorService;

	private String directoryName;
	private String imageExtension;

	public void setParametersBeforeDiagramsGenerator(String directoryName, String imageExtension,
			boolean showPortLabels, boolean automaticLabelLayout) {

		this.directoryName = directoryName;
		this.imageExtension = imageExtension;

		ibdGeneratorService.setParametersBeforeDiagramGenerator(showPortLabels, automaticLabelLayout);

	}

	public DiagramDescriptor createDiagramWithDescriptor(Diagram diagram, Shell shell, IProgressMonitor monitor) {
		EObject diagramOwner = DiagramUtils.getOwner(diagram);
		String diagramName = "";
		String ownerName = null;
		boolean hasComponentOwner = true;
		if (diagramOwner instanceof Class) {
			ownerName = ((Class) diagramOwner).getName();
			diagramName = ownerName + "_" + diagram.getName();
		} else {
			hasComponentOwner = false;
			diagramName = diagram.getName();
		}

		try {

			createDiagram(diagram, diagramName, shell, monitor);

			return createDiagramDescriptor(diagramName, ownerName, hasComponentOwner);
		} catch (NullPointerException e) {
			logger.error("Unable to create diagram " + diagramName);
		}
		return null;
	}

	private void createDiagram(Diagram diagram, String diagramName, Shell shell, IProgressMonitor monitor) {

		logger.debug("diagram name: " + diagram.getName());
		logger.debug("diagram type: " + diagram.getType());

		EditPart editPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell);

		RootEditPart root = editPart.getRoot();

		if (isInternalBlockDiagram(diagram)) {
			InternalBlockDiagramEditPart idb = (InternalBlockDiagramEditPart) root.getChildren().get(0);
			BlockCompositeEditPart graphicalComponent = (BlockCompositeEditPart) idb.getChildren().get(0);

			ibdGeneratorService.createDiagramFile(getComponentImageFilePath(diagramName), graphicalComponent, monitor);
		} else if (isBlockDefinitionDiagram(diagram)) {
			BlockDefinitionDiagramEditPart bdd = (BlockDefinitionDiagramEditPart) root.getChildren().get(0);
			// for(Object o : bdd.getChildren()){
			// System.out.println("o: "+o);
			// }

			bddGeneratorService.createDiagramFile(getComponentImageFilePath(diagramName), bdd, monitor);

		}
	}

	private DiagramDescriptor createDiagramDescriptor(String diagramName, String ownerName, boolean hasComponentOwner) {
		String saveFilePath = getComponentImageFilePath(diagramName);
		logger.debug("saveFilePath: " + saveFilePath);
		final DiagramDescriptor diagramDescriptor = // diagramGeneratorService.
				createDiagramDescriptorWithImageFileUrl(diagramName, saveFilePath, ownerName, hasComponentOwner);
		return diagramDescriptor;
	}

	private DiagramDescriptor createDiagramDescriptorWithImageFileUrl(String diagramName, String saveFilePath,
			String owner, boolean hasComponentOwner) {
		DiagramDescriptor diagramDescriptor = new DiagramDescriptor();
		diagramDescriptor.name = diagramName;
		diagramDescriptor.hasComponentOwner = hasComponentOwner;
		if (owner != null) {
			diagramDescriptor.ownerName = owner;
		}
		String diagramFileName;
		try {
			diagramFileName = new File(saveFilePath).toURI().toURL().getFile();
		} catch (MalformedURLException e) {
			return null;
		}

		diagramDescriptor.url = FilenameUtils.getName(diagramFileName);

		return diagramDescriptor;
	}

	public Collection<Diagram> getDiagrams() {

		NotationModel notationModel = NotationUtils.getNotationModel();
		Set<Diagram> diagrams = getIBD_BDD_Diagrams(notationModel.getResources());
		System.out.println("diagrams");
		for (Diagram c : diagrams) {
			System.out.println(c);
		}
		return diagrams;

	}

	public Set<Diagram> getDiagrams(Set<Resource> resources) {

		Set<Diagram> diagrams = new HashSet<Diagram>();

		for (Resource current : resources) {
			for (EObject element : current.getContents()) {
				if (element instanceof Diagram) {
					diagrams.add((Diagram) element);
				}
			}
		}

		return diagrams;
	}

	private Set<Diagram> getIBD_BDD_Diagrams(Set<Resource> resources) {

		Set<Diagram> diagrams = new HashSet<Diagram>();

		for (Resource current : resources) {
			for (EObject element : current.getContents()) {
				if (element instanceof Diagram) {
					Diagram diagram = (Diagram) element;
					System.out.println("diagram type: " + diagram.getType());

					if (isBlockDefinitionDiagram(diagram) || isInternalBlockDiagram(diagram)) {
						diagrams.add((Diagram) element);
					}
				}
			}
		}

		return diagrams;
	}

	private boolean isBlockDefinitionDiagram(Diagram diagram) {
		if (diagram.getType().compareTo(BDD) == 0) {
			return true;
		}
		return false;
	}

	private boolean isInternalBlockDiagram(Diagram diagram) {
		if (diagram.getType().compareTo(IBD) == 0) {
			return true;
		}
		return false;
	}

	private String getComponentImageFilePath(String fileName) {
		return directoryName + File.separator + fileName + imageExtension;
	}

}
