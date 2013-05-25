package syntax;

public class PairValue extends Value{
	Value e1;
	Value e2;
	
	public PairValue(Object v1, Object v2) {
		e1 = (Value)v1;
		e2 = (Value)v2;
	}

	public String toString(){
		return "(" + e1.toString() + ", " + e2.toString() + ")";
	}
}