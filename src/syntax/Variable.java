package syntax;

public class Variable extends Expression{
	String name;
	
	public Variable(String x) {
		name = x;
	}

	public String toString(){
		return name;
	}
}