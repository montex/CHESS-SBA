package org.polarsys.chess.paramArchConfigurator.ui.wizard;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EObjectTreeElementImpl;
import org.eclipse.uml2.uml.Package;

public class PackageViewFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		System.out.println("element: "+element);
		if (element instanceof EObjectTreeElementImpl){
			return (((EObjectTreeElementImpl)element).getEObject() instanceof Package);
			
		}
		return false;
	}
}