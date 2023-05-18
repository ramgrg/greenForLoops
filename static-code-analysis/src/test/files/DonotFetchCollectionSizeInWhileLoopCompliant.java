import java.util.ArrayList;
import java.util.List;

public class DonotFetchCollectionSizeInWhileLoopCompliant {
	public void compliantForLoop() {
		List<Integer> integerList  = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		
		int listSize  = integerList.size();
		int i = 0;
		while (i < listSize) {
			//some operations
			i++;
		}
	}

}
