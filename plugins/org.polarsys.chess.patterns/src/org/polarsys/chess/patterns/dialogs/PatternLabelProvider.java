package org.polarsys.chess.patterns.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;

public class PatternLabelProvider extends LabelProvider {
	
	@Override
	public String getText(Object element) {
		if(element instanceof Pattern) {
			Pattern pattern = ((Pattern)element);
			String text = pattern.getPatternName() != null ? pattern.getPatternName() : pattern.getBase_Collaboration().getName();
			int others = pattern.getOtherNames().size();
			if(others > 0){
				text = text + "\t (";
				for(int i = 0; i < others; i++){
					if(i < others-1){
						text = text + pattern.getOtherNames().get(i) + ", ";
					}else{
						text = text + pattern.getOtherNames().get(i);
					}
				}
				text = text + ")";
			}
			return text;
		}
		else {
			return super.getText(element);
		}

	}

}
