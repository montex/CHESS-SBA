package org.polarsys.chess.patterns.dialogs;

import java.util.Map;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

public class MappingLabelProvider extends ColumnLabelProvider {
	
	private int column;
	
	private Map<NamedElement, NamedElement> mappings;

	public MappingLabelProvider(int column, Map<NamedElement, NamedElement> mappings) {
		this.column = column;
		this.mappings = mappings;
	}

	@Override
	public String getText(Object element) {
		
		NamedElement elem = (NamedElement) element;
		
		if(column == 1) {
			String name =  elem.getName();
			if(elem instanceof Port){
				if (elem.getOwner() instanceof NamedElement) {
					name += " (owner: " + ((NamedElement) elem.getOwner()).getQualifiedName() + ")";
				}
			}
			if(elem instanceof Property){
				Property prop = (Property) elem;
				if (prop.getType() instanceof NamedElement) {
					name += " (type: " + prop.getType().getQualifiedName() + ")";
				}
			}
			if(elem instanceof Connector){
				Connector conn = (Connector) elem;
				Port firstRole = null;
				Port secondRole = null;
				Property firstProp = null;
				Property secondProp = null;
				if(conn.getEnds().size() == 2){
					if(conn.getEnds().get(0).getRole() instanceof Port){
						firstRole = (Port) conn.getEnds().get(0).getRole();
					}
					if(conn.getEnds().get(1).getRole() instanceof Port){
						secondRole = (Port) conn.getEnds().get(1).getRole();
					}
					if(conn.getEnds().get(0).getPartWithPort() instanceof Property){
						firstProp = (Property) conn.getEnds().get(0).getPartWithPort();
					}
					if(conn.getEnds().get(1).getPartWithPort() instanceof Property){
						secondProp = (Property) conn.getEnds().get(1).getPartWithPort();
					}
				}
				if (firstRole != null && secondRole != null && firstProp != null && secondProp != null) {
					name += " (" + firstProp.getName() + "." + firstRole.getName() + " - " + 
							secondProp.getName() + "." + firstProp.getName() + ")";
				}
			}
			return name;
		}
		else if(column == 2) {
			Object mappedRole = mappings.get(elem);
			if (mappedRole instanceof NamedElement) {
				NamedElement mappedType = (NamedElement) mappedRole;
				String name = mappedType.getName();
				if (mappedType.getOwner() instanceof NamedElement) {
					name += " (from " + ((NamedElement) mappedType.getOwner()).getQualifiedName() + ")";
				}
				return name;
			}
			else {
				return "not mapped (to be created)";
			}	
		}
		return "";
	}

}
