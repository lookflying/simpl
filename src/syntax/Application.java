package syntax;

public class Application extends Expression {
	Expression func;
	Expression param;

	public Application(Object e1, Object e2) {
		func = (Expression) e1;
		param = (Expression) e2;
	}

	public String toString() {
		return "(" + func.toString() + " " + param.toString() + ")";
	}
}