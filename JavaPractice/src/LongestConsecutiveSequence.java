import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] num = {100, 4, 200, 1, 3, 2};
	//	int num[] = {1, 9, 3, 10, 4, 20, 2};
		int num[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
		System.out.println(LongestConSequence(num));
	}
	
	private static int LongestConSequence(int [] num)
	{
		if(num.length == 0)
			return 0;
		
		HashSet<Integer> set = new HashSet<Integer>();
		int max = 1;
		
		for(int e : num)
			set.add(e);
		
		for(int e : num)
		{
			int left = e-1;
			int right = e+1;
			int count = 1;
			
			while(set.contains(left))
			{
				count++;
				set.remove(left);
				left--;
			}
			while(set.contains(right))
			{
				count++;
				set.remove(right);
				right++;
			}
			max = Math.max(max, count);
		}
		return max;
	}

}
