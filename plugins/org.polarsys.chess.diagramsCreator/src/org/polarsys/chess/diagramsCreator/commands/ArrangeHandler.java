package org.polarsys.chess.diagramsCreator.commands;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

public class ArrangeHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final List<IGraphicalEditPart> selection = new ArrayList<IGraphicalEditPart>();
		IGraphicalEditPart selectedEditPart = SelectionUtil.getInstance().getSelectedGraphicalObject(event);
		
		selection.add(selectedEditPart);
		
		ArrangeRequest request = new ArrangeRequest("arrangeAllAction"); //$NON-NLS-1$
		request.setPartsToArrange((selection));

		Command cmd = selectedEditPart.getCommand(request);

		// Call the command three times, to get a better result
		if (cmd != null && cmd.canExecute()) {
			cmd.execute();
			cmd.execute();
			cmd.execute();
		}
		return null;
	}
}
