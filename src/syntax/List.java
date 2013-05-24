package syntax;

public class List extends Expression{
	Expression head;
	Expression tail;	
	
	public List(Object e1, Object e2) {
		head = (Expression)e1;
		tail = (Expression)e2;
	}

	public String toString(){
		return "[" + head.toString() + ", " + tail.toString() + "]";
	}
}