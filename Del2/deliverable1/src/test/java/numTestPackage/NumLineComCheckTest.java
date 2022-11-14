package numTestPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import numComPackage.NumLineComCheck;

public class NumLineComCheckTest {
	int[] tokenTypes =  {TokenTypes.COMMENT_CONTENT, TokenTypes.BLOCK_COMMENT_BEGIN};

	@Test
	void beginTreeTest() {
		NumLineComCheck spyCommentLines = spy(new NumLineComCheck());
		DetailAST mockAST = mock(DetailAST.class);
		spyCommentLines.beginTree(mockAST);
		verify(spyCommentLines, atLeastOnce()).beginTree(mockAST);
	}


	@Test
	void getDefaultTokensTest() {
		NumLineComCheck commentLines = new NumLineComCheck();
		assertArrayEquals(commentLines.getDefaultTokens(), tokenTypes);
	}


	@Test
	void visitTokenSingleCommentTest() {
		NumLineComCheck spyCommentLines = spy(new NumLineComCheck());
		DetailAST mockAST = mock(DetailAST.class);
		doReturn(TokenTypes.SINGLE_LINE_COMMENT).when(mockAST).getType();
		spyCommentLines.visitToken(mockAST);
		verify(spyCommentLines, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void visitTokenBlockCommentTest() {
		NumLineComCheck spyCommentLines = spy(new NumLineComCheck());
		DetailAST mockAST = mock(DetailAST.class);
		doReturn("/*a*/").when(mockAST).getText();
		doReturn(TokenTypes.BLOCK_COMMENT_BEGIN).when(mockAST).getType();
		doReturn(mockAST).when(mockAST).findFirstToken(TokenTypes.BLOCK_COMMENT_END);
		doReturn(1).when(mockAST).getLineNo();
		spyCommentLines.visitToken(mockAST);
		verify(spyCommentLines, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void getAcceptableTokensTest() {
		NumLineComCheck commentLines = new NumLineComCheck();
		assertArrayEquals(tokenTypes, commentLines.getAcceptableTokens());
	}

	@Test
	void getRequiredTokensTest() {
		NumLineComCheck commentLines = new NumLineComCheck();
		assertArrayEquals(tokenTypes, commentLines.getRequiredTokens());
	}

	@Test
	void finishTreeTest() {
		NumLineComCheck spyCommentLines = spy(new NumLineComCheck());
		DetailAST mockAST = mock(DetailAST.class);
		String message = "Total comment lines found: 0";
		doNothing().when(spyCommentLines).log(0, message);
		spyCommentLines.finishTree(mockAST);
		verify(spyCommentLines).finishTree(mockAST);
	}
}
