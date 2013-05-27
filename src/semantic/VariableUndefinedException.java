package semantic;

public class VariableUndefinedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VariableUndefinedException(String msg) {
		super("variable \"" + msg + "\" is undefined");
	}

}
