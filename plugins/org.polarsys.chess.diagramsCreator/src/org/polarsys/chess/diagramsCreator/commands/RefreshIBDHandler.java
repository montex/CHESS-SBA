package org.polarsys.chess.diagramsCreator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.part.InternalBlockDiagramEditPart;
import org.polarsys.chess.diagramsCreator.actions.ShowIBDElementsAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

import eu.fbk.eclipse.standardtools.utils.ui.utils.DialogUtil;

/**
 * This class is to refresh a Internal Block Diagram.
 * It is triggered by the contextual menu item on a diagram.
 * @author cristofo
 *
 */
public class RefreshIBDHandler extends AbstractHandler {
	private static final String DIALOG_TITLE = "IBD refresher";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		if (selectedEditPart instanceof InternalBlockDiagramEditPart) {
			final ShowIBDElementsAction action = ShowIBDElementsAction.getInstance();
			action.refreshDiagram(selectedEditPart);
		} else {
			DialogUtil.getInstance().showMessage_GenericMessage(DIALOG_TITLE, "Please select an Internal Block Diagram");
		}
		return null;
	}
}
