package org.chess.statebased;

import org.polarsys.chess.editor.CHESSEditor;
import org.polarsys.chess.core.profiles.CHESSProfileManager;
import org.polarsys.chess.core.views.DiagramStatus.DesignView;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

public class StateBasedSourceProvider extends AbstractSourceProvider {

	public static final String ANALYSIS = "org.chess.statebased.stateBased";
	private static final String ENABLED = "enabled";
	private final static String DISABLED = "disabled";
	boolean enabled;

	@Override
	public void dispose() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getCurrentState() {	
		Map currentState = new HashMap(2);
		String currentSt = enabled ? ENABLED : DISABLED;
		currentState.put(ANALYSIS, currentSt);
		return currentState;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] {ANALYSIS};
	}
	
	private void setEnabled(boolean enabled) {
		if (this.enabled == enabled)
			return; // no change
		this.enabled = enabled;
		String currentState = enabled ? ENABLED : DISABLED;
		fireSourceChanged(ISources.WORKBENCH, ANALYSIS, currentState);
	}
	
	public void updateStatus(IEditorPart activeEditor) {

		try {
			if (activeEditor instanceof CHESSEditor) {

				DesignView currentView = ((CHESSEditor) activeEditor).getDiagramStatus().getCurrentView();

				if (currentView.getName().equals(CHESSProfileManager.DEPENDABILITY_ANALYSIS_VIEW)) {
					setEnabled(true);
				} else {
					setEnabled(false);
				}
			} else {
				setEnabled(false);
			}
			refreshElements();
		} catch (Exception e) {
			return;
		}
	}

	private void refreshElements() {
		ICommandService service = (ICommandService) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getService(ICommandService.class);
		service.refreshElements(StateBasedTransformationCommand.COMMAND_ID, null);
	}

}
