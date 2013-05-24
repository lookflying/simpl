package parse;

public class ErrorMessage {
	static StringBuilder sb = new StringBuilder();
	static int currentLine = -1;
	static int currentColumn = -1;
	static String fileName = "";
	static boolean debug = false;
	public static void setDebug(boolean d){
		debug = d;
	}
	public static void setFile(String name){
		fileName = name;
	}
	public static void report(String text, int line, int column){
		if (line != currentLine){
			if (debug){
				System.out.println(sb.toString());
			}
			sb = new StringBuilder();
			currentLine = line;
		}
		currentColumn = column;
		while (sb.length() < column){
			sb.append(" ");
		}
		sb.append(text);
	}
	
	public static String pos(){
		return String.format("Line: %d, Column: %d", currentLine + 1, currentColumn + 1);
	}
	public static String context(){
		return sb.toString();
	}

}