package com.se4gd.sonar.java.checks;

import java.util.List;

import java.util.Arrays;
import java.util.Collections;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
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
	}
	
	@Override
	public void visitNode(Tree tree) {
		//implementation
		tree.accept(donotAccessGlobalVariableInLoopVisitor);
		
	}
	private class DonotAccessGlobalVariableInLoopVisitor extends BaseTreeVisitor{

		@Override
		public void visitMemberSelectExpression(MemberSelectExpressionTree tree) {
			if (tree.expression().is(Tree.Kind.MEMBER_SELECT)) {
		        visitMemberSelectExpression((MemberSelectExpressionTree) tree.expression());
		      } else if (tree.expression().is(Tree.Kind.IDENTIFIER)) {
		    	  Symbol symbol = tree.identifier().symbol();
		    	  if (symbol.isStatic() && symbol.name() != null && !(symbol.owner().type().is("java.lang.System"))){
		    		  reportIssue(tree, RULE_MESSAGE);
		    	  }else {
		    		  super.visitMemberSelectExpression(tree);
		    	  }	
		      }
		}
	}
}
