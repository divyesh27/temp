
public class FindSquareRootOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(mySqrt(4));
		//System.out.println(findSqrt(4));
		System.out.println(floorSqrt(16));
		System.out.println(findRoot(15));
	}
	public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } 
            else if (mid+1 > x/(mid+1))
                return mid;
                
            else {
            	left = mid + 1;
            }
        }
    }
	
	static int findSqrt(int inputNumber)
    {
        // Base cases
        if (inputNumber == 0 || inputNumber == 1)
            return inputNumber;
 
        // Staring from 1, try all numbers until
        // i*i is greater than or equal to x.
        int i = 1, result = 1;
         
        while (result <= inputNumber) {
        	i++;
        	result = i * i;
        }
        return i - 1;
    }
	
	public static int floorSqrt(int x)
    {
        // Base Cases
        if (x == 0 || x == 1)
            return x;
 
        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            // If x is a perfect square
            if (mid*mid == x)
                return mid;
 
            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }
	
	static double findRoot(int num){
        double start =0;
        double end = num;
        while(Math.abs(start - end) > 0.01){
        	System.out.println("Math Abs start-end" + Math.abs(start-end));
        	System.out.println("End value" + end);
        	System.out.println("Start value" + start);
            end = (start + end)/2;
            start = num/end;
        }
        
        return end;
    }

}
