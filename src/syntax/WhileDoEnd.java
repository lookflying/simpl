package syntax;

public class WhileDoEnd extends Expression{
	Expression condition;
	Expression body;
	
	public WhileDoEnd(Object e1, Object e2) {
		condition = (Expression)e1;
		body = (Expression)e2;
	}

	public String toString(){
		return "while " + condition.toString() + " do " + body.toString() + " end";
	}
}
