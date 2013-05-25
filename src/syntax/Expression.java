package syntax;

import semantic.Env;

public abstract class Expression {
	int line;
	int column;

	public Expression(int l, int c) {
		line = l;
		column = c;
	}

	abstract public Value execute(Env env);
}