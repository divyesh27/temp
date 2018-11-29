
public class FindMissingAndRepeatNumFrom1ToN {
	
	class Pair {
		int repeat;
		int missing;
		public String toString() {
			return repeat + " " + missing; 
		}
	}
	
	public Pair findNumbers(int[] input) {
		Pair p = new Pair();
		
		for(int i=0; i< input.length; i++) {
			if(input[Math.abs(input[i])-1] < 0) {
				p.repeat = Math.abs(input[i]);
			}
			else {
				input[Math.abs(input[i])-1] = -input[Math.abs(input[i])-1];
			}
		}
		
		for(int i=0; i < input.length; i++) {
			if(input[i] < 0) {
				input[i] = -input[i];
			}
			else {
				p.missing = i + 1;
			}
		}
			
		return p;
	} 
	
	static int findMissingNumber(int[] input) {
		
		int count=0;
		int sum=0;
		int i;
		for(i=1; i<=input.length; i++) {
			count+=i;
			sum+=input[i-1];
		}
		count+=i;
		System.out.println(count);
		return (count-sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int input[] = {1,7,10,13,16,19,22};
		FindMissingAndRepeatNumFrom1ToN fm = new FindMissingAndRepeatNumFrom1ToN();
		int input[] = {5,6,8,7,4,2,9,2,1};
		int i[] = {2,5,7,9,6,1,4,3};
		System.out.println(fm.findNumbers(input));
		System.out.println(findMissingNumber(i));
        
	}
		

}
