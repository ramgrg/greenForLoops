import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

public class DonotAccessGlobalVariableInLoopNonCompliant {
	public static int a = 5;
	
	public void test() {
		for(int i = 0; i < 5; i++) {
			System.out.println("The number is " + a);
			a = 6;
		}
	}
}
