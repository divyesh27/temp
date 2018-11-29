import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapSortingAscendingDescending {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> budget = new HashMap<>();

		budget.put("clothes", 120);
		budget.put("grocery", 150);
		budget.put("transportation", 100);
		budget.put("utility", 130);
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);
		System.out.println("map before sorting: " + budget);

		Map<String, Integer> sorted = budget
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())   // .sorted(Map.Entry.comparingByKey()) to sort by key
				.collect(
						Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e2,
								LinkedHashMap::new));
		
		System.out.println("map after sorting by values: " + sorted);
		
		sorted = budget
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // .sorted(Collections.reverseOrder(Map.Entry.comparingByKey())) to sort by key
				.collect(
						Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e2,
								LinkedHashMap::new));

		System.out.println("map after sorting by values in descending order: " + sorted);
	}

}
