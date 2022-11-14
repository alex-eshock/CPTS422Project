package numTestPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import numComPackage.NumExpressionsCheck;

public class NumExpressionsCheckTest {
	int[] tokenTypes = new int[]{ TokenTypes.EXPR};

	@Test
	void beginTreeTest() {
		NumExpressionsCheck mockExpression = mock(NumExpressionsCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		NumExpressionsCheck expression = new NumExpressionsCheck();
		mockExpression.beginTree(mockAST);
		verify(mockExpression, atLeastOnce()).beginTree(mockAST);
		expression.beginTree(mockAST);
		assertEquals(0, expression.count);
	}

	@Test
	void getDefaultTokensTest() {
		NumExpressionsCheck expression = new NumExpressionsCheck();
		assertArrayEquals(tokenTypes, expression.getDefaultTokens());
	}

	@Test
	void visitTokenTest() {
		NumExpressionsCheck mockExpression = mock(NumExpressionsCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		NumExpressionsCheck expression = new NumExpressionsCheck();
		mockExpression.visitToken(mockAST);
		verify(mockExpression, atLeastOnce()).visitToken(mockAST);
		expression.visitToken(mockAST);
		assertEquals(1, expression.count);

	}

	@Test
	void getAcceptableTokensTest() {
		NumExpressionsCheck expression = new NumExpressionsCheck();
		assertArrayEquals(tokenTypes, expression.getAcceptableTokens());
	}

	@Test
	void getRequiredTokensTest() {
		NumExpressionsCheck expression = new NumExpressionsCheck();
		assertArrayEquals(tokenTypes, expression.getRequiredTokens());
	}

	@Test
	void finishTreeTest() {
		NumExpressionsCheck spyExpression = spy(NumExpressionsCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		String message = "Total expressions found: 0";
		doNothing().when(spyExpression).log(0, message);
		spyExpression.finishTree(mockAST);
		verify(spyExpression).finishTree(mockAST);
	}
}
