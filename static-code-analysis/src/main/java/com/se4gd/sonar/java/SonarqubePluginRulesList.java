  package com.se4gd.sonar.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.sonar.plugins.java.api.JavaCheck;

import com.se4gd.sonar.java.checks.AvoidBig0TimeComplexity;
import com.se4gd.sonar.java.checks.DonotAccessGlobalVariableInLoop;
import com.se4gd.sonar.java.checks.DonotFetchCollectionSizeInLoop;
import com.se4gd.sonar.java.checks.DonotInitiateArrayInLoop;
import com.se4gd.sonar.java.checks.NoStringConcatenationInLoop;

public final class SonarqubePluginRulesList {

	  private SonarqubePluginRulesList() {
	  }

	  public static List<Class<? extends JavaCheck>> getChecks() {
	    List<Class<? extends JavaCheck>> javaChecks = new ArrayList<>();
	    javaChecks.addAll(getJavaChecks());
	    javaChecks.addAll(getJavaTestChecks());
	    return Collections.unmodifiableList(javaChecks);
	  }

	  /**
	   * These rules are going to target MAIN code only
	   */
	  public static List<Class<? extends JavaCheck>> getJavaChecks() {
		  return Collections.unmodifiableList(Arrays.asList(NoStringConcatenationInLoop.class,
		    		DonotFetchCollectionSizeInLoop.class, DonotInitiateArrayInLoop.class, DonotAccessGlobalVariableInLoop.class, AvoidBig0TimeComplexity.class));
	  }

	  /**
	   * These rules are going to target TEST code only
	   */
	  public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
		  return Collections.emptyList();
	  }
	}
