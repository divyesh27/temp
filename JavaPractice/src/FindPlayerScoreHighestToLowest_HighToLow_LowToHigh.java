import java.util.HashMap;

public class FindPlayerScoreHighestToLowest_HighToLow_LowToHigh {

	public static class Players {
		
		private String name = null;
		private int score = 0;
		private int minscore = Integer.MAX_VALUE;
		private int maxscore = Integer.MIN_VALUE;
		
		public Players(String name, int score) {
			setName(name);
			setScore(name, score);
		}
		public String getName() {
			return name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(String name, int score) {
			this.name = name;
			this.score = score;
			setScoreValue(name, score);
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getMinscore() {
			return minscore;
		}
		private void setMinscore(int minscore) {
			//setScoreValue(getName(),minscore);
			this.minscore = minscore;
		}
		public int getMaxscore() {
			return maxscore;
		}
		private void setMaxscore(int maxscore) {
			//setScoreValue(getName(),maxscore);
			this.maxscore = maxscore;
		}
		public void setScoreValue(String name, int score) {
			
			setName(name);
			//setScore(name,score);
			if(score < getMinscore()) {
				setMinscore(score);
			}
			if(score > getMaxscore()) {
				setMaxscore(score);
			}
		}
		public void printHighToLow() {
			
		}
		public void printLowToHigh() {
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Players> hm = new HashMap<>();
		FindPlayerScoreHighestToLowest_HighToLow_LowToHigh.Players pl = new FindPlayerScoreHighestToLowest_HighToLow_LowToHigh.Players("Divyesh", 5);
		FindPlayerScoreHighestToLowest_HighToLow_LowToHigh.Players p2 = new FindPlayerScoreHighestToLowest_HighToLow_LowToHigh.Players("Jinal", 15);
		if(!hm.containsKey("Divyesh"))
			hm.put("Divyesh", pl);
		if(!hm.containsKey("Jinal"))
			hm.put("Jinal", p2);
		System.out.println(hm.get("Divyesh").getScore());
		System.out.println(hm.get("Divyesh").getMaxscore());
		System.out.println(hm.get("Divyesh").getMinscore());
		System.out.println(hm.get("Jinal").getScore());
		System.out.println(hm.get("Jinal").getMaxscore());
		System.out.println(hm.get("Jinal").getMinscore());

		
		
		
	}
}
