
public class FindMaxDiffInArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxDiff(new int[] {2, 3, 10, 6, 4, 8, 1}));
		System.out.println(maxDiff(new int[] {7, 9, 5, 6, 3, 2}));
	}
	

	public static int maxDiff(int[] inputArray) {
		if(inputArray == null || inputArray.length < 2)
			return -1;
		
		int maxDiff = inputArray[1] - inputArray[0];
		int minElement = inputArray[0];
		
		for(int i=1; i<inputArray.length; i++) {
			if(inputArray[i] - minElement > maxDiff) {
				maxDiff = inputArray[i] - minElement;
			}
			if(inputArray[i] < minElement) {
				minElement = inputArray[i];
			}
		}
		return maxDiff <=0 ? -1 : maxDiff;
	}
}
