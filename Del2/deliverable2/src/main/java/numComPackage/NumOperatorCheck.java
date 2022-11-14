package numComPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class NumOperatorCheck extends AbstractCheck {
	//mVariable, mAge, mStudentID
	 
    private static final String CATCH_MSG = "Total operators found: ";
    int count = 0;
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
        count = 0;
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
