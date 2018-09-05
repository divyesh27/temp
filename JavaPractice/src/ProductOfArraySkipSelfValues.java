
public class ProductOfArraySkipSelfValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i : (productOfArrayExceptSelf(new int [] {4,2,1,3}))) {
			System.out.println(i);
		}
		for(int i : (productOfArrayExceptSelfElement(new int [] {1,2,3,1}))) {
			System.out.println(i);
		}
	}

	public static int[] productOfArrayExceptSelf(int[] inputArray) {

		int[] result = new int[inputArray.length];

		result[inputArray.length - 1] = 1;
		for (int i = inputArray.length - 1; i > 0; i--) {
			result[i-1] = result[i] * inputArray[i];
		}

		int left = 1;
		for (int i = 0; i < inputArray.length; i++) {
			result[i] = result[i] * left;
			left = left * inputArray[i];
		}
		return result;
	}
	
	public static int[] productOfArrayExceptSelfElement(int[] inputArray) {
		
		int size = inputArray.length;
		int[] result = new int [size];
		
		int[] t1 = new int[size];
		int[] t2 = new int[size];
		
		t1[0] = 1;
		t2[size-1] = 1;
		int i;
		for(i=0; i<size-1;i++) {
			t1[i+1] = t1[i] * inputArray[i];
		}
		
		for(i=size-1; i>0; i--) {
			t2[i-1] = t2[i] * inputArray[i];
		}
		
		for(i=0; i<size; i++) {
			result[i] = t1[i] * t2[i];
		}
		return result;
	}

}
