package syntax;

import semantic.Env;
import type.FunType;
import type.NullType;
import type.Type;

public class AnonymousFunction extends Value{
	Variable arg;
	Expression body;
	
	public AnonymousFunction(String x, Object e) {
		arg = new Variable(x);
		body = (Expression)e;
		// TODO
		type = new FunType(NullType.getInstance(), NullType.getInstance());
	}


	public Variable getArg() {
		return arg;
	}


	public Expression getBody() {
		return body;
	}


	public String toString(){
		return "fun " + arg.toString() + " -> " + body.toString();
	}
	
	private Type type;

	@Override
	public Type getType() {
		return type;
	}


	@Override
	public Value execute(Env env) {
		return this;
	}
}