package org.polarsys.chess.OSSImporter.commands;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.OSSImporter.actions.ImportOSSFileAction;
import org.polarsys.chess.OSSImporter.actions.ShowIBDElementsAction;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.core.util.uml.UMLUtils;
import org.polarsys.chess.service.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.commands.AbstractJobCommand;

public class CreateIBDMultipleCommand extends AbstractJobCommand {
	private static final String SYSVIEW =	"CHESS::Core::CHESSViews::SystemView";
	private static final String BLOCK =		"SysML::Blocks::Block";
	private static final String CONTRACT =	"CHESSContract::Contract";
	private Object umlObject;
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private ShowIBDElementsAction action;

	public CreateIBDMultipleCommand() {
		super("Create IBD Single");
	}

	/**
	 * Checks if the selected object is a package in the <<SystemView>> branch.
	 * @param pkg the selected object 
	 * @return true if the package is valid
	 */
	private boolean objectIsSystemViewPackage(Object obj) {
		if (obj instanceof Package) {
			final Package pkg = (Package) obj;
			if(pkg.getAppliedStereotype(SYSVIEW) != null) {
				return true;
			} else {
				EList<Package> owningPackages = pkg.allOwningPackages();
				for (Package owningPackage : owningPackages) {
					if (owningPackage.getAppliedStereotype(SYSVIEW) != null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Utility dialog to display a message on screen.
	 * @param message the text to display
	 */
	private void showMessage(String message) {
		MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "OSS parser", message);
	}

	@Override
	public void execPreJobOperations(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
		final ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		umlObject = selectionUtil.getUmlSelectedObject(selection);
		action = new ShowIBDElementsAction();
		
//		System.out.println("selectedUmlElement: " + umlObject);
		
		if (objectIsSystemViewPackage(umlObject)) {
			
			//Now browse all the blocks and create the diagram
			Package pkg = (Package) umlObject;
			
			EList<Element> packageChildren = pkg.getOwnedElements();
			
			for (Element element : packageChildren) {
				
				if (EntityUtil.getInstance().isBlock(element) && !ContractEntityUtil.getInstance().isContract(element)) {
					final Diagram diagram = action.addIBD((Class) element);
					action.populateDiagram(diagram, element);
				}
			}
		} else {
			showMessage("Please select a package from <<SystemView>>");
		}
	}

	@Override
	public void execJobCommand(ExecutionEvent event, IProgressMonitor monitor) throws Exception {
	}

}
