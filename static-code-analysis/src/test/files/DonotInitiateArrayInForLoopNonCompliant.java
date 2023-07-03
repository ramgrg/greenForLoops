import static org.assertj.core.api.Assertions.in;

import java.util.ArrayList;
import java.util.List;

public class DonotInitiateArrayInForLoopNonCompliant {
	public void nonCompliantForLoop() {
		
		for (int i = 0; i < 5; i++) {
			//some operations
			int[] a = new int[10];
			Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		}
		int i = 0;
		while(i < 5) {
			int[] a = new int[10];
			i++;
		}
	}
}
