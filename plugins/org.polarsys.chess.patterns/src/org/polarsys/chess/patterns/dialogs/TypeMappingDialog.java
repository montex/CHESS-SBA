package org.polarsys.chess.patterns.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.polarsys.chess.contracts.profile.chesscontract.util.ContractEntityUtil;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;

public class TypeMappingDialog extends AbstractMappingDialog {

	
	public TypeMappingDialog(Shell shell, Model chessModel, Pattern pattern, Class modelCtx, Image patternPreview) {
		super(shell, chessModel, modelCtx, pattern, patternPreview);
	}

	@Override
	public void create() {
		super.create();
		setMessage("Map Types");
	}

	protected List<NamedElement> getPatternInput() {
		
		List<NamedElement> result = new ArrayList<>();
		
		for(ConnectableElement collRole : pattern.getBase_Collaboration().getCollaborationRoles()){
			if(collRole.getType() instanceof Class){
				if(!result.contains(collRole.getType())){
					result.add((Class) collRole.getType());
					mappings.put(collRole.getType(), null);
				}
			}
		}		
		return result;
	}
	
	protected void updateCandidates() {
		
		for(Element elem : chessModel.allOwnedElements()){
			if(elem instanceof Class && !ContractEntityUtil.getInstance().isContract(elem)){
				candidates.add((Class) elem);
			}
		}
	}

}
