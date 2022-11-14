package numTestPackage;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import com.puppycrawl.tools.checkstyle.api.*;

import numComPackage.NumComCheck;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class NumComCheckTest {

	int[] tokenTypes =  {TokenTypes.COMMENT_CONTENT};

	@Spy 
	NumComCheck spyComments = spy(NumComCheck.class);

	@Mock
	DetailAST mockAST = mock(DetailAST.class);			// Mocks the abstract syntax tree
	NumComCheck mockComments = mock(NumComCheck.class); // Mocks the comments being counted
	NumComCheck comments = new NumComCheck();		    // Actual Comments

	@Test
	void beginTreeTest() { 
		spyComments.beginTree(mockAST);
		verify(spyComments, atLeastOnce()).beginTree(mockAST);
	}

	@Test
	void getDefaultTokensTest() {
		assertArrayEquals(comments.getDefaultTokens(), tokenTypes);
	}

	@Test
	void visitTokenSingleTest() {
		doReturn(TokenTypes.SINGLE_LINE_COMMENT).when(mockAST).getType();
		spyComments.visitToken(mockAST);
		verify(spyComments, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void visitTokenBlockTest() {
		doReturn(TokenTypes.BLOCK_COMMENT_BEGIN).when(mockAST).getType();
		spyComments.visitToken(mockAST);
		verify(spyComments, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void getAcceptableTokensTest() {
		assertArrayEquals(comments.getAcceptableTokens(), tokenTypes);
	}

	@Test
	void getRequiredTokensTest() {
		assertArrayEquals(comments.getRequiredTokens(), tokenTypes);
	}

	@Test
	void finishTreeTest() {
		String message = "Comments within a certain class: 0";
		doNothing().when(spyComments).log(0, message);
		spyComments.finishTree(mockAST);
		verify(spyComments).finishTree(mockAST);
	}

	@Test
	void isCommentNodesRequiredTest() {
		assertTrue(comments.isCommentNodesRequired());
	}
}
