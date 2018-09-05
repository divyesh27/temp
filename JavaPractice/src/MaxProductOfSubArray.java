
public class MaxProductOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(productOfSubArrayContiguous(new int[] { -1, -3, -10, 0, 60  }));
		System.out.println(productOfSubArrayContiguous(new int[] { 6, -3, -10, 0, 2  }));
		System.out.println(productOfSubArrayContiguous(new int[] { -2, -3, 0, -2, -40  }));
		System.out.println(productOfSubArrayContiguous(new int[] { 1, -2, -3, 0, 7, -8, -2  }));
		System.out.println(productOfSubArrayContiguous(new int[] { 0, 7, -8, -2  }));

	}

	public static int productOfSubArrayContiguous(int[] inputArray) {

		int maxValue = inputArray[0];
		int minValue = inputArray[0];
		
		int maxProduct = inputArray[0];
		
		for(int i=1; i<inputArray.length; i++) {
			
			if(inputArray[i] < 0) {
				int temp = maxValue;
				maxValue = minValue;
				minValue = temp;
			}
			
			maxValue = Math.max(inputArray[i], maxValue * inputArray[i]);
			minValue = Math.min(inputArray[i], minValue * inputArray[i]);
			
			maxProduct = Math.max(maxProduct, maxValue);
		}
		return maxProduct;
	}

}
