package test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

import parse.Lexer;
import parse.parser;
import semantic.Env;
import syntax.BoolValue;
import syntax.IntValue;
import syntax.Value;

public class TestUtil {
	
	public static void runScript(String script) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>\nRunning: \n" + script);
		parser p = new parser(new Lexer(new ByteArrayInputStream(script.getBytes())));
		p.parse();
		System.out.println("Parse result: \n" + p.result.toString());
		Env env = new Env();
		System.out.println("Result: " + p.result.execute(env));
	}
	
	public static void runScript(String script, Integer result) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>\nRunning: \n" + script);
		parser p = new parser(new Lexer(new ByteArrayInputStream(script.getBytes())));
		p.parse();
		System.out.println("Parse result: \n" + p.result.toString());
		Env env = new Env();
		Value v = p.result.execute(env);
		System.out.println("Result: " + v);
		if (result == null) {
			assertTrue(((IntValue)v).isUndef());
		} else {
			assertEquals(result.intValue(), ((IntValue)v).getValue());
		}
	}
	
	public static void runScript(String script, boolean result) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>\nRunning: \n" + script);
		parser p = new parser(new Lexer(new ByteArrayInputStream(script.getBytes())));
		p.parse();
		System.out.println("Parse result: \n" + p.result.toString());
		Env env = new Env();
		Value v = p.result.execute(env);
		System.out.println("Result: " + v);
		assertEquals(result, ((BoolValue)v).getValue());
	}

}
