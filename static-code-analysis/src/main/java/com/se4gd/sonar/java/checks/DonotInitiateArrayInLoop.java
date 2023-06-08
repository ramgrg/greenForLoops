package com.se4gd.sonar.java.checks;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.MethodMatchers;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.NewArrayTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

@Rule(key = "RE3",
		description = DonotInitiateArrayInLoop.RULE_MESSAGE,
		priority = Priority.MINOR)
	

public class DonotInitiateArrayInLoop extends IssuableSubscriptionVisitor{
	public final static String RULE_MESSAGE = "Do not initiate array inside a loop";
	public final static String ARRAY_CLASS_NAME = Array.class.getName();
	
//	private static final MethodMatchers ARRAY_INITIATION = MethodMatchers.or(
//			MethodMatchers.create()
//				.ofAnyType()
//				.names("new")
//				.withAnyParameters()
//				.build()
//	);
	
	private final DonotInitiateArrayInLoopVisitor donotInitiateArrayInLoopVisitor = new DonotInitiateArrayInLoopVisitor();
	
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
		tree.accept(donotInitiateArrayInLoopVisitor);
	}
	
	private class DonotInitiateArrayInLoopVisitor extends BaseTreeVisitor{
		@Override
		public void visitNewArray(NewArrayTree tree) {
			// TODO Auto-generated method stub
			if (tree.is(Tree.Kind.NEW_ARRAY)) {
				reportIssue(tree, RULE_MESSAGE);
			}else {
				super.visitNewArray(tree);
			}
		}
		
		public boolean isArray(ExpressionTree expressionTree) {
			return expressionTree.symbolType().is(ARRAY_CLASS_NAME);
		} 
	}
}
