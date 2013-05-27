package parse;

import run.SimplException;

public class SyntaxException extends SimplException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SyntaxException(String msg) {
		super("Syntax error: " + msg);
	}
}
