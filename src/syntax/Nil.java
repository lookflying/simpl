package syntax;

import semantic.Env;
import type.ListType;
import type.Type;

public class Nil extends ListValue{
	public Nil(int l, int c) {
		super(l, c);
	}
	public String toString(){
		return "nil";
	}

	@Override
	public Type getType() {
		return ListType.getDummyInstance();
	}

	@Override
	public Value execute(Env env) {
		return this;
	}
	
	@Override
	public boolean equals(Value other) {
		return other instanceof Nil;
	}
}