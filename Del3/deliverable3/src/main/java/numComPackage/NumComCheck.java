package numComPackage;
 
import com.puppycrawl.tools.checkstyle.api.*;
import java.util.regex.Pattern;
 
public class NumComCheck extends AbstractCheck {
 
    private static final String CATCH_MSG = "Comments within a certain class: ";
    
    public int count = 0;
    
    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.COMMENT_CONTENT};
    }
 
    @Override
    public void visitToken(DetailAST aAST) {
    	count++;
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
	
	@Override
	public void finishTree(DetailAST aAST) {
		log(aAST.getLineNo(), CATCH_MSG + count);
	}
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
}
