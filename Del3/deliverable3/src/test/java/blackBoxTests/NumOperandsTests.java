package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;
import numComPackage.NumOperandsCheck;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import testEnginePackage.TestEngine;

public class NumOperandsTests {

	@Test
	void test() throws IOException, CheckstyleException {
		NumOperandsCheck check = new NumOperandsCheck();
		String filePath = "src/main/java/blackBoxTests/NoOperandsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(2, check.count);
	}

	@Test
	void nestedTest() throws IOException, CheckstyleException {
		NumOperandsCheck check = new NumOperandsCheck();
		String filePath = "src/main/java/blackBoxTests/ManyOperandsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(13, check.count);
	}

}
