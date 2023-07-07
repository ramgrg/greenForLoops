import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DonotFetchCollectionSizeInForLoopNonCompliant {
	
	public void nonCompliantForLoop() {
		List<Integer> integerList  = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		
		
		for (int i = 0; i < integerList.size(); i++) {
			//some operations
		}
		
		int[] a = {1,2,3,6};  
		for (int i = 0; i < a.length; i++) {
			//some operations
		}
	}
}
