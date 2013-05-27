package syntax;

import semantic.Env;
import semantic.UnexpectedException;
import type.BoolType;
import type.IntType;

public class BinaryOperation extends Expression {
	public enum BinaryOperator {
		plus, minus, times, devide, biggerThan, lessThan, equal, and, or
	}

	Expression e1;
	Expression e2;
	BinaryOperator op;

	public BinaryOperation(Object e12, Object b, Object e22, int l, int c) {
		super(l, c);
		e1 = (Expression) e12;
		op = (BinaryOperation.BinaryOperator) b;
		e2 = (Expression) e22;
	}

	public String toString() {
		String operator = "";
		switch (this.op) {
		case plus:
			operator = "+";
			break;
		case minus:
			operator = "-";
			break;
		case times:
			operator = "*";
			break;
		case devide:
			operator = "/";
			break;
		case biggerThan:
			operator = ">";
			break;
		case lessThan:
			operator = "<";
			break;
		case equal:
			operator = "=";
			break;
		case and:
			operator = "and";
			break;
		case or:
			operator = "or";
			break;
		}
		return e1.toString() + " " + operator + " " + e2.toString();
	}

	@Override
	public Value execute(Env env) {
		Value left = e1.execute(env);
		Value right = e2.execute(env);
		switch (this.op) {
		case plus:
			left.check(IntType.getInstance(), true);
			right.check(IntType.getInstance(), true);
			if (((IntValue) left).isUndef() || ((IntValue) right).isUndef()) {
				return new IntValue(line, column);
			} else {
				return new IntValue(((IntValue) left).value
						+ ((IntValue) right).value, line, column);
			}
		case minus:
			left.check(IntType.getInstance(), true);
			right.check(IntType.getInstance(), true);
			if (((IntValue) left).isUndef() || ((IntValue) right).isUndef()) {
				return new IntValue(line, column);
			} else {
				return new IntValue(((IntValue) left).value
						- ((IntValue) right).value, line, column);
			}
		case times:
			left.check(IntType.getInstance(), true);
			right.check(IntType.getInstance(), true);
			if (((IntValue) left).isUndef() || ((IntValue) right).isUndef()) {
				return new IntValue(line, column);
			} else {
				return new IntValue(((IntValue) left).value
						* ((IntValue) right).value, line, column);
			}
		case devide:
			left.check(IntType.getInstance(), true);
			right.check(IntType.getInstance(), true);
			if (((IntValue) left).isUndef() || ((IntValue) right).isUndef()) {
				return new IntValue(line, column);
			} else if (((IntValue) right).value == 0) {
				return new IntValue(line, column);
			} else {
				return new IntValue(((IntValue) left).value
						/ ((IntValue) right).value, line, column);
			}
		case biggerThan:
			left.check(IntType.getInstance(), true);
			right.check(IntType.getInstance(), true);
			if (((IntValue) left).isUndef() || ((IntValue) right).isUndef()) {
				return new BoolValue(line, column);
			} else {
				return new BoolValue(
						((IntValue) left).value > ((IntValue) right).value,
						line, column);
			}
		case lessThan:
			left.check(IntType.getInstance(), true);
			right.check(IntType.getInstance(), true);
			if (((IntValue) left).isUndef() || ((IntValue) right).isUndef()) {
				return new BoolValue(line, column);
			} else {
				return new BoolValue(
						((IntValue) left).value < ((IntValue) right).value,
						line, column);
			}
		case equal:
			if (left instanceof IntValue && right instanceof IntValue) {
				if (((IntValue) left).isUndef() || ((IntValue) right).isUndef()) {
					return new BoolValue(line, column);
				}
			}
			return new BoolValue(left.equals(right), line, column);
		case and:
			left.check(BoolType.getInstance(), true);
			right.check(BoolType.getInstance(), true);
			if (((BoolValue) left).isUndef() || ((BoolValue) left).isUndef()) {
				return new BoolValue(line, column);
			} else {
				return new BoolValue(((BoolValue) left).value
						&& ((BoolValue) right).value, line, column);
			}
		case or:
			left.check(BoolType.getInstance(), true);
			right.check(BoolType.getInstance(), true);
			if (((BoolValue) left).isUndef() || ((BoolValue) left).isUndef()) {
				return new BoolValue(line, column);
			} else {
				return new BoolValue(((BoolValue) left).value
						|| ((BoolValue) right).value, line, column);
			}
		}
		throw new UnexpectedException();
	}
}