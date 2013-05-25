package semantic;

import type.Type;

public class TypeMismatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param expected
	 * @param got
	 */
	public TypeMismatchException(Type expected, Type got) {
		super("expected " + expected.getName() + ", got " + got.getName());
	}
}
