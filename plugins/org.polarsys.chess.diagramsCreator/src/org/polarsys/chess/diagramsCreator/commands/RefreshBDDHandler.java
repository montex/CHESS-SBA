package org.polarsys.chess.diagramsCreator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.polarsys.chess.diagramsCreator.actions.ShowBDDElementsAction;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

public class RefreshBDDHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		System.out.println("SelectedEditPart = " + selectedEditPart);
		
		//TODO: va fatto il controllo sul tipo di elemento dove clicco
		
		final ShowBDDElementsAction action = ShowBDDElementsAction.getInstance();

		action.refreshDiagram(selectedEditPart);
	
		return null;
	}
}
