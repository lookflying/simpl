package test;

import org.junit.Test;

import static test.TestUtil.*;

public class ListExpressions {
	@Test
	public void simpleLists() throws Exception {
		runScript("nil$", "nil");
		runScript("5::nil$", "[5]");
		runScript("1::2::nil$", "[1 2]");
		runScript("1::2::3::nil$", "[1 2 3]");
	}
}
