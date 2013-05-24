package syntax;

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
	
}