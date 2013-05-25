package syntax;

import semantic.TypeMismatchException;
import type.Type;

public abstract class Value extends Expression{
	public Value(int l, int c) {
		super(l, c);
	}
	public abstract Type getType();
	
	public void check(Type type, boolean canUndef) {
		if (type != null && getType().equals(type) == false) {
			throw new TypeMismatchException(type, this.getType());
		}
	}
}