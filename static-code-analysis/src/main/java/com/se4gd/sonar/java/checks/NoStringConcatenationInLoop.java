package com.se4gd.sonar.java.checks;
import java.util.Arrays;
import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.AssignmentExpressionTree;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.BinaryExpressionTree;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;


@Rule(key = "RE1",
	description = NoStringConcatenationInLoop.RULE_MESSAGE,
	priority = Priority.MINOR
)
public class NoStringConcatenationInLoop extends IssuableSubscriptionVisitor{
	
	public final static String RULE_MESSAGE = "Do not concatenate string inside loops. If you have to, use StringBuilder instead.";
	public final static String STRING_CLASS_NAME = String.class.getName();
	
	private final StringVisitor VISITOR = new StringVisitor();
	
	
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
		tree.accept(VISITOR);
	}
	private class StringVisitor  extends BaseTreeVisitor{
		@Override
		public void visitBinaryExpression(BinaryExpressionTree tree) {
			// TODO Auto-generated method stub
			if(tree.is(Tree.Kind.PLUS) && isString(tree.leftOperand())) {
				reportIssue(tree, RULE_MESSAGE);
			}
			else {
				super.visitBinaryExpression(tree);
			}
		}
		
		@Override
		public void visitAssignmentExpression(AssignmentExpressionTree tree) {
			// TODO Auto-generated method stub
			if(tree.is(Tree.Kind.PLUS_ASSIGNMENT) && isString(tree.variable())) {
				reportIssue(tree, RULE_MESSAGE);
			}else {
				super.visitAssignmentExpression(tree);
			}
		}
		public boolean isString(ExpressionTree expressionTree) {
			return expressionTree.symbolType().is(STRING_CLASS_NAME);
		}
	}

}
