package syntax;

import semantic.Env;

public abstract class Expression {
	abstract public Value execute(Env env);
}