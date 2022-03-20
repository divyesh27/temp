
/* 

You have a file in the filesystem at path /a/b/c and the data has newline seperator.
Then the content inside this file (api log) is as followed and they're comma delimited:

timestamp, request_id, customer_id, query_size, time_prepared_ms, time_processed_ms

12342334534, rid-1234-3434, cid-x123, 1245, 203, 530
12342334535, rid-1234-2345, cid-y34, 2345, 21, 45
...
...
...

write a report that aggregates the number of records, average processed time and average prepped time for all unique customers and output in this format:

> customer_X: 4 records, 4.1 avg_time_prepared_ms, 8.4 avg_time_processed_ms
> customer_Y: 8 records, 2.1 avg_time_prepared_ms, 5.4 avg_time_processed_ms

 */

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class ReadLogFileParseProcessPrepTime {

	private List<Integer> prepTime;
	private List<Integer> processTime;

	public List<Integer> getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(List<Integer> prepTime) {
		this.prepTime = prepTime;
	}

	public List<Integer> getProcessTime() {
		return processTime;
	}

	public void setProcessTime(List<Integer> processTime) {
		this.processTime = processTime;
	}

	public static void main(String[] args) {

		String inputString = "12342334534, rid-1234-3434, cid-x123, 1245, 203, 530\n" + 
				"12342334535, rid-1234-2345, cid-y34, 2345, 21, 45\n" + 
				"12342334534, rid-1234-3434, cid-x123, 1245, 208, 630\n" +
				"12342334535, rid-1234-2345, cid-y34, 2345, 22, 65\n";
		HashMap<String, ReadLogFileParseProcessPrepTime> hm = new HashMap<String, ReadLogFileParseProcessPrepTime>();
		parser(inputString, hm);
		print(hm);
		printAggregate(hm);
	}
	
	public static void print(HashMap<String, ReadLogFileParseProcessPrepTime> hm) {

		for(String key : hm.keySet()) {
			System.out.println("Key " + key + " Value " + hm.get(key).getPrepTime());
			System.out.println("Key " + key + " Value " + hm.get(key).getProcessTime());
		}
	}
	
	public static void parser(String inputString, HashMap<String, ReadLogFileParseProcessPrepTime> hm) {

		if (inputString == null || inputString.isEmpty())
			return;


		String[] input = inputString.split("\n");
		for (int i = 0; i < input.length; i++) {

			String[] record = input[i].split(",");
			if(hm.containsKey(record[2])) {

				ReadLogFileParseProcessPrepTime l1 = hm.get(record[2]);
				l1.getPrepTime().add(Integer.parseInt(record[4].trim()));
				l1.getProcessTime().add(Integer.parseInt(record[5].trim()));

			}
			else {
				ReadLogFileParseProcessPrepTime fileObj = new ReadLogFileParseProcessPrepTime();
				fileObj.setPrepTime(new ArrayList<>(Arrays.asList(Integer.parseInt(record[4].trim()))));
				fileObj.setProcessTime(new ArrayList<>(Arrays.asList(Integer.parseInt(record[5].trim()))));
				hm.put(record[2],fileObj);
			}
		}

	}
	
	public static void printAggregate(HashMap<String, ReadLogFileParseProcessPrepTime> hm) {
		
		for(String key : hm.keySet()) {
			Integer totalPrep = 0;
			Integer countPrep = 0;
			Integer totalProcess = 0;
			Integer countProcess = 0;
			
			for (Integer i : hm.get(key).getPrepTime()) {
				totalPrep += i;
				countPrep ++;
			}
			System.out.println("Key " + key + " Avg process " + totalPrep/countPrep);
			for (Integer j : hm.get(key).getProcessTime()) {
				totalProcess += j;
				countProcess ++;
			}
			System.out.println("Key " + key + " Avg process " + totalProcess/countProcess);
		}
		
	}

}
