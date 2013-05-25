package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
import type.PairType;

public class Second extends Expression{
	Expression e;
	
	public Second(Object e2) {
		e = (Expression)e2;
	}

	public String toString(){
		return "snd " + e.toString();
	}

	@Override
	public Value execute(Env env) {
		Value v = e.execute(env);
		if (v.getType() instanceof PairType == false) {
			throw new TypeMismatchException(PairType.getDummyInstance(), v.getType());
		}
		PairValue pv = (PairValue)v;
		return pv.e2;
	}
}