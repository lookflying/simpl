package syntax;

import semantic.Env;
import semantic.TypeMismatchException;
import type.ListType;
import type.NullType;
import type.Type;

public class ListValue extends Value{
	Value head;
	Value tail;
	
	ListType type = null;
	
	public ListValue(Object v1, Object v2, int l, int c) {
		super(l, c);
		head = (Value)v1;
		tail = (Value)v2;
		Type headType = head == null ? NullType.getInstance() : head.getType();
		Type tailType = tail == null ? NullType.getInstance() : tail.getType();
		type = new ListType(headType);
		if (tailType instanceof ListType == false) {
			throw new TypeMismatchException(type, tailType);
		}
		ListType listTailType = (ListType)tailType;
		if (listTailType.getElementType().equals(NullType.getInstance()) == false
				&& listTailType.getElementType().equals(headType) == false) {
			throw new TypeMismatchException(type, tailType);
		}
	}
	
	protected ListValue(int l, int c){
		super(l, c);
	}

	public String toString(){
		String str = "[";
		ListValue  v = this;
		while (v.tail instanceof Nil == false) {
			str += v.head.toString() + " ";
			v = (ListValue)v.tail;
		}
		return str + v.head.toString() + "]";
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