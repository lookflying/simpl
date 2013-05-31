package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
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
		report();
		return this;
	}
	
	@Override
	public boolean equals(Value other) {
		return other instanceof Nil;
	}
	
	public void check(Type type) {
		if (type instanceof ListType == false) {
			throw new TypeMismatchException(type, this.getType());
		}
	}
	public Nil clone(){
		return new Nil(line, column);
	}
}