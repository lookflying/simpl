package parse;

public class SyntaxError extends Exception {
	public SyntaxError(){
		super();
	}
	public SyntaxError(String msg){
		super(msg);
	}
}
