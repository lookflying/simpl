package semantic;
//import syntax.*;
import syntax.Value;
import type.*;
public class Env {
	Block currentBlock = null;
	public Env(){
		beginScope();
	}
	public void beginScope(){
		currentBlock = new Block(currentBlock);
	}
	public void endScope(){
		currentBlock = currentBlock.father;
	}
	public Type lookUpType(String id){
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
	public Value lookUpValue(String id){
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
	public void createEntry(String id, Type t, Value v){
		currentBlock.onion(id, t, v);
	}
	
	public void onion(String id, Type t, Value v){
		currentBlock.onion(id, t, v);
	}
//	public Object translate(Expression e){
//		
//		return null;
//	}
//	public Object translate(BinaryOperation e){
//		return null;
//	}
	
}
