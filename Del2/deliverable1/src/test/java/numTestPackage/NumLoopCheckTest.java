package numTestPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import numComPackage.NumLoopCheck;

public class NumLoopCheckTest {
	int[] tokenTypes = {TokenTypes.DO_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE};

	@Test
	void beginTreeTest() {
		NumLoopCheck spyLoopingStatements = spy(new NumLoopCheck());
		DetailAST mockAST = mock(DetailAST.class);
		spyLoopingStatements.beginTree(mockAST);
		verify(spyLoopingStatements, atLeastOnce()).beginTree(mockAST);
	}

	@Test
	void getDefaultTokensTest() {
		NumLoopCheck loopingStatements = new NumLoopCheck();
		assertArrayEquals(tokenTypes, loopingStatements.getDefaultTokens());
	}

	@Test
	void visitTokenTest() {
		NumLoopCheck spyLoopingStatements = spy(new NumLoopCheck());
		DetailAST mockAST = mock(DetailAST.class);
		spyLoopingStatements.visitToken(mockAST);
		verify(spyLoopingStatements, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void getAcceptableTokensTest() {
		NumLoopCheck loopingStatements = new NumLoopCheck();
		assertArrayEquals(tokenTypes, loopingStatements.getAcceptableTokens());
	}

	@Test
	void getRequiredTokensTest() {
		NumLoopCheck loopingStatements = new NumLoopCheck();
		int[] requiredTokens = new int[0];
		assertArrayEquals(tokenTypes, loopingStatements.getRequiredTokens());
	}

	@Test
	void finishTreeTest() {
		NumLoopCheck spyLoopingStatements = spy(new NumLoopCheck());
		DetailAST mockAST = mock(DetailAST.class);
		String message = "Total loops found: 0";
		doNothing().when(spyLoopingStatements).log(0, message);
		spyLoopingStatements.finishTree(mockAST);
		verify(spyLoopingStatements).finishTree(mockAST);
	}
}
