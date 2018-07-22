import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Flatten2DNestedArrayList implements Iterator<Integer> {

	private List<String> flattenlist;
	private Iterator<Integer> iter;
	
	public Flatten2DNestedArrayList(Map<String, List<String>> map) {
		map.values().forEach(flattenlist::addAll);
		
		flattenlist = map.values().stream().flatMap(c -> c.stream()).collect(Collectors.toList());
				
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
