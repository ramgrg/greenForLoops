import java.util.ArrayList;
import java.util.List;

public class DonotFetchCollectionSizeInForLoopCompliant {
	public void compliantForLoop() {
		List<Integer> integerList  = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		
		int listSize  = integerList.size();
		
		for (int i = 0; i < listSize; i++) {
			//some operations
		}
		
		int[] a = {1,2,3,6};  
	    int arrayLength = a.length;
	    for (int i = 0; i < arrayLength; i++) {
	            //some operations
	    }
	}

}
