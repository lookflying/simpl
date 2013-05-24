package syntax;

public class Head extends Expression {
	Expression e;

	public Head(Object e2) {
		e = (Expression) e2;
	}

	public String toString() {
		return "head " + e.toString();
	}
}