package test;

import java.io.ByteArrayInputStream;

import parse.Lexer;
import parse.parser;
import semantic.Env;

public class TestUtil {
	
	public static void runScript(String script) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>\nRunning: \n" + script);
		parser p = new parser(new Lexer(new ByteArrayInputStream(script.getBytes())));
		p.parse();
		System.out.println("Parse result: \n" + p.result.toString());
		Env env = new Env();
		System.out.println("Result: " + p.result.execute(env));
	}

}
