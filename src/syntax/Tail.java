package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
import type.ListType;

public class Tail extends Expression{
	Expression e;	
	
	public Tail(Object e2, int l, int c) {
		super(l, c);
		e = (Expression)e2;
	}

	public String toString(){
		return "tail " + e.toString();
	}

	@Override
	public Value execute(Env env) {
		report();
		Value v = e.execute(env);
		if (v.getType() instanceof ListType == false) {
			throw new TypeMismatchException(ListType.getDummyInstance(), v.getType());
		}
		ListValue lv = (ListValue)v;
		if (lv instanceof Nil) {
			return new Nil(line, column);
		} else {
			return lv.tail;
		}
	}
	
	public Tail clone(){
		return new Tail(e.clone(), line, column);
	}
}