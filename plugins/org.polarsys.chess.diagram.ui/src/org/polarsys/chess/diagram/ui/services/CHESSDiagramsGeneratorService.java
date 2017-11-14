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
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;

import eu.fbk.eclipse.standardtools.diagram.ContainterDescriptor;
import eu.fbk.eclipse.standardtools.diagram.DiagramDescriptor;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.BlockDefinitionDiagramGeneratorService;
import eu.fbk.eclipse.standardtools.diagram.ui.docGenerators.InternalBlockDiagramGeneratorService;
import eu.fbk.eclipse.standardtools.diagram.ui.model.AbstractBlockDefinitionDiagramModel;
import eu.fbk.eclipse.standardtools.diagram.ui.model.AbstractInternalBlockDiagramModel;

public class CHESSDiagramsGeneratorService {
	
	private static CHESSDiagramsGeneratorService instance;
	
	final private static String IBD = "InternalBlock"; 
	final private static String BDD = "BlockDefinition";
	
	public static CHESSDiagramsGeneratorService getInstance(AbstractInternalBlockDiagramModel ibdModel,AbstractBlockDefinitionDiagramModel bddModel){
		if(instance==null){
			instance = new CHESSDiagramsGeneratorService(ibdModel, bddModel);
		}
		return instance;
	}
	
	
	
	public CHESSDiagramsGeneratorService(AbstractInternalBlockDiagramModel ibdModel, AbstractBlockDefinitionDiagramModel bddModel) {
		super();
		//graphicalModel = graphModel;
		ibdGeneratorService = InternalBlockDiagramGeneratorService.getInstance(ibdModel);
		bddGeneratorService = BlockDefinitionDiagramGeneratorService.getInstance(bddModel);
	}



	//private static AbstractDiagramModel graphicalModel;	
	private InternalBlockDiagramGeneratorService ibdGeneratorService;
	private BlockDefinitionDiagramGeneratorService bddGeneratorService;

	
	private String directoryName;
	private String imageExtension;
	

	
	public void setParametersBeforeDiagramsGenerator(
			String directoryName, String imageExtension, 
			boolean showPortLabels, boolean automaticLabelLayout) {
		
		this.directoryName=directoryName;
		this.imageExtension=imageExtension;
		
		
		ibdGeneratorService.setParametersBeforeDiagramGenerator(showPortLabels, automaticLabelLayout);
		
	}
	
	public DiagramDescriptor createDiagramWithDescriptor(Diagram diagram, IProgressMonitor monitor){
		EObject diagramOwner = DiagramUtils.getOwner(diagram);
		String diagramName = "";
		String ownerName = null;
		boolean hasComponentOwner = true;
		if(diagramOwner instanceof Class){
		ownerName = ((Class)diagramOwner).getName();
		diagramName = ownerName+"_"+diagram.getName();
		}else{
			hasComponentOwner = false;
			diagramName = diagram.getName();
		}
		
		//if(diagram.getName().compareTo("Contracts")!=0){
		try{
		createDiagram(diagram,diagramName, monitor);
		return createDiagramDescriptor(diagramName,ownerName,hasComponentOwner );
		}catch(NullPointerException e){
			System.out.println("Unable to create diagram "+diagramName);
		}
		return null;
	}
	
	
	
	private void createDiagram(Diagram diagram,String diagramName, IProgressMonitor monitor){
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		System.out.println("diagram name: "+diagram.getName());
		System.out.println("diagram type: "+diagram.getType());
		
		EditPart editPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell);

		RootEditPart root = editPart.getRoot();
		System.out.println("root: "+root);
		
		if(isInternalBlockDiagram(diagram)){
		InternalBlockDiagramEditPart idb = (InternalBlockDiagramEditPart) root.getChildren().get(0);
		BlockCompositeEditPart graphicalComponent = (BlockCompositeEditPart)idb.getChildren().get(0);
		
	ibdGeneratorService.createDiagramFile(getComponentImageFilePath(diagramName), graphicalComponent, monitor);
		}else if(isBlockDefinitionDiagram(diagram)){
			System.out.println("isBlockDefinitionDiagram");
			BlockDefinitionDiagramEditPart bdd = (BlockDefinitionDiagramEditPart) root.getChildren().get(0);
			for(Object o : bdd.getChildren()){
				System.out.println("o: "+o);
			}
			
			bddGeneratorService.createDiagramFile(getComponentImageFilePath(diagramName), bdd, monitor);
			
		}
	}
	
	private DiagramDescriptor createDiagramDescriptor(String diagramName, String ownerName, boolean hasComponentOwner){
		String saveFilePath = getComponentImageFilePath(diagramName);
		System.out.println("saveFilePath: "+saveFilePath);
		// diagramGeneratorService.createDiagramFile(saveFilePath, component,
		// monitor);
		final DiagramDescriptor diagramDescriptor = //diagramGeneratorService.
				createDiagramDescriptorWithImageFileUrl(diagramName, saveFilePath,ownerName,hasComponentOwner);
		return diagramDescriptor;
	}
	
	private DiagramDescriptor createDiagramDescriptorWithImageFileUrl(String diagramName, String saveFilePath,String owner,boolean hasComponentOwner) {
		DiagramDescriptor diagramDescriptor = new DiagramDescriptor();
		diagramDescriptor.name = diagramName;
		diagramDescriptor.hasComponentOwner = hasComponentOwner;
		if(owner!=null){
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
		Set<Diagram> diagrams =  getIBD_BDD_Diagrams(notationModel.getResources());
		System.out.println("diagrams");
		for (Diagram c : diagrams) {
			System.out.println(c);			
		}
		return diagrams;
	
	}

	public Set<Diagram> getDiagrams(Set<Resource> resources){
		
		Set<Diagram> diagrams = new HashSet<Diagram>();
		
		for (Resource current : resources) {
			for (EObject element : current.getContents()) {
				if (element instanceof Diagram) {
					diagrams.add((Diagram)element);
					}
				}
			}
		
		return diagrams;
	}
	
private Set<Diagram> getIBD_BDD_Diagrams(Set<Resource> resources){
		
		Set<Diagram> diagrams = new HashSet<Diagram>();
		
		for (Resource current : resources) {
			for (EObject element : current.getContents()) {
				if (element instanceof Diagram) {
					Diagram diagram = (Diagram)element;
					System.out.println("diagram type: "+diagram.getType());
					
					if (isBlockDefinitionDiagram(diagram)||isInternalBlockDiagram(diagram)){
					diagrams.add((Diagram)element);
					}
					}
				}
			}
		
		return diagrams;
	}
	
	
private boolean isBlockDefinitionDiagram(Diagram diagram){
	if(diagram.getType().compareTo(BDD)==0){
		return true;
	}
	return false;
}

private boolean isInternalBlockDiagram(Diagram diagram){
	if(diagram.getType().compareTo(IBD)==0){
		return true;
	}
	return false;
}
	
	private String getComponentImageFilePath(String fileName) {
			return directoryName + File.separator + fileName + imageExtension;
		}
	
}
