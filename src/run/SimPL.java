package run;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import parse.Lexer;
import parse.SyntaxException;
import parse.parser;
import semantic.Env;
import semantic.TypeMismatchException;
import semantic.UnexpectedException;
import semantic.ValueUndefinedException;
import semantic.VariableUndefinedException;

public class SimPL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Options options = new Options();
			// -h parameter
			options.addOption("h", "help", false, "print usage");
			// -s parameter
			options.addOption("s", "shell", false, "interactive shell");
			// -f file
			options.addOption("f", "file", true, "execute file");
			
			CommandLineParser parser = new PosixParser();
			CommandLine cmd = parser.parse(options, args);
			
			if (cmd.hasOption("h")) {
				printUsage();
			} else if (cmd.hasOption("s")) {
				interactiveShell();
			} else if (cmd.hasOption("f")) {
				simplScriptFile(cmd.getOptionValue("f"));
			} else {
				printUsage();
				System.exit(-1);
			}
		} catch (ParseException e) {
			printUsage();
			System.exit(-1);
		}
	}
	
	public static void printUsage() {
		System.err.println("Usage: SimPL [-s | -f file | -h]");
	}
	
	public static void interactiveShell() {
		Scanner stdin = new Scanner(System.in);
		stdin.useDelimiter("\\$");
		while (stdin.hasNext()) {
			String script = stdin.next().trim();
			if (script.length() == 0) {
				continue;
			} else if (runScript(script + "$") != 0) {
				System.exit(1);
			}
		}
		// should never reach here
		stdin.close();
	}
	
	public static void simplScriptFile(String filename) {
		System.out.println("simplScriptFile " + filename);
		try {
			Scanner file = new Scanner(new FileInputStream(filename));
			file.useDelimiter("\\$");
			while (file.hasNextLine()) {
				String script = file.next().trim();
				// if script is just an empty string, then exit
				if (script.length() == 0) {
					System.exit(0);
				} else if (runScript(script + "$") != 0) {
					System.exit(1);
				}
			}
			
			file.close();
		} catch (FileNotFoundException e) {
			System.err.println("cannot open file: " + e.getMessage());
		}
	}
	
	/**
	 * run a simpl script
	 * @param script script string, should end with $
	 * @return 0 if succeeded otherwise 1
	 */
	public static int runScript(String script) {
		int retval = 1;
		try {
			parser p = new parser(new Lexer(new ByteArrayInputStream(script.getBytes())));
			p.parse();
			Env env = new Env();
			System.out.println(p.result.execute(env));
			retval = 0;
		} catch (SyntaxException e) {
			System.out.println(e.getMessage());
			System.out.println(ErrorMessage.pos());
		} catch (TypeMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println(ErrorMessage.pos());
		}catch (UnexpectedException e) {
			System.out.println(e.getMessage());
			System.out.println(ErrorMessage.pos());
		}catch (ValueUndefinedException e) {
			System.out.println(e.getMessage());
			System.out.println(ErrorMessage.pos());
		}catch (VariableUndefinedException e) {
			System.out.println(e.getMessage());
			System.out.println(ErrorMessage.pos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retval;
	}

}




























