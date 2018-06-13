import java.util.*;


public class BuySellMaxProfitOnKTransaction 
{
	public static int maxProfit(int[] prices,int k)
	{
		if(k == 0 || prices.length == 0)
			return 0;
		
		int Tran[][] = new int [k+1][prices.length];
		int maxDiff = 0;
		for(int i=1; i< Tran.length; i++)
		{
			maxDiff = -prices[0];
			for(int j=1; j< Tran[0].length; j++)
			{
				Tran[i][j] = Math.max(Tran[i][j-1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, Tran[i-1][j] - prices[j]);
			}
			
		}
		// This will print out Max profit
		System.out.println(maxDiff);
		System.out.println(Tran[k][prices.length-1]);
		PrintSolution(Tran,prices);
		return (Tran[k][prices.length-1]);
	}
	
	public static void PrintSolution(int [][] T, int[] price)
	{
		int i = T.length-1;
		int j = T[0].length-1;
		
		Deque<Integer> stack = new LinkedList<Integer>();
		
		while(true)
		{
			if(i == 0 || j == 0)
				break;
			
			if(T[i][j] == T[i][j-1])
				j = j-1;
			else
			{
				stack.push(j);
				int maxDiff = T[i][j] - price[j];
				
				for(int k= j-1; k >=0; k--)
				{
					if(T[i-1][k] - price[k] == maxDiff)
					{
						i--;
						j = k;
						stack.push(j);
						break;
					}
				}
			}
			
		}
		while(!stack.isEmpty())
		{
			System.out.println("Buy at price" + price[stack.pop()]);
			System.out.println("Sell at price" + price[stack.pop()]);
		}
	}
	
	public static int maxProfit(int[] prices) {
	    int profit = 0;
	    int minElement = Integer.MAX_VALUE;
	    for(int i=0; i<prices.length; i++){
	    
	    	profit = Math.max(profit, prices[i]-minElement);
		    minElement = Math.min(minElement, prices[i]);
	    	
	    }
	    System.out.println("minElement" + minElement);
	    return profit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] price = {2, 5, 7};
		//int [] price = {2, 4,8,10};
		//int [] price = {11,8,5,4,1};
		int [] price = {3,5,7,3,5,7,90,6,3,32,4,54,54,2,5,79};
		System.out.println(maxProfit(price));
		//maxProfit(price, 3);
	}

}
