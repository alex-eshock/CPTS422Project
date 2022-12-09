package blackBoxTests;


import static org.junit.jupiter.api.Assertions.*;
import testEnginePackage.TestEngine;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import numComPackage.NumExpressionsCheck;

public class NumExpressionsTests {
	
	@Test
	void noExpressionTest() throws Exception, CheckstyleException {
		NumExpressionsCheck check = new NumExpressionsCheck();
		String filePath = "src/main/java/blackBoxTests/NoExpressionCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(0, check.count);

	}
	@Test
	void oneExpressionTest() throws Exception, CheckstyleException {
		NumExpressionsCheck check = new NumExpressionsCheck();
		String filePath = "src/main/java/blackBoxTests/OneExpressionCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(1, check.count);

	}
	@Test
	void manyExpressionTest() throws Exception, CheckstyleException {
		NumExpressionsCheck check = new NumExpressionsCheck();
		String filePath = "src/main/java/blackBoxTests/MultExpressionsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(5, check.count);

	}

}
