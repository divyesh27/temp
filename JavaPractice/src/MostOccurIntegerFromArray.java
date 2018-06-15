import java.util.HashMap;
import java.util.Map;


public class MostOccurIntegerFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {2,3,4,5,2,3,2};
		System.out.println(FindMostOccurIntFromArray(input));
		
	}
	private static int FindMostOccurIntFromArray(int[] input)
	{
		if(input == null)
			return 0;
		int len = input.length;
		if(len <=1)
			return input[0];
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<len;i++)
		{
			int curint = input[i];
			if(!hm.containsKey(curint))
				hm.put(curint,1);
			else
				hm.put(curint, hm.get(curint)+1);
			
		}
		
		int c = -1;
		int max = -1;
		
		for(int i=0; i<len;i++)
		{
			if(max < hm.get(input[i]))
			{ 
				max = hm.get(input[i]);
				c = input[i];
			}
		}
		
		return c;
	}
}
