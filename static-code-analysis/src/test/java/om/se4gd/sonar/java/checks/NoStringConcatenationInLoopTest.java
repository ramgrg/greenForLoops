package om.se4gd.sonar.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

import com.se4gd.sonar.java.checks.NoStringConcatenationInLoop;
//import org.sonar.java.model.VisitorsBridgeForTests;

public class NoStringConcatenationInLoopTest {
	
	@Test
	void checkCodesWithEnergySmell() {
		CheckVerifier.newVerifier()
		.onFile("src/test/files/NoStringConcatenationInLoop.java")
		.withCheck(new NoStringConcatenationInLoop())
		.verifyIssues();
	}
	
	@Test
	void checkCodesWithoutEnergySmell() {
		CheckVerifier.newVerifier()
		.onFile("src/test/files/EcoFriendlyStringsConcatenationInLoop.java")
		.withCheck(new NoStringConcatenationInLoop())
		.verifyNoIssues();
	}
}
