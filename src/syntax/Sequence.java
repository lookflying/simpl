package syntax;

import semantic.Env;

public class Sequence extends Expression{
	Expression e1;
	Expression e2;

	public Sequence(Object e12, Object e22) {
		e1 = (Expression)e12;
		e2 = (Expression)e22;
	}

	public String toString(){
		return e1.toString() + "; " + e2.toString();
	}

	@Override
	public Value execute(Env env) {
		e1.execute(env);
		Value v = e2.execute(env);
		return v;
	}
}