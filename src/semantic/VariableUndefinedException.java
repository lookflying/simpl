package semantic;

import run.SimplException;

public class VariableUndefinedException extends SimplException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VariableUndefinedException(String msg) {
		super("Runtime exception: variable \"" + msg + "\" is undefined");
	}

}
