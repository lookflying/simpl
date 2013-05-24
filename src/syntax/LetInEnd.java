package syntax;

public class LetInEnd extends Expression{
	Variable x;
	Expression definition;
	Expression body;
	
	public LetInEnd(String x2, Object e1, Object e2) {
		x = new Variable(x2);
		definition = (Expression)e1;
		body = (Expression)e2;
	}

	public String toString(){
		return "let " + x.toString() + " = " + definition.toString() + " in " + body.toString() + " end";
	}
}