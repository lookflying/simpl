package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
import type.FunType;

public class Application extends Expression {
	Expression func;
	Expression param;

	public Application(Object e1, Object e2, int l, int c) {
		super(l, c);
		func = (Expression) e1;
		param = (Expression) e2;
	}

	public String toString() {
		return "(" + func.toString() + " " + param.toString() + ")";
	}

	@Override
	public Value execute(Env env) {
		report();
		Value funcvaluexx = func.execute(env);
		if (funcvaluexx.getType() instanceof FunType == false) {
			throw new TypeMismatchException(FunType.getDummyInstance(), funcvaluexx.getType());
		}
		AnonymousFunction function = (AnonymousFunction)funcvaluexx;
		Value paramvalue = param.execute(env);
		env.beginScope(function.execBlock);
		env.createEntry(function.getArg().name, paramvalue.clone());
		Value rval = function.getBody().execute(env);
		env.endScope();
		return rval;
	}
	public Expression clone(){
		return new Application(func.clone(), param.clone(), line, column);
	}
}