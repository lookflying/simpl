package syntax;

import semantic.Env;
import type.BoolType;

public class IfThenElse extends Expression{
	Expression condition;
	Expression thenClause;
	Expression elseClause;
	
	public IfThenElse(Object e1, Object e2, Object e3, int l, int c) {
		super(l, c);
		condition = (Expression)e1;
		thenClause = (Expression)e2;
		elseClause = (Expression)e3;
	}

	public String toString(){
		return "if " + condition.toString() + " then " + thenClause.toString() + " else " + elseClause.toString() + " end";
	}

	@Override
	public Value execute(Env env) {
		Value condvalue = condition.execute(env);
		condvalue.check(BoolType.getInstance(), false);
		if (((BoolValue)condvalue).value) {
			return thenClause.execute(env);
		} else {
			return elseClause.execute(env);
		}
	}
}