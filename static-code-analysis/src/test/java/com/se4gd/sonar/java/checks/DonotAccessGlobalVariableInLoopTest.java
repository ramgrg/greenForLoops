package com.se4gd.sonar.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

public class DonotAccessGlobalVariableInLoopTest {
	@Test
	void donotAccessGlobalVariableInLoopNonCompliant() {
		CheckVerifier.newVerifier()
			.onFile("src/test/files/DonotAccessGlobalVariableInLoopNonCompliant.java")
			.withCheck(new DonotAccessGlobalVariableInLoop())
			.verifyIssues();
	}
	
	@Test
	void donotAccessGlobalVariableInLoopCompliant() {
		CheckVerifier.newVerifier()
			.onFile("src/test/files/DonotAccessGlobalVariableInLoopCompliant.java")
			.withCheck(new DonotAccessGlobalVariableInLoop())
			.verifyNoIssues();
	}

}
