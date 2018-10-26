package org.polarsys.chess.patterns.utils;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.polarsys.chess.patterns.profile.PatternsProfile.Pattern;


public class PatternUtils {

	public static NamedElement applyStereotypes(NamedElement source, NamedElement target) {

//		System.out.println("============================");
		for(Stereotype stereo : source.getAppliedStereotypes()){
//			System.out.println(stereo.getName());
			if(target.isStereotypeApplicable(stereo)){
				target.applyStereotype(stereo);
				EList<Property> attrs = stereo.getOwnedAttributes();
				for (Property property : attrs) {
					if(!property.isReadOnly() &&! property.getName().startsWith("base_")){
						Object srcValue = source.getValue(stereo, property.getName());
						target.setValue(stereo, property.getName(), srcValue);
//						System.out.println("changed: " + property.getName());
					}
				}
			}
		}
		
		return target;
	}
	
	public static String StringListToString(List<String> list){
		
		String result = "not available";
		if(list.size() > 0){
			result = "";
			for(int i = 0; i < list.size(); i++){
				if(i > 0){
					result = result + "\n"+ list.get(i);
				}else{
					result = result + list.get(i);
				}
			}
		}
		
		return result;
	}
	
	public static Image retrieveImageforPatternPreview (Pattern pattern){
		
		String preview = pattern.getPreview();
		if(preview != null){
			String previewPlugin = preview.substring(0, preview.indexOf("/"));
			String previewPath = preview.substring(preview.indexOf("/"));

			ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(previewPlugin, previewPath);

			if(imageDescriptor != null){
				return imageDescriptor.createImage();
			}else{
				return null;
			}
		}
		return null;
	}

}
