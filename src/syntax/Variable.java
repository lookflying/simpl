package syntax;

import semantic.Env;

public class Variable extends Expression {
	String name;

	public Variable(String x, int l, int c) {
		super(l, c);
		name = x;
	}

	public String toString() {
		return name;
	}

	@Override
	public Value execute(Env env) {
		report();
		return env.lookUpValue(name);
	}

	public Variable clone() {
		return new Variable(name, line, column);
	}
}