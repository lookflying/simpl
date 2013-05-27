package syntax;

import semantic.Env;
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
		isUndef = false;
	}
	
	public IntValue(int l, int c){
		super(l, c);
		isUndef = true;
		value = 0;
	}

	public String toString(){
		if(isUndef)
			return "undef";
		else
			return String.valueOf(value);
	}
	public Value execute(Env env) {
		report();
		return this;
	}

	@Override
	public Type getType() {
		return IntType.getInstance();
	}
	


	@Override
	public boolean equals(Value other) {
		if (other instanceof IntValue == false) {
			return false;
		}
		IntValue iv = (IntValue)other;
		return this.isUndef == iv.isUndef && (isUndef == true || this.value == iv.value);
	}
}