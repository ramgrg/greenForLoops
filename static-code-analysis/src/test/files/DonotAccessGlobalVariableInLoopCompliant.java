public class DonotAccessGlobalVariableInLoopCompliant {
	public static int a = 5;
	
	public void test() {
		int b = 5;
		for(int i = 0; i < 5; i++) {
			System.out.println("The number is " + b);
		}
	}
}