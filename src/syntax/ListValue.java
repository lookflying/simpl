package syntax;

public class ListValue extends Value{
	Value head;
	Value tail;
	
	public ListValue(Object v1, Object v2) {
		head = (Value)v1;
		tail = (Value)v2;
	}

	public String toString(){
		return "[" + head.toString() + ", " + tail.toString() + "]";
	}
}