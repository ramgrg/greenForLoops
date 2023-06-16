import java.util.Iterator;

public class AvoidBig0TimeComplexityNonCompliant {
	public void test() {
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println("Hello world");
			}
		}
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println("Hello world");
			}
		}
		
		for(int j = 0; j < 5; j++) {
			System.out.println("Hello world 1");
		}
		
		int i = 0;
		int j = 0;
		while(i < 5) {
			System.out.println("Hello world");
			while (j < 5) {
				System.out.println("Hello world 1");
				j++;
			}
			i++;
		}
		
		int k = 0;
		while(k < 5) {
			System.out.println("Hello world");
			k++;
		}
	}
}
