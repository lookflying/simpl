package syntax;

import semantic.Env;
import type.ListType;
import type.Type;

public class Nil extends Value{
	public String toString(){
		return "nil";
	}

	@Override
	public Type getType() {
		return ListType.getDummyInstance();
	}

	@Override
	public Value execute(Env env) {
		return ListValue.getNilInstance();
	}
}