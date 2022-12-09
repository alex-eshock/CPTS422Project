package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import numComPackage.NumLineComCheck;
import testEnginePackage.TestEngine;

public class NumLineCommentTest {

	@Test
	void noCommentTest() throws Exception, CheckstyleException {
		NumLineComCheck check = new NumLineComCheck();
		String filePath = "src/main/java/blackBoxTests/NoCommentChecks.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(0, check.count);
	}
	
	@Test
	void singleCommentTest() throws Exception, CheckstyleException {
		NumLineComCheck check = new NumLineComCheck();
		String filePath = "src/main/java/blackBoxTests/SingleCommentChecks.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(3, check.count);
	}
	
	@Test
	void multiCommentTest() throws Exception, CheckstyleException {
		NumLineComCheck check = new NumLineComCheck();
		String filePath = "src/main/java/blackBoxTests/MultiCommentChecks.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(9, check.count);
	}
	
	@Test
	void singleAndMultiCommentTest() throws Exception, CheckstyleException {
		NumLineComCheck check = new NumLineComCheck();
		String filePath = "src/main/java/blackBoxTests/SingleAndMultiCommentChecks.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(8, check.count);
	}
	
}
