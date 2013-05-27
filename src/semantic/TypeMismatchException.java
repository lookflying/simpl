package semantic;

import run.SimplException;
import type.Type;

public class TypeMismatchException extends SimplException {

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
		super("Type mismatch: expected " + expected.getName() + ", got " + got.getName());
	}
}
