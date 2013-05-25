package syntax;

import semantic.Env;

public class Variable extends Expression{
	String name;
	
	public Variable(String x) {
		name = x;
	}

	public String toString(){
		return name;
	}

	@Override
	public Object execute(Env env) {
		return env.lookUpValue(name);
	}
}