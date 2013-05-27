package syntax;

import semantic.Env;
import semantic.UnexpectedException;

public class Assignment extends Expression{
	Expression var;
	Expression val;
	
	public Assignment(Object e1, Object e2, int l, int c) {
		super(l, c);
		var = (Expression) e1;
		val = (Expression) e2;
	}

	public String toString(){
		return var.toString() + " := " + val.toString();
	}

	@Override
	public Value execute(Env env) {
		report();
		Value rightval = val.execute(env);
		if (var instanceof Variable == false) {
			// TODO
			throw new UnexpectedException();
		}
		env.onion(((Variable)var).name, rightval);
		return UnitValue.getInstance();
	}
}