package com.se4gd.sonar.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.sonar.api.SonarEdition;
import org.sonar.api.SonarQubeSide;
import org.sonar.api.SonarRuntime;
import org.sonar.api.server.*;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.utils.Version;
import org.sonar.plugins.java.JavaSonarWayProfile;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonarsource.analyzer.commons.RuleMetadataLoader;
import org.sonar.api.internal.SonarRuntimeImpl;

public class SonarqubeJavaRulesDefinition implements RulesDefinition{
	
	private static final String RULES_BASE_PATH = "com/se4gd/sonar/l10n/java/rules/java";
	
	public static final String PLUGIN_NAME = "GreenForLoop";
    public static final String PLUGIN_LANGUAGE = "java";
    public static final String PLUGIN_REPOSITORY_KEY = "java-greenforloop";
    
    private static final Set<String> RULE_TEMPLATES_KEY = Collections.emptySet();
    
  /*  private final SonarRuntime runtime;
    public SonarqubeJavaRulesDefinition(SonarRuntime runtime) {
    	this.runtime = runtime;
    } */
	
	
    public void define(Context context) {
		// TODO Auto-generated method stub
		NewRepository repository = context.createRepository(PLUGIN_REPOSITORY_KEY, PLUGIN_LANGUAGE).setName(PLUGIN_NAME);
		
		SonarRuntime runtime = SonarRuntimeImpl.forSonarQube(Version.create(9, 2), SonarQubeSide.SCANNER, SonarEdition.COMMUNITY);
				
		RuleMetadataLoader ruleMetadataLoader = new RuleMetadataLoader(RULES_BASE_PATH, runtime);
		
		ruleMetadataLoader.addRulesByAnnotatedClass(repository, new ArrayList<>(SonarqubePluginRulesList.getChecks()));
		
		setRuleTemplates(repository);

        repository.done();
	}


	private void setRuleTemplates(NewRepository repository) {
		// TODO Auto-generated method stub
		RULE_TEMPLATES_KEY.stream()
        .map(repository::rule)
        .filter(Objects::nonNull)
        .forEach(rule -> rule.setTemplate(true));
		
	}

}
