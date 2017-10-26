package org.polarsys.chess.contracts.chessextension.propertytab;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public class ClaimTreeContentProvider implements IStructuredContentProvider {
	
	private static ClaimTreeContentProvider instance = null;

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Object[]) {
			return (Object[]) inputElement;
		}
        if (inputElement instanceof Collection) {
			return ((Collection) inputElement).toArray();
		}
        return new Object[0];
	}
	
	public static ClaimTreeContentProvider getInstance(){
		if (instance== null){
			instance = new ClaimTreeContentProvider();
		}
		return instance;
	}

}
