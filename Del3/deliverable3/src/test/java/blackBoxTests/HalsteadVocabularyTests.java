package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadPackage.HalsteadVocabulary;
import testEnginePackage.TestEngine;

public class HalsteadVocabularyTests {

	@Test
	void onlyUniqueTest() throws Exception, CheckstyleException {
		HalsteadVocabulary check = new HalsteadVocabulary();
		String filePath = "src/main/java/blackBoxTests/HalsteadVocabularyCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(14, check.count);

	}

	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadVocabulary check = new HalsteadVocabulary();
		String filePath = "src/main/java/blackBoxTests/HalsteadLengthCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(29, check.count);
	}
	
}
