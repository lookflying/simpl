package syntax;

import semantic.Env;
import type.NullType;
import type.Type;

public class NullValue extends Value {

	@Override
	public Type getType() {
		return NullType.getInstance();
	}

	@Override
	public Value execute(Env env) {
		return this;
	}
	
	private static NullValue instance = new NullValue();
	
	public static NullValue getInstance() {
		return instance;
	}

}
