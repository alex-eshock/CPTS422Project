package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadPackage.HalsteadEffort;
import testEnginePackage.TestEngine;

public class HalsteadEffortTests {
	
	@Test
	void effortTest() throws Exception, CheckstyleException {
		HalsteadEffort check = new HalsteadEffort();
		String filePath = "src/main/java/blackBoxTests/HalsteadEffortCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(680, check.count);

	}

	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadEffort check = new HalsteadEffort();
		String filePath = "src/main/java/blackBoxTests/HalsteadLengthCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(12908, check.count);

	}
}
