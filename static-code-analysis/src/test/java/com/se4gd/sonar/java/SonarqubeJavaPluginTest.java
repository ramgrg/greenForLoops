package com.se4gd.sonar.java;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.sonar.api.Plugin;
import org.sonar.api.SonarEdition;
import org.sonar.api.SonarProduct;
import org.sonar.api.SonarQubeSide;
import org.sonar.api.SonarRuntime;
import org.sonar.api.utils.Version;

public class SonarqubeJavaPluginTest {
	
	@Test
	
	void testClass() {
		Plugin.Context context = new Plugin.Context(new MockedSonarqubeRuntime());
		
		new SonarqubeJavaplugin().define(context);
		
		assertThat(context.getExtensions()).hasSize(2);
	}
	
	public static class MockedSonarqubeRuntime implements SonarRuntime{

		@Override
		public Version getApiVersion() {
			// TODO Auto-generated method stub
			return Version.create(9, 8);
		}

		@Override
		public SonarEdition getEdition() {
			// TODO Auto-generated method stub
			return SonarEdition.COMMUNITY;
		}

		@Override
		public SonarProduct getProduct() {
			// TODO Auto-generated method stub
			return SonarProduct.SONARQUBE;
		}

		@Override
		public SonarQubeSide getSonarQubeSide() {
			// TODO Auto-generated method stub
			return SonarQubeSide.SCANNER;
		}
		
	}

}
