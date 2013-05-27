package syntax;

import semantic.Env;
import run.ErrorMessage;

public abstract class Expression {
	int line;
	int column;

	public Expression(int l, int c) {
		line = l;
		column = c;
	}
	public void report(){
		ErrorMessage.report(line, column);
	}

	abstract public Value execute(Env env);
}