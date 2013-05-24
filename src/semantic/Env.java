package semantic;
import syntax.*;
import type.*;
public class Env {
	Block currentBlock = null;
	public Env(){
		beginScope();
	}
	void beginScope(){
		currentBlock = new Block(currentBlock);
	}
	void endScope(){
		currentBlock = currentBlock.father;
	}
	Type lookUpType(String id){
		Block b = currentBlock;
		while(b != null){
			if (b.getType(id) != null){
				return b.getType(id);
			}else{
				b = b.father;
			}
		}
		return null;
	}
	Object lookUpValue(String id){
		Block b = currentBlock;
		while(b != null){
			if (b.getValue(id) != null){
				return b.getValue(id);
			}else{
				b = b.father;
			}
		}
		return null;
	}
	void createEntry(String id, Type t, Object v){
		currentBlock.onion(id, t, v);
	}
	public Object translate(Expression e){
		
		return null;
	}
	public Object translate(BinaryOperation e){
		return null;
	}
	
}
