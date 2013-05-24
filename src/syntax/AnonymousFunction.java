package syntax;

public class AnonymousFunction extends Value{
	Variable arg;
	Expression body;
	
	public AnonymousFunction(String x, Object e) {
		arg = new Variable(x);
		body = (Expression)e;
	}


	public String toString(){
		return "fun " + arg.toString() + " -> " + body.toString();
	}
}