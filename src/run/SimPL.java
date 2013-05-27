package run;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

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
		// TODO
		System.out.println("interactiveShell");
	}
	
	public static void simplScriptFile(String filename) {
		// TODO
		System.out.println("simplScriptFile " + filename);
	}

}
