package run;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import parse.Lexer;
import parse.parser;
import semantic.Env;

public class SimPL {
	
	public static final int MAX_BUF_SIZE = 2048;
	
	/**
	 * the buffer is used to clear a pipe
	 */
	private static final byte[] dummyBuf = new byte[MAX_BUF_SIZE];

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
		Scanner pipereader = null;
		PrintWriter pipeWriter = null;
		Scanner stdin = null;
		try {
			// construct a pipe
			PipedInputStream pipeinstream = new PipedInputStream(MAX_BUF_SIZE);
			PipedOutputStream pipeoutstream = new PipedOutputStream(pipeinstream);
			pipereader = new Scanner(pipeinstream);
			pipereader.useDelimiter("\\$");
			pipeWriter = new PrintWriter(pipeoutstream);
			
			stdin = new Scanner(System.in);
			int dollarCount = 0;
			int bufsize = 0;
			System.out.print("SimPL> ");
			while (stdin.hasNextLine()) {
				// read a line from stdin, delete white characters
				String line = stdin.nextLine().trim();
				// add the total buffer size
				bufsize += line.length() + 1;
				// should not be more than 2k, if so, then abort
				if (bufsize > MAX_BUF_SIZE) {
					bufsize = 0;
					dollarCount = 0;
					pipeWriter.flush();
					if (pipeinstream.available() != 0) {
						pipeinstream.read(dummyBuf, 0, MAX_BUF_SIZE);
					}
					System.err.println("Error: A script should be less than " + MAX_BUF_SIZE + " characters");
					System.out.print("SimPL> ");
					continue;
				}
				// count occurance of $, the number of expressions
				dollarCount += countDollar(line);
				// store the line into the pipe to read
				pipeWriter.print('\n');
				pipeWriter.print(line);
				
				
				// a script will be executed only
				// when the last character of the line is $
				// if not, continue to read from stdin
				if (line.endsWith("$") == false) {
					continue;
				}
				
				// now execute the scripts
				pipeWriter.flush();
				while (dollarCount > 0) {
					String script = pipereader.next().trim();
					// if script is just an empty string, then ingore it
					if (script.isEmpty()) {
						continue;
					}
					runScript(script + "$");
					--dollarCount;
				}
				
				System.out.print("SimPL> ");
			}
		} catch (IOException e) {
			System.err.println("Unexpected error occurred: " + e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		} finally {
			if (pipereader != null) {
				pipereader.close();
			}
			if (pipeWriter != null) {
				pipeWriter.close();
			}
			if (stdin != null) {
				stdin.close();
			}
		}
	}
	
	public static void simplScriptFile(String filename) {
		System.out.println("simplScriptFile " + filename);
		try {
			Scanner file = new Scanner(new FileInputStream(filename));
			file.useDelimiter("\\$");
			while (file.hasNext()) {
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
		} catch (SimplException e) {
			System.out.println(e.getMessage());
			System.out.println(ErrorMessage.pos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retval;
	}
	
	private static int countDollar(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '$') {
				++count;
			}
		}
		return count;
	}

}




























