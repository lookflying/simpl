package syntax;

import semantic.TypeMismatchException;
import semantic.UnexpectedException;
import type.Type;

public abstract class Value extends Expression{
	public Value(int l, int c) {
		super(l, c);
	}
	
	public abstract Type getType();
	
	public abstract boolean equals(Value other);
	
	public void check(Type type) {
		if (type != null && getType().equals(type) == false) {
			throw new TypeMismatchException(type, this.getType());
		}
	}
	public Value clone(){
		throw new UnexpectedException("Value can't be cloned");
	}
}