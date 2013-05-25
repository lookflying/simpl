package syntax;

import semantic.Env;

public class Bracket extends Expression{
	Expression e;
	
	public Bracket(Object e2, int l, int c) {
		super(l, c);
		e = (Expression) e2;
	}

	public String toString(){
		return "(" + e.toString() + ")";
	}

	@Override
	public Value execute(Env env) {
		return e.execute(env);
	}
	
	
}