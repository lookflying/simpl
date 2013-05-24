package syntax;

public class Tail extends Expression{
	Expression e;	
	
	public Tail(Object e2) {
		e = (Expression)e2;
	}

	public String toString(){
		return "tail " + e.toString();
	}
}