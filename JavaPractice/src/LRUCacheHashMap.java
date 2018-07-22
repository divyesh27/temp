import java.util.HashMap;
import java.util.Map;

public class LRUCacheHashMap {
	
	
	// Refer https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
	class ListNode {
		int key;
		int value;
		ListNode prev, next;
		public ListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	int size = 0;
	int capacity;
	ListNode head = null;
	ListNode tail = null;
	
	HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
	
	public LRUCacheHashMap(int capacity) {
		this.capacity = capacity;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 2;
		LRUCacheHashMap lru = new LRUCacheHashMap(capacity);
		
	}

}
