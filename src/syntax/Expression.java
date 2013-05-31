package syntax;

import semantic.Env;
import semantic.UnexpectedException;
import run.ErrorMessage;

public abstract class Expression implements Cloneable{
	int line;
	int column;

	public Expression(int l, int c) {
		line = l;
		column = c;
	}
	public void report(){
		ErrorMessage.report(line, column);
	}

	abstract public Value execute(Env env);
	
	public Expression clone()
	{
		throw new UnexpectedException("Expression can't be cloned");
		
	}
}