package test;

import org.junit.Test;

import static test.TestUtil.*;

public class BinaryAndUnaryExpressions {
	@Test
	public void testArithmetic() throws Exception {
		runScript("1+2$", 3);
		runScript("9*7$", 63);
		runScript("~8*~2$", 16);
		runScript("~2*(4+9/2)-9+~8$", -33);
		runScript("1+2+3+4*5*6+7+8$", 141);
		runScript("(4-9)*2+9*8$", 62);
	}
	
	@Test
	public void testBoolean() throws Exception {
		runScript("1=4$", false);
		runScript("6=6$", true);
		
		runScript("(1+4=5) and 4=9$", false);
		runScript("(1+4=6) and 4=9$", false);
		runScript("(1+4=5) and 4=4$", true);
		runScript("(1+4=2) and 4=3$", false);
		
		runScript("(1+4=5) or 4=9$", true);
		runScript("(1+4=6) or 4=9$", false);
		runScript("(1+4=5) or 4=4$", true);
		runScript("(1+4=2) or 4=3$", false);
		
		runScript("9*8/9-9>  (8+9*7)$", false);
		runScript("(1*4=5) or 4<9$", true);
	}
}
