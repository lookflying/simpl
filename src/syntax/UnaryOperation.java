package syntax;

import semantic.Env;
import semantic.UnexpectedException;
import type.BoolType;
import type.IntType;

public class UnaryOperation extends Expression {
	public enum UnaryOperator {
		not, negative
	}

	Expression e;
	UnaryOperator op;

	public UnaryOperation(Object u, Object e2) {
		op = (UnaryOperation.UnaryOperator) u;
		e = (Expression) e2;
	}

	public String toString() {
		String operator = "";
		switch (op) {
		case not:
			operator = "~";
			break;
		case negative:
			operator = "not ";
			break;
		}
		return operator + e.toString();
	}

	@Override
	public Value execute(Env env) {
		Value v = e.execute(env);
		switch (op) {
		case not:
			v.check(BoolType.getInstance(), false);
			break;
		case negative:
			v.check(IntType.getInstance(), false);
			break;
		default:
			throw new UnexpectedException();
		}
		return v;
	}
}