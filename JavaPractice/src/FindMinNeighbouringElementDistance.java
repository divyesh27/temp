
public class FindMinNeighbouringElementDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //int []arr= new int[]{4,8,6,1,2,9,4};
		// int [] arr = new int[] {1,1,1,1};
		 int [] arr = {1, 3, 3};
	     System.out.println(smallestDistance(arr));
	}

	private static int smallestDistance(int [] array){
	    
		if(array == null)
			throw new IllegalArgumentException("Pass valid input");
		
		int size = array.length;
		if(size == 0 || size == 1)
			return -1;
		
        int smallest = Math.abs(array[0]-array[1]);
        int index = 0;
        for(int i=1; i<size-1; i++){
            int value = Math.abs(array[i]-array[i+1]);
            if(value< smallest){
            smallest= value;
            index = i;
            }
                
        }
        return index;
            
    }

}
