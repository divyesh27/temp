import java.util.HashMap;

public class PrintMatchAndMismatchElementsSamePositionTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {3,4,5,7,2,6,8,0,1,3,5,7,9};
		int[] arr2 = {3,4,6,3,5,7,9,3,5,2,4,7,9};
		printMatchAndMismatchElements(arr1,arr2);
	}
	
	public static void printMatchAndMismatchElements(int[] arr1, int[] arr2) {
		
		if(arr1 == null || arr2 == null || arr1.length != arr2.length) {
			throw new IllegalArgumentException("Pass valid input");
		}
		
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] == arr2[i])
				System.out.println("Exact Match " + arr1[i]);
			
			else {
				if(hm.containsKey(arr1[i])) {
					hm.put(arr1[i],hm.get(arr1[i])+1);
				}
				else {
					hm.put(arr1[i], 1);
				}
			}
		}
		for(int i=0; i<arr2.length; i++) {
			if(hm.containsKey(arr2[i]) && hm.get(arr2[i])>0) {
				System.out.println("Mis Match " + arr2[i]);
				hm.put(arr2[i], hm.get(arr2[i])-1);
			}
		}
		
	}

}
