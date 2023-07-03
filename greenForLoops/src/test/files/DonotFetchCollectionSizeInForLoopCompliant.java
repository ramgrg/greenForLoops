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
	}

}
