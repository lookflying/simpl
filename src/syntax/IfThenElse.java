package syntax;

public class IfThenElse extends Expression{
	Expression condition;
	Expression thenClause;
	Expression elseClause;
	
	public IfThenElse(Object e1, Object e2, Object e3) {
		condition = (Expression)e1;
		thenClause = (Expression)e2;
		elseClause = (Expression)e3;
	}

	public String toString(){
		return "if " + condition.toString() + " then " + thenClause.toString() + " else " + elseClause.toString() + " end";
	}
}