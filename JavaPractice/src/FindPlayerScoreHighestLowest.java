import java.util.HashMap;

/**
In a given game there are 10 players(can grow more). Each individual will have there own score. What we are interested is
1) Get score of any given player
2) Get total score of all players
3) Get which player scored lowest
4) Get which player scored highest
5) Show the players scored from highest to lowest
6) Show the players scored from lowest to highest
**/
public class FindPlayerScoreHighestLowest {

	public static class Players {
		
		private String name = null;
		private int minscore = Integer.MAX_VALUE;
		private int maxscore = Integer.MIN_VALUE;
		
		public Players(String string, int i) {
			setName(string);
			setScore(string,i);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getMinscore() {
			return minscore;
		}
		public void setMinscore(int minscore) {
			this.minscore = minscore;
		}
		public int getMaxscore() {
			return maxscore;
		}
		public void setMaxscore(int maxscore) {
			this.maxscore = maxscore;
		}

		public void setScore(String name, int score) {
			
			setName(name);
			if(score < getMinscore()) {
				setMinscore(score);
			}
			if(score > getMaxscore()) {
				setMaxscore(score);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Players> hm = new HashMap<>();
		FindPlayerScoreHighestLowest.Players pl = new FindPlayerScoreHighestLowest.Players("Divyesh", 5);
		if(!hm.containsKey("Divyesh"))
			hm.put("Divyesh", pl);
		System.out.println(hm.get("Divyesh").getMaxscore());
		System.out.println(hm.get("Divyesh").getMinscore());
		
		
	}
}
