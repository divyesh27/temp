
public class MoveAllZerosToRightSideArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        MoveZerosToEnd(arr, n);
        printArray(arr,n);
        MoveZerosToStartAndOneToEnd(arr,n);
        printArray(arr,n);
        
	}
	public static void MoveZerosToEnd(int [] inputarray, int n)
	{
		int count = 0;
		for(int i=0; i<n; i++)
		{
			if(inputarray[i] != 0)
				inputarray[count++] = inputarray[i];
		}
		while(count < n)
			inputarray[count++] = 0;
	}
	
	public static void MoveZerosToStartAndOneToEnd(int[] inputarray, int n) {
		int count = n-1;
		for(int i=n-1; i>=0; i--) {
			if(inputarray[i] != 0) {
				inputarray[count--] = inputarray[i];
			}
		}
		while(count >= 0)
			inputarray[count--] = 0;
	}
	
	public static void printArray(int[] inputarray, int n) {
		System.out.println();
		System.out.println("Array after pushing zeros to the back/front: ");
        for (int i=0; i<n; i++)
            System.out.print(inputarray[i]+" ");
	}

}
