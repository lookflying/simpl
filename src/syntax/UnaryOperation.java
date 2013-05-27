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

	public UnaryOperation(Object u, Object e2, int l, int c) {
		super(l, c);
		op = (UnaryOperation.UnaryOperator) u;
		e = (Expression) e2;
	}

	public String toString() {
		String operator = "";
		switch (op) {
		case not:
			operator = "not ";
			break;
		case negative:
			operator = "~";
			break;
		}
		return operator + e.toString();
	}

	@Override
	public Value execute(Env env) {
		report();
		Value v = e.execute(env);
		switch (op) {
		case not:
			v.check(BoolType.getInstance(), false);
			return new BoolValue(!((BoolValue)v).value, line, column);
		case negative:
			v.check(IntType.getInstance(), false);
			return new IntValue(((IntValue)v).value * -1, line, column);
		default:
			throw new UnexpectedException();
		}
	}
}