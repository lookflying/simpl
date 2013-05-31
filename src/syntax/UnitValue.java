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
		report();
		return this;
	}

	private static UnitValue instance = new UnitValue(-1, -1);

	public static UnitValue getInstance() {
		return instance;
	}

	@Override
	public boolean equals(Value other) {
		return other instanceof UnitValue;
	}
	
	public String toString(){
		return "()";
	}
	
	public UnitValue clone(){
		return new UnitValue(line, column);
	}

}
