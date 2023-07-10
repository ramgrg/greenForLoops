import java.util.Iterator;

public class AvoidBig0TimeComplexityNonCompliant {
	public void test() {
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.println("Hello world");
			}
		}
		for(int j = 0; j < 5; j++) {
			System.out.println("Hello world 1");
		}
		for(int j = 0; j < 5; j++) {
			System.out.println("Hello world 1");
		}
		for(int j = 0; j < 5; j++) {
			System.out.println("Hello world 1");
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
		int k = 0;
		while(k < 5) {
			System.out.println("Hello world");
			k++;
		}
		int k = 0;
		while(k < 5) {
			System.out.println("Hello world");
			k++;
		}
		int l = 0;
		int m = 0;
		while(l < 5) {
			System.out.println("Hello world");
			while (m < 5) {
				System.out.println("Hello world 1");
				m++;
			}
			l++;
		}
		
		int[] a = {1,2,3,4,5};
		int[] b = {1,2,3,4,5};
		for (int n : b) {
			for (int o : a) {
				
			}
		}
		
		for (int n : b) {
			
		}
	}
}
