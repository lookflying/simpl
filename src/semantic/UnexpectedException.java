package semantic;

import run.SimplException;

public class UnexpectedException extends SimplException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnexpectedException(String message) {
		super(message);
	}
	
	public UnexpectedException() {
		super("Unexcepted exception");
	}
}
