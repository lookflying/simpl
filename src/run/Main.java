package run;

import java.io.FileNotFoundException;
import java.io.FileReader;

import parse.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean ok = true;
		if (args.length > 0) {
			String filename = args[0];

			ErrorMessage.setDebug(true);
			try {
				parser p = new parser(new Lexer(new FileReader(filename)));
				 p.parse();
				 System.out.println(p.result.toString());
				 
			} catch (FileNotFoundException e) {
				System.out.println(String.format("No such file: %s.", filename));
				ok = false;
			} catch (Exception e) {
				ok = false;
				System.out.println(ErrorMessage.pos());
			}finally{
				System.exit(ok?0:1);
			}
		}
		System.exit(ok?0:1);
	}

}