package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import numComPackage.NumOperatorCheck;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import testEnginePackage.TestEngine;

public class NumOperatorTests {
	@Test
	void test() throws IOException, CheckstyleException {
		NumOperatorCheck check = new NumOperatorCheck();
		String filePath = "src/main/java/blackBoxTests/ManyOperatorsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(6, check.count);
	}

	@Test
	void nestedTest() throws IOException, CheckstyleException {
		NumOperatorCheck check = new NumOperatorCheck();
		String filePath = "src/main/java/blackBoxTests/NestedOperatorsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(22, check.count);
	}

}
