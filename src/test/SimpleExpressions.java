package test;

import org.junit.Test;

import static test.TestUtil.*;

public class SimpleExpressions {

	@Test
	public void testSimpleInt() throws Exception {
		runScript("54$", 54);
		runScript("1$", 1);
		runScript("   189689	$", 189689);
	}

	@Test
	public void testSimpleList() throws Exception {
		runScript("nil$", "nil");
		runScript("5::nil$", "[5]");
		runScript("9::4343::nil$", "[9 4343]");
		
		runScript("head (8::nil)$", 8);
		runScript("head ((1=2)::nil)$", false);
		runScript("tail (5::9::nil)$", "[9]");
	}

	@Test
	public void testSimplePair() throws Exception {
		runScript("(1 ,8)$", "(1, 8)");
		runScript("(nil, 8::nil)$", "(nil, [8])");
		runScript("(8::98::988::nil, nil)$", "([8 98 988], nil)");
		
		runScript("fst (1, 2)$", 1);
		runScript("snd (1, nil)$", "nil");
	}
	
	@Test
	public void testSimpleBoolean() throws Exception {
		runScript(" 1 = 2 $", false);
		runScript("1=1$", true);
		runScript("not(1=2)$", true);
	}
	
	@Test
	public void testSimpleBracket() throws Exception {
		runScript("(((    3)       ))$", 3);
	}
}
