package syntax;

public class Assignment extends Expression{
	Expression var;
	Expression val;
	
	public Assignment(Object e1, Object e2) {
		var = (Expression) e1;
		val = (Expression) e2;
	}

	public String toString(){
		return var.toString() + " := " + val.toString();
	}
}