package com.se4gd.sonar.java.checks;

import java.util.List;

import java.util.Arrays;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.AssignmentExpressionTree;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.BinaryExpressionTree;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.ForStatementTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.VariableTree;


@Rule(key = "RE4",
	description = DonotAccessGlobalVariableInLoop.RULE_MESSAGE,
	priority = Priority.MINOR
)

public class DonotAccessGlobalVariableInLoop extends IssuableSubscriptionVisitor{
	public final static String RULE_MESSAGE = "Do not access global variables inside for-loop; instead try to use local variables";
	
	private final DonotAccessGlobalVariableInLoopVisitor donotAccessGlobalVariableInLoopVisitor = new DonotAccessGlobalVariableInLoopVisitor();
	
	@Override
	public List<Kind> nodesToVisit() {
		// TODO Auto-generated method stub
		return Arrays.asList(
				Tree.Kind.FOR_STATEMENT,
				Tree.Kind.FOR_EACH_STATEMENT,
				Tree.Kind.WHILE_STATEMENT
			);
		/*return Arrays.asList(
				Tree.Kind.VARIABLE
			); */
	}
	
	@Override
	public void visitNode(Tree tree) {
		//implementation
		tree.accept(donotAccessGlobalVariableInLoopVisitor);
	/*	if (tree.is(Kind.FOR_STATEMENT)) {
			ForStatementTree forStatementTree = (ForStatementTree)tree;
			
			if(forStatementTree.condition() instanceof AssignmentExpressionTree) {
				AssignmentExpressionTree assignmentExpressionTree = (AssignmentExpressionTree)forStatementTree.statement();
				assignmentExpressionTree.accept(donotAccessGlobalVariableInLoopVisitor);
			}
		} */
		
	}
	private class DonotAccessGlobalVariableInLoopVisitor extends BaseTreeVisitor{
		
		@Override
		public void visitVariable(VariableTree tree) {
			// TODO Auto-generated method stub
			if (tree.symbol().isStatic()) {
				reportIssue(tree, RULE_MESSAGE);
			}else {
				super.visitVariable(tree);
			}
		}
		/*@Override
        public void visitAssignmentExpression(AssignmentExpressionTree tree) {
			ExpressionTree variable = tree.variable();
            IdentifierTree identifier = (IdentifierTree) variable;
            if (identifier.symbol().isStatic()) {
                reportIssue(tree, RULE_MESSAGE);
            }
            super.visitAssignmentExpression(tree);
        } */
	}
}
/*
 * @Override
 public void visitMemberSelectExpression(MemberSelectExpressionTree tree) {
	      if (tree.expression().is(Tree.Kind.MEMBER_SELECT)) {
	        visitMemberSelectExpression((MemberSelectExpressionTree) tree.expression());
	      } else if (tree.expression().is(Tree.Kind.IDENTIFIER)) {
	        IdentifierTree identifier = (IdentifierTree) tree.expression();
	        if (identifier.symbol().isStatic()) {
	        	reportIssue(tree, RULE_MESSAGE);
	        }else {
	        	super.visitMemberSelectExpression(tree);
			}
	      }
	    }
	  @Override
		public void visitVariable(VariableTree tree) {
			// TODO Auto-generated method stub
			Tree parent = tree.parent();
	        while (parent != null) {
	            if (parent.is(Kind.FOR_STATEMENT, Kind.WHILE_STATEMENT, Kind.DO_STATEMENT)) {
	            	if(tree.symbol().isStatic()) {
	    				reportIssue(tree, RULE_MESSAGE);
	    			}else {
	    				super.visitVariable(tree);
	    			}
	            }
	            parent = parent.parent();
	        }
		}
		@Override
		public void visitForStatement(ForStatementTree tree) {
			// TODO Auto-generated method stub
			ExpressionTree expression = tree.condition();
			if (expression.is(Tree.Kind.IDENTIFIER)) {
	            Symbol symbol = ((IdentifierTree) expression).symbol();
	            if(symbol.isStatic()) {
	            	reportIssue(tree, RULE_MESSAGE);
	            }else {
	            	super.visitForStatement(tree);
				}
	        }
		}
*/
