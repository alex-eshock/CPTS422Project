package numTestPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import numComPackage.NumOperandsCheck;

public class NumOperandsCheckTest {
	int[] tokenTypes = new int[]{ TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_BOOLEAN, TokenTypes.LITERAL_BYTE, 
			TokenTypes.LITERAL_CHAR, TokenTypes.LITERAL_SHORT, TokenTypes.LITERAL_INT, 
			TokenTypes.LITERAL_FLOAT, TokenTypes.LITERAL_LONG, TokenTypes.LITERAL_DOUBLE, 
			TokenTypes.IDENT, TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, 
			TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL};

	@Test
	void beginTreeTest() {
		NumOperandsCheck spyOperands = spy(NumOperandsCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		spyOperands.beginTree(mockAST);
		verify(spyOperands, atLeastOnce()).beginTree(mockAST);
	}

	@Test
	void getDefaultTokensTest() {
		NumOperandsCheck operands = new NumOperandsCheck();
		assertArrayEquals(tokenTypes, operands.getDefaultTokens());
	}

	@Test
	void visitTokenTest() {
		NumOperandsCheck spyOperands = spy(NumOperandsCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		spyOperands.visitToken(mockAST);
		verify(spyOperands, atLeastOnce()).visitToken(mockAST);
	}

	@Test
	void getAcceptableTokensTest() {
		NumOperandsCheck operands = new NumOperandsCheck();
		assertArrayEquals(tokenTypes, operands.getAcceptableTokens());
	}

	@Test
	void getRequiredTokensTest() {
		NumOperandsCheck operands = new NumOperandsCheck();
		assertArrayEquals(tokenTypes, operands.getRequiredTokens());
	}

	@Test
	void finishTreeTest() {
		NumOperandsCheck spyOperands = spy(NumOperandsCheck.class);
		DetailAST mockAST = mock(DetailAST.class);
		String message = "Total operands found: 0";
		doNothing().when(spyOperands).log(0, message);
		spyOperands.finishTree(mockAST);
		verify(spyOperands).finishTree(mockAST);
	}
}
