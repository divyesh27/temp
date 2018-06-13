
public class FindLongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(FindLongCommSubstringInt("abcdperedfgwerasgdfsh","adgqtfbghfgaafrwelgdfglaewrdsaf"));
		//System.out.println(FindLongCommSubstringInt("abcdperedfgwerasgdfsh","adgqtfbghfga"));
		//System.out.println(FindLongCommSubstringInt("tesla","slate"));
		//System.out.println(FindLongCommSubstringInt("xxxx","slate"));
		System.out.println(FindLongCommSubstringInt("xxxxx","slate"));
	}
	public static int FindLongCommSubstringInt(String str1, String str2)
	{
		if(str1 == null || str2 == null)
			return -1;
		
		int lenstr1 = str1.length();
		int lenstr2 = str2.length();
		
		int max=0;
		int pos_i=0;
		
		int i,j;
		i=j=0;
		//StringBuilder substr = new StringBuilder();
		char [] str1array = str1.toCharArray();
		char [] str2array = str2.toCharArray();
		int[][] matrix = new int[lenstr1+1][lenstr2+1];
		
		for(i=1; i<= lenstr1; i++)
		{
			for(j=1; j<= lenstr2; j++)
			{
				if(str1array[i-1] == str2array[j-1])
				{
					matrix[i][j] = matrix[i-1][j-1] + 1;
					
					if(max < matrix[i][j])
					{
						max = matrix[i][j];
						pos_i = i;
						//pos_j = j;						
					}
				}
			}
		}
		//if(pos_i ==0 && pos_j ==0 )
		if(pos_i ==0)
			return -1;
		if(pos_i >0)
			System.out.println(str1.substring(pos_i-max, pos_i));
		
		/*
		if(pos_i > pos_j)
			System.out.println(str2.substring(pos_j-max, pos_j));
		else
			System.out.println(str1.substring(pos_i-max, pos_i));
		*/
		//System.out.println(str1.substring(pos2,pos1));
		//System.out.println(pos_i + " " +pos_j);
		return max;
	}
	
}
