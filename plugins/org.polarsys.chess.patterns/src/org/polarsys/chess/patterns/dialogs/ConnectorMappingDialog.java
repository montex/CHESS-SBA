package org.polarsys.chess.patterns.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;

public class ConnectorMappingDialog extends AbstractMappingDialog {

	public ConnectorMappingDialog(Shell shell, Model chessModel, Pattern pattern, Class modelCtx, Map<NamedElement, NamedElement> mappings, Image patternPreview) {
		super(shell, chessModel, modelCtx, pattern, patternPreview);
		this.mappings = mappings;
	}
	
	@Override
	public void create() {
		super.create();
		setMessage("Map Connectors");
		getButton(IDialogConstants.OK_ID).setText("OK");
	}
	
	@Override
	protected List<NamedElement> getPatternInput() {
		List<NamedElement> result = new ArrayList<>();
		for(Connector conn : pattern.getBase_Collaboration().getOwnedConnectors()){
			if(!result.contains(conn)){
				result.add(conn);
				mappings.put(conn, null);
			}
		}
		return result;
	}

	@Override
	protected void updateCandidates() {
		//get all connectors in the model context
		for(Element elem : modelCtx.allOwnedElements()){
			if(elem instanceof Connector){
				candidates.add((Connector)elem);
			}
		}

	}

}
