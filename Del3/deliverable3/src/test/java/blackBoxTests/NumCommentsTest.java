package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import testEnginePackage.TestEngine;
import numComPackage.NumComCheck;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

public class NumCommentsTest {
	
	@Test
	void noCommentTest() throws Exception, CheckstyleException {
		NumComCheck check = new NumComCheck();
		String filePath = "src/main/java/blackBoxTests/NoCommentChecks.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(0, check.count);

	}
	
	@Test
	void oneCommentTest() throws Exception, CheckstyleException {
		NumComCheck check = new NumComCheck();
		String filePath = "src/main/java/blackBoxTests/SingleCommentChecks.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(1, check.count);
		
	}
	
	@Test
	void MultiCommentTest() throws Exception, CheckstyleException {
		NumComCheck check = new NumComCheck();
		String filePath = "src/main/java/blackBoxTests/MultiCommentChecks.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(3, check.count);

	}

	@Test
	void StartOfFileTest() throws Exception, CheckstyleException {
		NumComCheck check = new NumComCheck();
		String filePath = "src/main/java/blackBoxTests/CommentBeforeImportCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(3, check.count);

	}
	
	@Test
	void EndOfFileTest() throws Exception, CheckstyleException {
		NumComCheck check = new NumComCheck();
		String filePath = "src/main/java/blackBoxTests/CommentAtEndOfFileCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(4, check.count);

	}
	
	@Test
	void MultiLineCommentTest() throws Exception, CheckstyleException {
		NumComCheck check = new NumComCheck();
		String filePath = "src/main/java/blackBoxTests/BothTypesOfCommentsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(4, check.count);

	}
}
