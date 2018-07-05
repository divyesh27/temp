import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Flatten2DNestedArrayList implements Iterator<Integer> {

	private List<Integer> flattenlist;
	private Iterator<Integer> iter;
	
	public Flatten2DNestedArrayList(List<Flatten2DNestedArrayList> nestlist) {
		flattenlist = new ArrayList<>();
		
	}
	
	private void flattenlist(List<Flatten2DNestedArrayList> list) {
		
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
