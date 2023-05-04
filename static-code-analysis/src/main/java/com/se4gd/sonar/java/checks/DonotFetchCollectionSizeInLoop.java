package com.se4gd.sonar.java.checks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.MethodMatchers;
import org.sonar.plugins.java.api.tree.AnnotationTree;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.BinaryExpressionTree;
import org.sonar.plugins.java.api.tree.ForStatementTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.WhileStatementTree;

@Rule(
		key = "RE2",
		description = DonotFetchCollectionSizeInLoop.RULE_MESSAGE,
		priority = Priority.MINOR
)

public class DonotFetchCollectionSizeInLoop extends IssuableSubscriptionVisitor{
	public static final String RULE_MESSAGE = "Don't fetch the size of any collection in the loop to iterate";
	private static final MethodMatchers SIZE_METHOD = MethodMatchers.or(
			MethodMatchers.create()
			.ofAnyType()
			.names("size", "length")
			.withAnyParameters()
			.build()
	); 
	private final DonotFetchCollectionSizeInLoopVisitor donotFetchCollectionSizeInLoopVisitor = new DonotFetchCollectionSizeInLoopVisitor();
	@Override
	public List<Kind> nodesToVisit() {
		// TODO Auto-generated method stub
		return Arrays.asList(Kind.FOR_STATEMENT, Kind.WHILE_STATEMENT);
	}
	
	@Override
	public void visitNode(Tree tree) {
		// TODO Auto-generated method stub
		if (tree.is(Kind.FOR_STATEMENT)) {
			ForStatementTree forStatementTree = (ForStatementTree)tree;
			
			if(forStatementTree.condition() instanceof BinaryExpressionTree) {
				BinaryExpressionTree binaryExpressionTree = (BinaryExpressionTree)forStatementTree.condition();
				binaryExpressionTree.accept(donotFetchCollectionSizeInLoopVisitor);
			}
		}else if (tree.is(Kind.WHILE_STATEMENT)) {
			WhileStatementTree whileStatementTree = (WhileStatementTree)tree;
			
			if(whileStatementTree.condition() instanceof BinaryExpressionTree) {
				BinaryExpressionTree binaryExpressionTree = (BinaryExpressionTree)whileStatementTree.condition();
				binaryExpressionTree.accept(donotFetchCollectionSizeInLoopVisitor);
			}
		}else {
			throw new UnsupportedOperationException("Unsupported statement detected...");
		}
	}
	
	private class DonotFetchCollectionSizeInLoopVisitor extends BaseTreeVisitor{
		
		@Override
		public void visitMethodInvocation(MethodInvocationTree tree) {
			// TODO Auto-generated method stub
			if(SIZE_METHOD.matches(tree.symbol())) {
				reportIssue(tree, RULE_MESSAGE);
			}else {
				super.visitMethodInvocation(tree);
			}
		}
		
	}

}
