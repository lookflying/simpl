package syntax;

import semantic.Env;
import type.Type;

public class Nop extends Value {
	public Nop(int l, int c) {
		super(l, c);
	}

	public String toString() {
		return "()";
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value execute(Env env) {
		return this;
	}

	@Override
	public boolean equals(Value other) {
		return other instanceof Nop;
	}
}