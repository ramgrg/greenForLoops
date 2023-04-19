package com.se4gd.sonar.java;

import java.util.List;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.api.sonarlint.SonarLintSide;


@SonarLintSide
public class SonarqubeJavaFilesCheckRegistrar implements CheckRegistrar {

	@Override
	public void register(RegistrarContext registrarContext) {
		// TODO Auto-generated method stub
		registrarContext.registerClassesForRepository(SonarqubeJavaRulesDefinition.PLUGIN_REPOSITORY_KEY, checkClasses(), testCheckClasses());
	}

	private List<Class<? extends JavaCheck>> testCheckClasses() {
		// TODO Auto-generated method stub
		return SonarqubePluginRulesList.getJavaTestChecks();
	}

	private List<Class<? extends JavaCheck>> checkClasses() {
		// TODO Auto-generated method stubb
		return SonarqubePluginRulesList.getJavaChecks();
	}

}
