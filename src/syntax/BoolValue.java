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
}