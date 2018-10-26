package org.polarsys.chess.patterns.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;

public class PropertyMappingDialog extends AbstractMappingDialog {
	
	public PropertyMappingDialog(Shell shell, Model chessModel, Pattern pattern, Class modelCtx, Map<NamedElement,NamedElement> mappings, Image patternPreview){
		super(shell, chessModel, modelCtx, pattern, patternPreview);
		this.mappings = mappings;
	}

	@Override
	public void create() {
		super.create();
		setMessage("Map Properties");
	}

	@Override
	protected List<NamedElement> getPatternInput() {
		
		List<NamedElement> result = new ArrayList<>();
		for(ConnectableElement collRole : pattern.getBase_Collaboration().getCollaborationRoles()){
			if(collRole instanceof Property){
				if(!result.contains(collRole)){
					result.add(collRole);
					mappings.put(collRole, null);
				}
			}
		}		
		return result;
	}

	@Override
	protected void updateCandidates() {

		// get the type of the pattern element
		Class type = null;
		if(patternElem instanceof Property){
			if(((Property) patternElem).getType() instanceof Class){
				type = (Class) ((Property) patternElem).getType();
			}
		}
		if(type != null){
		//check if this type is already mapped
			Class mappedType = null;
			boolean found = false;
			for (NamedElement key : mappings.keySet()) {
				if(key.equals(type) && ! found){
					mappedType = (Class) mappings.get(key);
					found = true;
				}
			}
			if(mappedType != null){
				//if so, check the model context for property typed as the mapped one
				for(Element elem : modelCtx.allOwnedElements()){
					if(elem instanceof Property && !(elem instanceof Port)){
						Property prop = (Property) elem;
						if(prop.getType().equals(mappedType)){
							candidates.add(prop);
						}
					}
				}
			}
//			else{
//				//otherwise get all properties in the model
//				for(Element elem : chessModel.allOwnedElements()){
//					if(elem instanceof Property && !(elem instanceof Port)){
//						candidates.add((Property) elem);
//					}
//				}
//			}
		}
	}

}
