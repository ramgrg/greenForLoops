package com.se4gd.sonar.java.checks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.BlockTree;
import org.sonar.plugins.java.api.tree.DoWhileStatementTree;
import org.sonar.plugins.java.api.tree.ForEachStatement;
import org.sonar.plugins.java.api.tree.ForStatementTree;
import org.sonar.plugins.java.api.tree.StatementTree;
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
				Tree.Kind.WHILE_STATEMENT,
				Tree.Kind.DO_STATEMENT
			);
	}
	@Override
	public void visitNode(Tree tree) {
		// TODO Auto-generated method stub
		//super.visitNode(tree);
		if (tree.is(Kind.FOR_STATEMENT)) {
            ForStatementTree forLoopStatementTree = (ForStatementTree) tree;
            StatementTree statementTree = forLoopStatementTree.statement();
            if(checkNestedLoop(statementTree)) {
            	reportIssue(tree, RULE_MESSAGE);
            }else {
            	super.visitNode(statementTree);
            }
        }else if (tree.is(Kind.WHILE_STATEMENT)) {
            WhileStatementTree whileLoopStatementTree = (WhileStatementTree) tree;
            StatementTree statementTree = whileLoopStatementTree.statement();
            if(checkNestedLoop(statementTree)) {
            	reportIssue(tree, RULE_MESSAGE);
            }else {
            	super.visitNode(statementTree);
            }
        }else if(tree.is(Kind.FOR_EACH_STATEMENT)) {
        	ForEachStatement forEachStatement = (ForEachStatement) tree;
        	StatementTree statementTree = forEachStatement.statement();
        	
        	if(checkNestedLoop(statementTree)) {
            	reportIssue(tree, RULE_MESSAGE);
            }else {
            	super.visitNode(statementTree);
            }
        }
        else if(tree.is(Kind.DO_STATEMENT)) {
        	DoWhileStatementTree doWhileStatementTree = (DoWhileStatementTree) tree;
        	StatementTree statementTree = doWhileStatementTree.statement();
            if(checkNestedLoop(statementTree)) {
            	reportIssue(tree, RULE_MESSAGE);
            }else {
            	super.visitNode(statementTree);
            }
        }
	}
	private boolean checkNestedLoop(StatementTree statementTree) {
	    if (statementTree instanceof BlockTree) {
	      BlockTree block = (BlockTree) statementTree;
	      for (StatementTree nestedStatement : block.body()) {
	        if (nestedStatement.is(Tree.Kind.FOR_STATEMENT) || nestedStatement.is(Tree.Kind.WHILE_STATEMENT)
	                || nestedStatement.is(Tree.Kind.DO_STATEMENT) || nestedStatement.is(Tree.Kind.FOR_EACH_STATEMENT)) {
	          return true;
	        }
	      }
	    }
	    return false;
	  }
}
