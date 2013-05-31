package syntax;

import semantic.Env;
import type.BoolType;
import type.Type;

public class BoolValue extends Value {
	boolean value;
	boolean isUndef;

	public BoolValue(Boolean b, int l, int c) {
		super(l, c);
		value = b;
		isUndef = false;
	}

	public BoolValue(int l, int c) {
		super(l, c);
		isUndef = true;
		value = false;
	}

	public boolean isUndef() {
		return isUndef;
	}

	public String toString() {
		if (isUndef) {
			return "undef";
		} else {
			if (value)
				return "true";
			else
				return "false";
		}
	}

	@Override
	public Value execute(Env env) {
		report();
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
		BoolValue bv = (BoolValue) other;
		return this.value == bv.value;
	}

	public BoolValue clone() {
		BoolValue ret = new BoolValue(line, column);
		ret.value = this.value;
		ret.isUndef = this.isUndef;
		return ret;
	}
}