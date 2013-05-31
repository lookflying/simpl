package syntax;

import semantic.Env;
import type.PairType;
import type.Type;

public class PairValue extends Value {
	Value e1;
	Value e2;

	private PairType type;

	public PairValue(Object v1, Object v2, int l, int c) {
		super(l, c);
		e1 = (Value) v1;
		e2 = (Value) v2;
		type = new PairType(e1.getType(), e2.getType());
	}

	public String toString() {
		return "(" + e1.toString() + ", " + e2.toString() + ")";
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public Value execute(Env env) {
		report();
		return this;
	}

	@Override
	public boolean equals(Value other) {
		if (other instanceof PairValue == false) {
			return false;
		}
		PairValue pv = (PairValue) other;

		return e1.equals(pv.e1) && e2.equals(pv.e2);
	}

	public PairValue clone() {
		return new PairValue(e1.clone(), e2.clone(), line, column);
	}
}