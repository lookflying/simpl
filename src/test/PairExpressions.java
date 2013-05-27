package test;

import org.junit.Test;

import static test.TestUtil.*;

public class PairExpressions {
	@Test
	public void simplePairs() throws Exception {
		runScript("fst (1, 2)$", 1);
		runScript("fst (nil, nil)$", "nil");
		runScript("fst ((nil, 5::nil), nil)$", "(nil, [5])");

		runScript("snd (1, 2)$", 2);
		runScript("snd (nil, nil)$", "nil");
		runScript("snd ((nil, 5::nil), nil)$", "nil");
	}
	
	@Test
	public void someComplexPairs() throws Exception {
		runScript("fst snd fst ((nil, (1, 2)), 8::nil)$", 1);
		runScript("fst (snd (5::9::nil, fst((8,2), (2, 3))))$", 8);
		runScript("fst snd fst ((nil, (fst (snd (5::9::nil, fst((4,2), (2, 3)))), 2)), 8::nil)$", 4);
	}
}
