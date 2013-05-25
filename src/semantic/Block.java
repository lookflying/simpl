package semantic;

import syntax.Value;
import type.*;

public class Block {
	public Block father;
	Map<Type> typeMap;
	Map<Value> memory;
	public Block(Block f){
		father = f;
		typeMap = new Map<Type>();
		memory = new Map<Value>();
	}
	public Type getType(String id){
		return typeMap.query(id);
	}
	public Value getValue(String id){
		return memory.query(id);
	}
	public void onion(String id, Type t, Value v){
		typeMap.onion(id, t);
		memory.onion(id, v);
	}
	
}
