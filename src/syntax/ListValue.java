package syntax;

import semantic.Env;
import type.ListType;
import type.NullType;
import type.Type;

public class ListValue extends Value{
	Value head;
	Value tail;
	
	ListType type = null;
	
	public ListValue(Object v1, Object v2) {
		head = (Value)v1;
		tail = (Value)v2;// TODO
		Type headType = head == null ? NullType.getInstance() : head.getType();
		Type tailType = tail == null ? NullType.getInstance() : tail.getType();
	}

	public String toString(){
		return "[" + head.toString() + ", " + tail.toString() + "]";
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public Value execute(Env env) {
		return this;
	}
}