package org.polarsys.chess.functionBehaviors.functionBehaviorEditor;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.polarsys.chess.contracts.profile.chesscontract.util.EntityUtil;
import org.polarsys.chess.service.gui.utils.SelectionUtil;

/**
 * Filters the seleted objects that are components.
 * @author cristofo
 *
 */
public class FunctionBehaviorEditorFilter  implements org.eclipse.jface.viewers.IFilter {
	private SelectionUtil selectionUtil = SelectionUtil.getInstance();
	private EntityUtil entityUtil = EntityUtil.getInstance();

	//TODO: deve lasciarmi editare anche direttamente le functionBehavior, devo implementare un controllo
	
	@Override
	public boolean select(Object selection) {
		Object selectedUmlElement = selectionUtil.getUmlSelectedObject(selection);

		if (selectedUmlElement instanceof Property) {
			if (entityUtil.isComponentInstance((Property) selectedUmlElement)) {
				return true;
			}
		} else if (selectedUmlElement instanceof Class) {
			return true;
		}

		return false;
	}

}
