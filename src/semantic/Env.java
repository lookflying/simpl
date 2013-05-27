package semantic;

//import syntax.*;
import syntax.Value;

public class Env {
	Block currentBlock = null;

	public Env() {
		beginScope();
	}

	public void beginScope() {
		currentBlock = new Block(currentBlock);
	}

	public void beginScope(Block funBlock) {
		if (funBlock != currentBlock) {
			funBlock.setFather(currentBlock);
			currentBlock = funBlock;
		}
	}

	public Block getCurrentBlock() {
		return currentBlock;
	}

	public void endScope() {
		currentBlock = currentBlock.father;
	}

	public Value lookUpValue(String id) {
		Block b = currentBlock;
		while (b != null) {
			if (b.getValue(id) != null) {
				return b.getValue(id);
			} else {
				b = b.father;
			}
		}
		throw new VariableUndefinedException(id);
	}

	public void createEntry(String id, Value v) {
		currentBlock.onion(id, v);
	}

	public void onion(String id, Value v) {
		currentBlock.onion(id, v);
	}

}
