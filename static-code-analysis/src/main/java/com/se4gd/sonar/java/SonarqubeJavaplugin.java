package com.se4gd.sonar.java;
import org.sonar.api.Plugin;

public class SonarqubeJavaplugin implements Plugin {
	
	@Override
	public void define(Context context) {
		// TODO Auto-generated method stub
		
		//object instantiated during server start
		context.addExtension(SonarqubeJavaRulesDefinition.class);
		
		//object instantiated during static code analysis
		context.addExtension(SonarqubeJavaFilesCheckRegistrar.class);
		
	}

}
