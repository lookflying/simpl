package test;

import org.junit.Test;

public class SimpleExpressions {

	@Test
	public void testSimpleInt() throws Exception {
		TestUtil.runScript("54$", 54);
		TestUtil.runScript("1$", 1);
		TestUtil.runScript("   189689	$", 189689);
	}

	@Test
	public void testSimpleList() throws Exception {
		TestUtil.runScript("nil$");
		TestUtil.runScript("5::nil$");
		TestUtil.runScript("9::4343::nil$");
	}

	@Test
	public void testSimplePair() throws Exception {
		TestUtil.runScript("(1 ,8)$");
		TestUtil.runScript("(nil, 8::nil)$");
		TestUtil.runScript("(8::98::988::nil, nil)$");
	}

}
