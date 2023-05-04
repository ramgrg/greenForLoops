package com.se4gd.sonar.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

//import com.se4gd.sonar.java.checks.DonotFetchCollectionSizeInLoop;

public class DonotFetchCollectionSizeInLoopTest {
	
	@Test
	void forLoopNonCompliantTest() {
		CheckVerifier.newVerifier()
			.onFile("src/test/files/DonotFetchCollectionSizeInForLoopNonCompliant.java")
			.withCheck(new DonotFetchCollectionSizeInLoop())
			.verifyIssues();
	}
	
	@Test
	void forLoopCompliantTest() {
		CheckVerifier.newVerifier()
		.onFile("src/test/files/DonotFetchCollectionSizeInForLoopCompliant.java")
		.withCheck(new DonotFetchCollectionSizeInLoop())
		.verifyNoIssues();
	}

}
