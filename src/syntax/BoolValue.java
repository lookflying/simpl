package syntax;

import semantic.Env;
import type.BoolType;
import type.Type;

public class BoolValue extends Value {
	boolean value;

	public BoolValue(Boolean b, int l, int c) {
		super(l, c);
		value = b;
	}

	public String toString() {
		if (value)
			return "true";
		else
			return "false";
	}

	@Override
	public Value execute(Env env) {
		return this;
	}

	@Override
	public Type getType() {
		return BoolType.getInstance();
	}
	
	public boolean getValue() {
		return value;
	}

	@Override
	public boolean equals(Value other) {
		if (other instanceof BoolValue == false) {
			return false;
		}
		BoolValue bv = (BoolValue)other;
		return this.value == bv.value;
	}
}