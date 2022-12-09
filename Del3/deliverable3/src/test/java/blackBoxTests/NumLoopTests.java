package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import numComPackage.NumLoopCheck;
import testEnginePackage.TestEngine;


public class NumLoopTests {

	@Test
	void oneLoopTest() throws Exception, CheckstyleException {
		NumLoopCheck check = new NumLoopCheck();
		String filePath = "src/main/java/blackBoxTests/SingleLoopCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(1, check.count);

	}
	@Test
	void manyLoopTest() throws Exception, CheckstyleException {
		NumLoopCheck check = new NumLoopCheck();
		String filePath = "src/main/java/blackBoxTests/ManyLoopsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(3, check.count);

	}
	@Test
	void noLoopTest() throws Exception, CheckstyleException {
		NumLoopCheck check = new NumLoopCheck();
		String filePath = "src/main/java/blackBoxTests/NoLoopsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(0, check.count);

	}
	@Test
	void nestedLoopTest() throws Exception, CheckstyleException {
		NumLoopCheck check = new NumLoopCheck();
		String filePath = "src/main/java/blackBoxTests/nestedLoopsCheck.java";
		TestEngine testEngine = new TestEngine(filePath,check);
		testEngine.test();
		assertEquals(4, check.count);

	}

}
