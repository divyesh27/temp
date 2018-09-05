
public class FindSubArrayWithGivenSum {

	public class Pair {
		int start;
		int end;
		
		public String toString() {
			return start + " " + end;
		}
	}
	
	public Pair findSubArray(int [] input, int sum) {
		
		int currentsum = 0;
		Pair p = new Pair();
		p.start = 0;
		for(int i=0; i< input.length; i++) {
			currentsum += input[i];
			p.end = i;
			if(currentsum == sum)
				return p;
			else if(currentsum > sum){
				int s = p.start;
				while(currentsum > sum) {
					currentsum -= input[s];
					s ++;
				}
				p.start = s;
				if(currentsum == sum)
					return p;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSubArrayWithGivenSum findsum = new FindSubArrayWithGivenSum();
		int [] input = {6,3,9,11,1,3,5};
		System.out.print(findsum.findSubArray(input, 15));
	}

}
