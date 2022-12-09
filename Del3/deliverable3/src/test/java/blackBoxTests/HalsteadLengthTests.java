package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadPackage.HalsteadEffort;
import testEnginePackage.TestEngine;

public class HalsteadLengthTests {

	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadEffort check = new HalsteadEffort();
		String filePath = "src/main/java/blackBoxTests/HalsteadLengthCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(12908, check.count);

	}
	
	@Test
	void minTest() throws Exception, CheckstyleException {
		HalsteadEffort check = new HalsteadEffort();
		String filePath = "src/main/java/blackBoxTests/MinHalsteadLengthCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(38, check.count);

	}
}
