package numComPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class NumExpressionsCheck extends AbstractCheck {
	//mVariable, mAge, mStudentID
	 
    private static final String CATCH_MSG = "Total expressions found: ";
    public int count = 0;
 
    @Override
    public int[] getDefaultTokens() {
        return new int[]{ TokenTypes.EXPR};
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
