package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
import semantic.ValueUndefinedException;
import type.IntType;
import type.Type;

public class IntValue extends Value{
	boolean isUndef;
	int value;

	public boolean isUndef() {
		return isUndef;
	}

	public int getValue() {
		return value;
	}

	public IntValue(Integer i, int l, int c) {
		super(l, c);
		value = i;
	}

	public String toString(){
		if(isUndef)
			return "undef";
		else
			return String.valueOf(value);
	}
	public Value execute(Env env) {
		return this;
	}

	@Override
	public Type getType() {
		return IntType.getInstance();
	}
	
	@Override
	public void check(Type type, boolean canUndef) {
		super.check(type, canUndef);
		if (canUndef == false && isUndef == true) {
			throw new ValueUndefinedException();
		}
	}
}