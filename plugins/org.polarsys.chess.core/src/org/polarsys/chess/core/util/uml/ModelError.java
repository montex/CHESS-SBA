package org.polarsys.chess.core.util.uml;

public class ModelError extends Exception {

	public ModelError(String message) {
		super(message);
	}
	
	public ModelError(String messageFormat, Object... args) {
		super(String.format(messageFormat, args));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3470869043917284064L;

}
