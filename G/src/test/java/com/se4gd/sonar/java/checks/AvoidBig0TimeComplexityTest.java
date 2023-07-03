package com.se4gd.sonar.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;


public class AvoidBig0TimeComplexityTest {
	
	@Test
	public void timeComplexityTestNonCompliant() {
		CheckVerifier.newVerifier()
			.onFile("src/test/files/AvoidBig0TimeComplexityNonCompliant.java")
			.withCheck(new AvoidBig0TimeComplexity())
			.verifyIssues();
	}
	
	@Test
	public void timeComplexityTestCompliant() {
		CheckVerifier.newVerifier()
			.onFile("src/test/files/AvoidBig0TimeComplexityCompliant.java")
			.withCheck(new AvoidBig0TimeComplexity())
			.verifyNoIssues();
	}
}
