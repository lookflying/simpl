package test;

import org.junit.Test;

public class SimpleExpressions {

	@Test
	public void testSimpleInt() throws Exception {
		TestUtil.runScript("54$");
		TestUtil.runScript("1$");
		TestUtil.runScript("189689$");
	}

}
