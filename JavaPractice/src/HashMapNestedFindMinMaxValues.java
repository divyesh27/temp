import java.util.HashMap;
import java.util.Map;

public class HashMapNestedFindMinMaxValues {

	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> budget = new HashMap<>();

		Map<String, Object> hm = new HashMap<>();
		hm.put("Test1", 100);
		hm.put("Test2", new HashMap() {{ put ("Test3", 200); }});
		hm.put("Test3", 500);
		hm.put("Test4", new HashMap() {{ put("Test6",new HashMap() {{ put("Test8", 600); }}); }});
		hm.put("Test9", new HashMap() {{ put("Test10", new HashMap() {{ put("Test11", new HashMap() {{ put("Test12", 10); }}); }}); }});
		hm.put("Test", 110);
		hm.put("Test13", new HashMap() {{ put("Test14", new HashMap() {{ put("Test15",900); }}); }});
		
		System.out.println("Found Min value " + findMinHashMapNestedValue(hm));
		System.out.println("Found Max value " + findMaxHashMapNestedValue(hm));
		
		budget.put("clothes", 120);
		budget.put("grocery", 150);
		budget.put("transportation", 100);
		budget.put("utility", 130);
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);
		
		System.out.println(findMinValue(budget));
	}
	
	public static int findMinValue(Map<String,Integer> budget) {
		
		if(budget == null)
			throw new IllegalArgumentException("Pass valid input");
		
		int max = Integer.MIN_VALUE;
		for(Integer i : budget.values()) {
			
			if(i != null && i > max)
				max = i;
		}
		return max;
	}
	
	@SuppressWarnings("unchecked")
	public static int findMinHashMapNestedValue(Map<String, Object> hm) {
		
		if(hm == null)
			throw new IllegalArgumentException("Pass valid input");
		
		Integer min = Integer.MAX_VALUE;
		for(Object o : hm.values()) {
			if(o instanceof HashMap) {
				Integer i = findMinHashMapNestedValue((HashMap<String, Object>)o);
				if (i < min && i != null)
					min = i;
			}
			if(o != null && o instanceof Integer) {
				if((Integer) o < min)
					min = (Integer) o;
			}
			
		}
		return min;
	}
	
	@SuppressWarnings("unchecked")
	public static Integer findMaxHashMapNestedValue(Map<String, Object> hm) {
		
		if(hm == null)
			throw new IllegalArgumentException("Pass valid input");
		
		Integer max = Integer.MIN_VALUE;
		for(Object o : hm.values()) {
			if(o instanceof HashMap) {
				Integer i = findMaxHashMapNestedValue((HashMap<String, Object>)o);
				if(i > max)
					max = i;
			}
			if(o != null && o instanceof Integer) {
				if((Integer) o > max)
					max = (Integer) o;
			}
			
		}
		return max;
	}
	
}
