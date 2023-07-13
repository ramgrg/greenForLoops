import java.text.MessageFormat;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

public class DonotAccessGlobalVariableInLoopNonCompliant {
	public static int a = 5;
	
	public void test() {
		for(int i = 0; i < 5; i++) {
			System.out.println("The number is " + DonotAccessGlobalVariableInLoopNonCompliant.a);
			DonotAccessGlobalVariableInLoopNonCompliant.a = 6;
			int a = Math.random();
			int b = Math.min(4, 2);
	}
}
