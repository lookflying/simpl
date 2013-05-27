package run;
import semantic.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

import parse.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		boolean ok = true;
		if (args.length > 0) {
			String filename = args[0];

//			ErrorMessage.setDebug(true);
			try {
				parser p = new parser(new Lexer(new FileReader(filename)));
				 p.parse();
				 System.out.println(p.result.toString());
				 Env env = new Env();
				 System.out.println(p.result.execute(env));
			} catch (FileNotFoundException e) {
				System.out.println(String.format("No such file: %s.", filename));
				ok = false;
				System.out.println(ErrorMessage.pos());
			} catch (SyntaxError e) {
				ok = false;
				System.out.println(e.getMessage());
				System.out.println(ErrorMessage.pos());
				e.printStackTrace();
			}catch (RuntimeException e){
				System.out.println(e.getMessage());
				System.out.println(ErrorMessage.pos());
			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
				System.exit(ok?0:1);
			}
		}
		System.exit(ok?0:1);
	}

}
