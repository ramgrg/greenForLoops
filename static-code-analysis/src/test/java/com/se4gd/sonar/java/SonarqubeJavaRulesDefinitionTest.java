package com.se4gd.sonar.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinition.Param;
import org.sonar.api.server.rule.RulesDefinition.Repository;
import org.sonar.api.server.rule.RulesDefinition.Rule;
import org.sonar.api.server.debt.DebtRemediationFunction.Type;

public class SonarqubeJavaRulesDefinitionTest {
	
	@Test
	void testSonarqubeJavaRulesDefinition() {
		SonarqubeJavaRulesDefinition rulesDefinition = new SonarqubeJavaRulesDefinition(new SonarqubeJavaPluginTest.MockedSonarqubeRuntime());
		RulesDefinition.Context context = new RulesDefinition.Context();
		rulesDefinition.define(context);
		RulesDefinition.Repository repository = context.repository(SonarqubeJavaRulesDefinition.PLUGIN_REPOSITORY_KEY);
		
		assertThat(repository.name()).isEqualTo(SonarqubeJavaRulesDefinition.PLUGIN_NAME);
        assertThat(repository.language()).isEqualTo(SonarqubeJavaRulesDefinition.PLUGIN_LANGUAGE);
        assertThat(repository.rules()).hasSize(SonarqubePluginRulesList.getChecks().size());
        assertThat(repository.rules().stream().filter(Rule::template)).isEmpty();
	}
	
	
	private static void assertRuleProperties(Repository repository) {
        Rule rule = repository.rule("RE1");
        assertThat(rule).isNotNull();
        assertThat(rule.name()).isEqualTo("Do not concatenate string inside loops. If you have to, use StringBuilder instead.");
        assertThat(rule.debtRemediationFunction().type()).isEqualTo(Type.CONSTANT_ISSUE);
        assertThat(rule.type()).isEqualTo(RuleType.CODE_SMELL);
    }

    private static void assertAllRuleParametersHaveDescription(Repository repository) {
        for (Rule rule : repository.rules()) {
            for (Param param : rule.params()) {
                assertThat(param.description()).as("description for " + param.key()).isNotEmpty();
            }
        }
    }
}
