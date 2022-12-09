package blackBoxTests;

import blackBoxTests.NoCommentChecks;

public class CommentBeforeImportCheck {
	public void noComments() {
		//Test Comment
		for(int i = 0; i < 2; i++) {
			//Testing one comment
			String test = "Test";
		}
		
		int test = 0;
	}
	//Test Comment
}
