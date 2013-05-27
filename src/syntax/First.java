package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
import type.PairType;

public class First extends Expression{
	Expression e;
	
	public First(Object e2, int l, int c) {
		super(l, c);
		e = (Expression)e2;
	}

	public String toString(){
		return "fst " + e.toString();
	}

	@Override
	public Value execute(Env env) {
		report();
		Value v = e.execute(env);
		if (v.getType() instanceof PairType == false) {
			throw new TypeMismatchException(PairType.getDummyInstance(), v.getType());
		}
		PairValue pv = (PairValue)v;
		
		return pv.e1;
	}
}