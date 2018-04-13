package org.polarsys.chess.diagramsCreator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.polarsys.chess.diagramsCreator.actions.ShowBDDElementsAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

/**
 * This class is to refresh a Block Definition Diagram.
 * It is triggered by the contextual menu item on a diagram.
 * @author cristofo
 *
 */
public class RefreshBDDHandler extends AbstractHandler {
	private static final String DIALOG_TITLE = "BDD refresher";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {	
		final IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		if (selectedEditPart instanceof BlockDefinitionDiagramEditPart) {
			final ShowBDDElementsAction action = ShowBDDElementsAction.getInstance();
			action.refreshDiagram(selectedEditPart);
		} else {
			DialogUtil.getInstance().showMessage_GenericMessage(DIALOG_TITLE, "Please select a Block Definition Diagram");
		}
		return null;
	}
}
