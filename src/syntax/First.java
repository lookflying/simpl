package syntax;

public class First extends Expression{
	Expression e;
	
	public First(Object e2) {
		e = (Expression)e2;
	}

	public String toString(){
		return "fst " + e.toString();
	}
}