package org.polarsys.chess.cdo.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import org.eclipse.core.resources.IProject;

public class CHESSProjectListLabelProvider extends LabelProvider {


	public Image getImage(Object element) {
		return null;
	}


	public String getText(Object element) {
		IProject resource = (IProject) element;
		return resource.getName();
	}

}
