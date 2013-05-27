package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
import type.ListType;

public class Head extends Expression {
	Expression e;

	public Head(Object e2, int l, int c) {
		super(l, c);
		e = (Expression) e2;
	}

	public String toString() {
		return "head " + e.toString();
	}

	@Override
	public Value execute(Env env) {
		report();
		Value v = e.execute(env);
		if (v.getType() instanceof ListType == false) {
			throw new TypeMismatchException(ListType.getDummyInstance(), v.getType());
		}
		ListValue lv = (ListValue)v;
		return lv.head;
	}
}