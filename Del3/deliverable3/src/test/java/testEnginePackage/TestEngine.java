package testEnginePackage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.DefaultContext;
import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.JavaParser.Options;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;

public class TestEngine {
    private final AbstractCheck check;
    private final String path;
    private DetailAST root;

    public TestEngine(String filePath, AbstractCheck check) {
        this.path = filePath;
        this.check = check;
    }

    public void test() throws IOException, CheckstyleException {
        // Build file
        File file = new File(path);
        FileText ft = new FileText(file, "UTF-8");
        FileContents fc = new FileContents(ft);

        // Parse file with or without comments
        root = check.isCommentNodesRequired()
            ? JavaParser.parseFile(file, Options.WITH_COMMENTS)
            : JavaParser.parse(fc);

        // Initialize and configure check
        check.configure(new DefaultConfiguration("Local"));
        check.contextualize(new DefaultContext());

        // Begin tree traversal and visit each token
        check.beginTree(root);
        helper(check, root);

        // Finish tree traversal and display logs
        check.finishTree(root);
    }

    public void helper(AbstractCheck b, DetailAST curNode) {
        int[] tokens = b.getAcceptableTokens();
        while (curNode != null) {
            if (contains(tokens, curNode.getType())) {
                b.visitToken(curNode);
            }

            DetailAST toVisit = curNode.getFirstChild();
            while (curNode != null && toVisit == null) {
                b.leaveToken(curNode);
                toVisit = curNode.getNextSibling();
                curNode = curNode.getParent();
            }
            curNode = toVisit;
        }
    }

    public boolean contains(int[] array, int key) {
        return Arrays.stream(array).anyMatch(i -> i == key);
    }
}