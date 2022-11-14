package halsteadTestPackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import halsteadPackage.HalsteadVocabulary;

public class HalsteadVocabularyTest {
	int[] tokenTypes =  {TokenTypes.LCURLY, TokenTypes.LPAREN, 
            TokenTypes.ARRAY_DECLARATOR, TokenTypes.LITERAL_TRY, TokenTypes.LITERAL_CATCH, 
            TokenTypes.LITERAL_FINALLY, TokenTypes.PLUS_ASSIGN, TokenTypes.MINUS_ASSIGN, 
            TokenTypes.STAR_ASSIGN, TokenTypes.DIV_ASSIGN, TokenTypes.MOD_ASSIGN, TokenTypes.SR_ASSIGN,
            TokenTypes.BSR_ASSIGN, TokenTypes.SL_ASSIGN, TokenTypes.BAND_ASSIGN, 
            TokenTypes.BXOR_ASSIGN, TokenTypes.BOR_ASSIGN, TokenTypes.QUESTION, TokenTypes.LOR, 
            TokenTypes.LAND, TokenTypes.BOR, TokenTypes.BXOR, TokenTypes.BAND, TokenTypes.NOT_EQUAL, 
            TokenTypes.EQUAL, TokenTypes.LT, TokenTypes.GT, TokenTypes.LE, TokenTypes.GE, 
            TokenTypes.LITERAL_INSTANCEOF, TokenTypes.SL, TokenTypes.SR, TokenTypes.BSR, 
            TokenTypes.PLUS, TokenTypes.MINUS, TokenTypes.DIV, TokenTypes.MOD, TokenTypes.INC, 
            TokenTypes.DEC, TokenTypes.BNOT, TokenTypes.LNOT, TokenTypes.LITERAL_TRUE, 
            TokenTypes.LITERAL_FALSE, TokenTypes.LITERAL_NULL, TokenTypes.LITERAL_NEW, 
            TokenTypes.LITERAL_ASSERT, TokenTypes.STATIC_IMPORT, TokenTypes.ENUM, 
            TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_BREAK, TokenTypes.ELLIPSIS, TokenTypes.LAMBDA,
            TokenTypes.ABSTRACT, TokenTypes.ASSIGN, TokenTypes.DOUBLE_COLON, TokenTypes.COMMA, 
            TokenTypes.STAR, TokenTypes.LITERAL_DO, TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_IF, 
            TokenTypes.LITERAL_ELSE, TokenTypes.LITERAL_THROW, TokenTypes.LITERAL_THROWS, 
            TokenTypes.LITERAL_INTERFACE, TokenTypes.UNARY_PLUS, TokenTypes.UNARY_MINUS, 
            TokenTypes.METHOD_CALL, TokenTypes.LITERAL_THIS, TokenTypes.LITERAL_VOLATILE,
            TokenTypes.LITERAL_SYNCHRONIZED, TokenTypes.LITERAL_STATIC, TokenTypes.LITERAL_SUPER, 
            TokenTypes.LITERAL_TRANSIENT, TokenTypes.SEMI, TokenTypes.STRICTFP, TokenTypes.POST_DEC, 
            TokenTypes.POST_INC, TokenTypes.LITERAL_CLASS, TokenTypes.PACKAGE_DEF, 
            TokenTypes.LITERAL_RETURN, TokenTypes.LITERAL_PRIVATE, TokenTypes.LITERAL_PUBLIC, 
            TokenTypes.LITERAL_PROTECTED, TokenTypes.ABSTRACT, TokenTypes.FINAL, 
            TokenTypes.LITERAL_TRANSIENT, TokenTypes.LITERAL_VOLATILE, TokenTypes.LITERAL_SYNCHRONIZED,
            TokenTypes.LITERAL_NATIVE, TokenTypes.LITERAL_DEFAULT, TokenTypes.DOT, TokenTypes.DO_WHILE, 
            TokenTypes.SLIST, TokenTypes.IMPORT,
            TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_BOOLEAN, TokenTypes.LITERAL_BYTE, 
            TokenTypes.LITERAL_CHAR, TokenTypes.LITERAL_SHORT, TokenTypes.LITERAL_INT, 
            TokenTypes.LITERAL_FLOAT, TokenTypes.LITERAL_LONG, TokenTypes.LITERAL_DOUBLE, 
            TokenTypes.IDENT, TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, 
            TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL};

	@Test
	void beginTreeTest() {
		HalsteadVocabulary spyVocab = spy(new HalsteadVocabulary());
		DetailAST mockAST = mock(DetailAST.class);
		spyVocab.beginTree(mockAST);
		verify(spyVocab, atLeastOnce()).beginTree(mockAST);
	}
	
	@Test
	void getDefaultTokensTest() {
		HalsteadVocabulary vocab = new HalsteadVocabulary();
		assertArrayEquals(tokenTypes, vocab.getDefaultTokens());
	}
	
	 @Test
	 void visitTokenTest() {
		HalsteadVocabulary spyVocabulary = spy(new HalsteadVocabulary());
		DetailAST mockAST = mock(DetailAST.class);
	  	doReturn(TokenTypes.BOR).when(mockAST).getType();
	  	spyVocabulary.visitToken(mockAST);
	  	verify(spyVocabulary, atLeastOnce()).visitToken(mockAST);
	 }
	 
	 @Test
	 void getAcceptableTokensTest() {
		HalsteadVocabulary vocab = new HalsteadVocabulary();
		assertArrayEquals(tokenTypes, vocab.getAcceptableTokens());
	 }
	 
	 @Test
	 void getRequiredTokensTest() {
		HalsteadVocabulary vocab = new HalsteadVocabulary();;
		assertArrayEquals(tokenTypes, vocab.getRequiredTokens());
	 }
	 
	 @Test
	 void finishTreeTest() {

		HalsteadVocabulary spyVocab = spy(new HalsteadVocabulary());
		DetailAST mockAST = mock(DetailAST.class);
	 	String message = "Halstead Unique Vocabulary: 0";
		doNothing().when(spyVocab).log(0, message);
		spyVocab.finishTree(mockAST);
		verify(spyVocab).finishTree(mockAST);
	 }
}
