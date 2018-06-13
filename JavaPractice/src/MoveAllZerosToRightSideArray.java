
public class MoveAllZerosToRightSideArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        MoveZerosToEnd(arr, n);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
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

}
