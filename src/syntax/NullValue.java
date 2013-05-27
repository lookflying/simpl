package syntax;

import semantic.Env;
import type.NullType;
import type.Type;

public class NullValue extends Value {
	public NullValue(int l, int c) {
		super(l, c);
	}

	@Override
	public Type getType() {
		return NullType.getInstance();
	}

	@Override
	public Value execute(Env env) {
		report();
		return this;
	}

	@Override
	public boolean equals(Value other) {
		return other instanceof NullValue;
	}

}
