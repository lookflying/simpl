package semantic;


import syntax.Value;

public class Block implements Cloneable{
	Block father;
	Map memory;

	public Block() {
		father = null;
		memory = new Map();
	}

	public void setFather(Block f) {
		father = f;
	}

	public Block getFather() {
		return father;
	}

	public Block(Block f) {
		father = f;
		memory = new Map();
	}

	public Value getValue(String id) {
		return memory.query(id);
	}

	public void onion(String id, Value v) {
		memory.onion(id, v);
	}
	
	public String toString(){
		return memory.toString();
	}
	
	public Block clone(){
		Block nb = new Block();
		nb.father = this.father;
		nb.memory = this.memory.clone();
		return nb;
	}

}
