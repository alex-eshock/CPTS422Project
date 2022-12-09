package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import halsteadPackage.HalsteadDifficulty;
import testEnginePackage.TestEngine;

public class HalsteadDifficultyTests {
	
	@Test
	void simpleTest() throws Exception, CheckstyleException {
		HalsteadDifficulty check = new HalsteadDifficulty();
		String filePath = "src/main/java/blackBoxTests/HalsteadDifficultyCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(10, check.count);

	}
	
	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadDifficulty check = new HalsteadDifficulty();
		String filePath = "src/main/java/blackBoxTests/HalsteadLengthCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(28, check.count);

	}

}
