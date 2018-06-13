import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {100, 4, 200, 1, 3, 2};
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
