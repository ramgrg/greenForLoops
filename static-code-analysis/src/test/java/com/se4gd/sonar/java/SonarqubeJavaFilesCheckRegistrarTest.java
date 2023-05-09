package com.se4gd.sonar.java;

import org.junit.jupiter.api.Test;
import org.sonar.plugins.java.api.CheckRegistrar;
import static org.assertj.core.api.Assertions.assertThat;

public class SonarqubeJavaFilesCheckRegistrarTest {
	
	@Test
	void checkTotalRules() {
		CheckRegistrar.RegistrarContext context = new CheckRegistrar.RegistrarContext();
		SonarqubeJavaFilesCheckRegistrar myRegistrar = new SonarqubeJavaFilesCheckRegistrar();
		myRegistrar.register(context);	
		
		assertThat(context.checkClasses()).hasSize(2);
		assertThat(context.testCheckClasses()).isEmpty();
	}
	

}
