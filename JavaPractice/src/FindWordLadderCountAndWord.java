import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindWordLadderCountAndWord {

	static class WordNode {
		String word;
		int steps;
	
		public WordNode(String word, int steps) {
			this.word = word;
			this.steps = steps;
		}
	}
	
	
	public static int findLengthToWordFromDictionary(String beginWord, String endWord, Set<String> wordDict) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord,1));
		
		//wordDict.add(endWord);
		
		while(!queue.isEmpty()) {
			
			WordNode top = queue.remove();
			String word = top.word;
			
			if(word.equals(endWord)) {
				return top.steps;
			}
			
			char [] arr = word.toCharArray();
			for(int i=0; i< arr.length; i++) {
				for(char c='a'; c<='z'; c++) {
					char temp = arr[i];
					if(arr[i] != c) {
						arr[i] = c;
					}
					
					String newWord = new String(arr);
					if(wordDict.contains(newWord)) {
						queue.add(new WordNode(newWord,top.steps + 1));
						wordDict.remove(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> hs = new HashSet<>();
		
		hs.add("hot");
		hs.add("dot");
		hs.add("dog");
		hs.add("lot");
		hs.add("log");
		hs.add("cog"); // if I remove "cog" it will return 0 otherwise 5
		
		/*
		hs.add("poon");
		hs.add("plee");
		hs.add("same");
		hs.add("poie");
		hs.add("plie");
		hs.add("poin");
		hs.add("plea");
		*/
		System.out.println(findLengthToWordFromDictionary("hit","cog",hs));
		//System.out.println(findLengthToWordFromDictionary("toon","plea",hs));
	}

	
}
