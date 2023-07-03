package com.se4gd.sonar.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

public class DonotInitiateArrayInLoopTest {
	
	@Test
	void testArrayInitiationInForLoopNonCompliant() {
		CheckVerifier.newVerifier()
			.onFile("src/test/files/DonotInitiateArrayInForLoopNonCompliant.java")
			.withCheck(new DonotInitiateArrayInLoop())
			.verifyIssues();
	}
	
	@Test
	void testArrayInitiationInForLoopCompliant() {
		CheckVerifier.newVerifier()
			.onFile("src/test/files/DonotInitiateArrayInForLoopCompliant.java")
			.withCheck(new DonotInitiateArrayInLoop())
			.verifyNoIssues();
	}

}
