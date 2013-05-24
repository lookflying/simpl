package semantic;

import type.*;

public class Block {
	public Block father;
	Map<Type> typeMap;
	Map<Object> memory;
	public Block(Block f){
		father = f;
		typeMap = new Map<Type>();
		memory = new Map<Object>();
	}
	public Type getType(String id){
		return typeMap.query(id);
	}
	public Object getValue(String id){
		return memory.query(id);
	}
	public void onion(String id, Type t, Object v){
		typeMap.onion(id, t);
		memory.onion(id, v);
	}
	
}
