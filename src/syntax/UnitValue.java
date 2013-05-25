package syntax;

import semantic.Env;
import type.Type;
import type.UnitType;

public class UnitValue extends Value {

	@Override
	public Type getType() {
		return UnitType.getInstance();
	}

	@Override
	public Value execute(Env env) {
		return this;
	}
	
	private static UnitValue instance = new UnitValue();
	
	public static UnitValue getInstance() {
		return instance;
	}

}
