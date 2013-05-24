package syntax;

public class UnaryOperation extends Expression{
	public enum UnaryOperator{
		not, negative
	}
	
	Expression e;
	UnaryOperator op;

	public UnaryOperation(Object u, Object e2) {
		op = (UnaryOperation.UnaryOperator)u;
		e = (Expression)e2;
	}

	public String toString(){
		String operator = "";
		switch(op){
		case not:
			operator = "~"; break;
		case negative:
			operator = "not "; break;
		}
		return operator + e.toString();
	}
}