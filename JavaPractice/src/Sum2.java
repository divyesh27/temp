import java.util.HashMap;


public class Sum2 {

		public static void main(String[] args) {
		int[] a={8,1,3,2,6,4,5,9,10};
		int finalSum=6;
		int temp=-1;
		int sec =-1;
		HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		for(int i=0;i<a.length;i++)
		{
			map.put(a[i], true);
		}
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<finalSum)
			{
				temp=finalSum-a[i];
				if(map.containsKey(temp))
				{
					System.out.println("output - " +a[i]+" "+temp);
					map.remove(temp);
					map.remove(a[i]);
				}
			}
		}
}
}