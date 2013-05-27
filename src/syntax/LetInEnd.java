package syntax;

import semantic.Env;

public class LetInEnd extends Expression {
	Variable x;
	Expression definition;
	Expression body;

	public LetInEnd(String x2, int xl, int xc, Object e1, Object e2, int l,
			int c) {
		super(l, c);
		x = new Variable(x2, xl, xc);
		definition = (Expression) e1;
		body = (Expression) e2;
	}

	public String toString() {
		return "let " + x.toString() + " = " + definition.toString() + " in "
				+ body.toString() + " end";
	}

	@Override
	public Value execute(Env env) {
		report();
		env.beginScope();
		Value xval = definition.execute(env);
		env.createEntry(x.name, xval);
		Value rval = body.execute(env);
		env.endScope();
		return rval;
	}
}