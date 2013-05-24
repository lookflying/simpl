package syntax;

public class Second extends Expression{
	Expression e;
	
	public Second(Object e2) {
		e = (Expression)e2;
	}

	public String toString(){
		return "snd " + e.toString();
	}
}