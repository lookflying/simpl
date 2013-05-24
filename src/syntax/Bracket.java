package syntax;

public class Bracket extends Expression{
	Expression e;
	
	public Bracket(Object e2) {
		e = (Expression) e2;
	}

	public String toString(){
		return "(" + e.toString() + ")";
	}
}