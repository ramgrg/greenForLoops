package com.se4gd.sonar.java.checks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ForEachStatement;
import org.sonar.plugins.java.api.tree.ForStatementTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.WhileStatementTree;

@Rule(key = "RE5",
	description = AvoidBig0TimeComplexity.RULE_MESSAGE,
	priority = Priority.MAJOR
)

public class AvoidBig0TimeComplexity extends IssuableSubscriptionVisitor{
	public final static String RULE_MESSAGE = "Avoid using nested loop; instead try to convert nested loop to single loop";
	
	private Stack<Tree.Kind> loopStack = new Stack<>();
	
	@Override
	public List<Kind> nodesToVisit() {
		// TODO Auto-generated method stub
		return Arrays.asList(
				Tree.Kind.FOR_STATEMENT,
				Tree.Kind.FOR_EACH_STATEMENT,
				Tree.Kind.WHILE_STATEMENT
			);
	}
	@Override
	public void visitNode(Tree tree) {
		// TODO Auto-generated method stub
		//super.visitNode(tree);
		if (tree.is(Kind.FOR_STATEMENT)) {
            ForStatementTree forLoop = (ForStatementTree) tree;
            checkNestedLoop(forLoop);
        } else if (tree.is(Kind.WHILE_STATEMENT)) {
            WhileStatementTree whileLoop = (WhileStatementTree) tree;
            checkNestedLoop(whileLoop);
        }else if(tree.is(Kind.FOR_EACH_STATEMENT)) {
        	ForEachStatement forEachStatement = (ForEachStatement) tree;
        	checkNestedLoop(forEachStatement);
        }
	}
	
	private void checkNestedLoop(Tree loop) {
        if (!loopStack.isEmpty() && isNestedLoop(loop)) {
            loopStack = new Stack<>();
            reportIssue(loop, RULE_MESSAGE);
        }else {
        	loopStack.push(loop.kind());
        }
    }

    private boolean isNestedLoop(Tree loop) {
        return loopStack.contains(loop.kind());
    }
}
