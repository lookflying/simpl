package syntax;

import semantic.Env;
import type.NullType;

public class List extends Expression {
	Expression head;
	Expression tail;	
	
	public List(Object e1, Object e2) {
		head = (Expression)e1;
		tail = (Expression)e2;
	}

	public String toString() {
		return "[" + head.toString() + ", " + tail.toString() + "]";
	}

	@Override
	public Value execute(Env env) {
		Value hvalue = head.execute(env);
		Value tvalue = tail.execute(env);
		return new ListValue(hvalue, tvalue);
	}
}