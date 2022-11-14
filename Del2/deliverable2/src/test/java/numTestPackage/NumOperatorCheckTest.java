package numTestPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import numComPackage.NumOperatorCheck;

public class NumOperatorCheckTest {
	int[] tokenTypes = new int[]{TokenTypes.ASSIGN, TokenTypes.BAND, TokenTypes.BAND_ASSIGN, TokenTypes.BNOT, 
    		TokenTypes.BOR, TokenTypes.BOR_ASSIGN, TokenTypes.BSR, TokenTypes.BSR_ASSIGN, TokenTypes.BXOR, 
    		TokenTypes.BXOR_ASSIGN, TokenTypes.COLON, TokenTypes.COMMA, TokenTypes.DEC, TokenTypes.DIV,
    		TokenTypes.DIV_ASSIGN, TokenTypes.DOT, TokenTypes.GE, TokenTypes.GT, TokenTypes.INC,
    		TokenTypes.INDEX_OP, TokenTypes.LAND, TokenTypes.LE, TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LNOT,
    		TokenTypes.LOR, TokenTypes.LPAREN, TokenTypes.LT, TokenTypes.MINUS, TokenTypes.MINUS_ASSIGN,
    		TokenTypes.MOD, TokenTypes.MOD_ASSIGN, TokenTypes.NOT_EQUAL, TokenTypes.PLUS, TokenTypes.PLUS_ASSIGN,
    		TokenTypes.POST_DEC, TokenTypes.POST_INC, TokenTypes.QUESTION, TokenTypes.SL, TokenTypes.SL_ASSIGN,
    		TokenTypes.SR, TokenTypes.SR_ASSIGN, TokenTypes.STAR, TokenTypes.STAR_ASSIGN, TokenTypes.UNARY_MINUS,
    		TokenTypes.UNARY_PLUS};
	 
	@Test
	void beginTreeTest() {
		NumOperatorCheck spyOperators = spy(NumOperatorCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		spyOperators.beginTree(mockAST);
		verify(spyOperators, atLeastOnce()).beginTree(mockAST);
	}

	@Test
	void getDefaultTokensTest() {
		NumOperatorCheck operators = new NumOperatorCheck();
		assertArrayEquals(tokenTypes, operators.getDefaultTokens());
	}

	@Test
	void visitTokenTest() {
		NumOperatorCheck spyOperators = spy(NumOperatorCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		spyOperators.visitToken(mockAST);
		verify(spyOperators, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void getAcceptableTokensTest() {
		NumOperatorCheck operators = new NumOperatorCheck();
		assertArrayEquals(tokenTypes, operators.getAcceptableTokens());
	}

	@Test
	void getRequiredTokensTest() {
		NumOperatorCheck operators = new NumOperatorCheck();
		assertArrayEquals(tokenTypes, operators.getRequiredTokens());
	}

	@Test
	void finishTreeTest() {
		NumOperatorCheck spyOperators = spy(new NumOperatorCheck());
		DetailAST mockAST = mock(DetailAST.class);
		String message = "Total operators found: 0";
		doNothing().when(spyOperators).log(0, message);
		spyOperators.finishTree(mockAST);
		verify(spyOperators).finishTree(mockAST);
	}
}
