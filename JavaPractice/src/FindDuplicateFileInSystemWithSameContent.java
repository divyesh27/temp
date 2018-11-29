import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileInSystemWithSameContent {
		/*
		Input:
		["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
		Output:  
		[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
		*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] input = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		System.out.println(findDuplicate(input));
	}
	
	public static List<List<String>> findDuplicate(String[] paths) {
		HashMap <String, List<String>> map = new HashMap<>();
		for(String path : paths) {
			String[] values = path.split(" ");
			for(int i=1; i< values.length; i++) {
				String[] name = values[i].split("\\(");
				name[1] = name[1].replaceAll("\\)","");
				List<String> list = map.getOrDefault(name[1], new ArrayList<String>());
				list.add(values[0] + "/" + name[0]);
				map.put(name[1], list);
					
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for(String key : map.keySet()) {
			if(map.get(key).size() > 1)
				result.add(map.get(key));
		}
		return result;
	}

}
