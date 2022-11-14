package numComPackage;

import com.puppycrawl.tools.checkstyle.api.*;
import java.util.regex.Pattern;
import java.util.Arrays;
 
public class NumLoopCheck extends AbstractCheck {
//mVariable, mAge, mStudentID
 
    private static final String CATCH_MSG = "Total loops found: ";
    int count = 0;
    int[] tokenTypes = new int[]{TokenTypes.DO_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_WHILE};
 
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