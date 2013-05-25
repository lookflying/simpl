package syntax;

import semantic.Env;
import semantic.UnexpectedException;
import type.BoolType;
import type.IntType;

public class BinaryOperation extends Expression{
	public enum BinaryOperator{
		plus, minus, times, devide, biggerThan, lessThan, equal, and, or
	}
	
	Expression e1;
	Expression e2;
	BinaryOperator op;
	
	public BinaryOperation(Object e12, Object b, Object e22) {
		e1 = (Expression)e12;
		op = (BinaryOperation.BinaryOperator) b;
		e2 = (Expression)e22;
	}

	public String toString(){
		String operator = "";
		switch(this.op){
		case plus:
			operator = "+"; break;
		case minus:
			operator = "-"; break;
		case times:
			operator = "*"; break;
		case devide:
			operator = "/"; break;
		case biggerThan:
			operator = ">"; break;
		case lessThan:
			operator = "<"; break;
		case equal:
			operator = "="; break;
		case and:
			operator = "and"; break;
		case or:
			operator = "or"; break;
		}
		return e1.toString() + " " + operator + " " + e2.toString();
	}

	@Override
	public Value execute(Env env) {
		Value left = e1.execute(env);
		Value right = e2.execute(env);
		switch(this.op){
		case plus:
			left.check(IntType.getInstance(), false);
			right.check(IntType.getInstance(), false);
			return new IntValue(((IntValue)left).value + ((IntValue)right).value);
		case minus:
			left.check(IntType.getInstance(), false);
			right.check(IntType.getInstance(), false);
			return new IntValue(((IntValue)left).value - ((IntValue)right).value);
		case times:
			left.check(IntType.getInstance(), false);
			right.check(IntType.getInstance(), false);
			return new IntValue(((IntValue)left).value * ((IntValue)right).value);
		case devide:
			left.check(IntType.getInstance(), false);
			right.check(IntType.getInstance(), false);
			return new IntValue(((IntValue)left).value / ((IntValue)right).value);
		case biggerThan:
			left.check(IntType.getInstance(), false);
			right.check(IntType.getInstance(), false);
			return new BoolValue(((IntValue)left).value > ((IntValue)right).value);
		case lessThan:
			left.check(IntType.getInstance(), false);
			right.check(IntType.getInstance(), false);
			return new BoolValue(((IntValue)left).value < ((IntValue)right).value);
		case equal:
			left.check(IntType.getInstance(), false);
			right.check(IntType.getInstance(), false);
			return new BoolValue(((IntValue)left).value == ((IntValue)right).value);
		case and:
			left.check(BoolType.getInstance(), false);
			right.check(BoolType.getInstance(), false);
			return new BoolValue(((BoolValue)left).value && ((BoolValue)right).value);
		case or:
			left.check(BoolType.getInstance(), false);
			right.check(BoolType.getInstance(), false);
			return new BoolValue(((BoolValue)left).value || ((BoolValue)right).value);
		}
		throw new UnexpectedException();
	}
	
}