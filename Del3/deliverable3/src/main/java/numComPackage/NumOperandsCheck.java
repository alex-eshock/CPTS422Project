package numComPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class NumOperandsCheck extends AbstractCheck{
	//mVariable, mAge, mStudentID

	private static final String CATCH_MSG = "Total operands found: ";
	public int count = 0;
	int[] tokenTypes = new int[]{ TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_BOOLEAN, TokenTypes.LITERAL_BYTE, 
			TokenTypes.LITERAL_CHAR, TokenTypes.LITERAL_SHORT, TokenTypes.LITERAL_INT, 
			TokenTypes.LITERAL_FLOAT, TokenTypes.LITERAL_LONG, TokenTypes.LITERAL_DOUBLE, 
			TokenTypes.IDENT, TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, 
			TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL};

	@Override
	public int[] getDefaultTokens() {
		return tokenTypes;
	}

	@Override
	public void visitToken(DetailAST aAST) {
		count++;
	}

	@Override
	public void beginTree(DetailAST aAST) {
		count = 0;
	}

	@Override
	public void finishTree(DetailAST aAST) {
		log(aAST.getLineNo(), CATCH_MSG + count);
	}

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		return getDefaultTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getDefaultTokens();
	}
}
