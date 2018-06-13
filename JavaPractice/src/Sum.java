import java.util.HashMap;
import java.util.HashSet;



public class Sum {
	public static void main(String[] args) {
	int[] a={8,1,3,2,6,4,5,9,10};
	int finalSum=6;
	int first=-1;
	int sec =-1;
	HashSet<Integer> set=new HashSet<Integer>();
	
for(int i=0;i<a.length;i++)
{
	if(a[i]<finalSum)
	{
		first =a[i];
	}
	for(int j=1;j<a.length;j++)
	{
		if(a[j]<finalSum)
		{
			if(a[i]+a[j]==finalSum)
			{
				System.out.println(a[i]+" "+a[j]);
				set.add(a[i]);
				set.add(a[j]);
				
			}
		}
	}
	
//	for(int k=0;k<map.size();k++)
//	{
//		System.out.println(set..get(k) );
//	}
	System.out.println("Final - "+ set.toString());
}
	}
}

	
//	
//	//sum(array,finalSum)
//	//System.out.println(isPalindrome(str));
//	System.out.println());
//	}
//	public static boolean isPalindrome(String str)
//	{
//		//char[] array=str.toCharArray();
//		int len=str.length()/2;
//		//boolean flag=false;
//		for(int i=0, j=str.length()-1;i<=len;i++,j--)
//		{
//			if(str.charAt(i)!=str.charAt(j))
//			return false;
//		}
//		return true;
//	}
//	
//	public static boolean isPalindrome2(String str)
//	{
//		int left=0;
//		int right = str.length()-1;
//		while(left<right)
//		{
//			if(str.charAt(left)!=str.charAt(right))
//			{
//				return false;
//			}
//				left++;
//				right--;
//			
//		}
//		return true;
//	}
//	
//}