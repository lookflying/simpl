package syntax;

import semantic.Env;
import type.Type;
import type.UnitType;

public class UnitValue extends Value {

	public UnitValue(int l, int c) {
		super(l, c);
	}

	@Override
	public Type getType() {
		return UnitType.getInstance();
	}

	@Override
	public Value execute(Env env) {
		return this;
	}

	private static UnitValue instance = new UnitValue(-1, -1);

	public static UnitValue getInstance() {
		return instance;
	}

}
