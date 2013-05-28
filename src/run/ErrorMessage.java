package run;

public class ErrorMessage {
	static StringBuilder sb = new StringBuilder();
	static int currentLine = -1;
	static int currentColumn = -1;
	static String fileName = "";
	static boolean debug = false;
	static int lineOffset = 0;
	static int columnOffset = 0;

	public static void setDebug(boolean d) {
		debug = d;
	}

	public static void setFile(String name) {
		fileName = name;
	}

	/**
	 * 
	 * @param lo
	 *            start from 1
	 * @param co
	 *            start from 1
	 */
	public static void init(int lo, int co) {
		lineOffset = lo - 1;
		columnOffset = co - 1;
	}

	/**
	 * 
	 * @param line
	 *            start from 0
	 * @param column
	 *            start from 0
	 */
	public static void report(int line, int column) {
		currentLine = line;
		currentColumn = column;
	}

	/**
	 * 
	 * @param text
	 * @param line
	 *            start from 0
	 * @param column
	 *            start from 0
	 */
	public static void report(String text, int line, int column) {
		if (line != currentLine) {
			if (debug) {
				System.out.println(sb.toString());
			}
			sb = new StringBuilder();
			currentLine = line;
		}
		currentColumn = column;
		while (sb.length() < column) {
			sb.append(" ");
		}
		sb.append(text);
	}

	public static String pos() {
		if (currentLine == 0) {
			return String.format("at line: %d, column: %d", currentLine
					+ lineOffset + 1, currentColumn + columnOffset + 1);
		} else {
			return String.format("at line: %d, column: %d", currentLine + 1,
					currentColumn + columnOffset + 1);
		}
	}

	public static String context() {
		return sb.toString();
	}

}
