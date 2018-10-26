package org.polarsys.chess.patterns.dialogs;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.uml2.uml.NamedElement;

public class QNameLabelProvider extends ColumnLabelProvider {

	public String getText(Object element) {
		if(element instanceof NamedElement) {
			return ((NamedElement)element).getQualifiedName();
		}
		else {
			return element.toString();
		}
	}

}
