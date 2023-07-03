import java.util.ArrayList;
import java.util.List;

public class DonotFetchCollectionSizeInWhileLoopNonCompliant {
	public void nonCompliantWhileLoop() {
		List<Integer> integerList  = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		
		int i = 0;
		while (i < integerList.size()) {
			//some operations
			i++;
		}
	}

}
