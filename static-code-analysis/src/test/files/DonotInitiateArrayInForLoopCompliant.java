import java.util.ArrayList;
import java.util.List;

public class DonotInitiateArrayInForLoopCompliant {
	public void compliantForLoop() {
		int[] a = new int[10];
		for (int i = 0; i < 5; i++) {
			//some operations
		}
		int i = 0;
		int[] b = new int[10];
		while(i < 5) {
			//some operations
			i++;
		}
	}
}
