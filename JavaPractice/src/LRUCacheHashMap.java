import java.util.HashMap;
import java.util.Map;

public class LRUCacheHashMap {
	
	
	// Refer https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
	// https://leetcode.com/problems/lru-cache/
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
	Map<Integer, ListNode> map;
	
	public LRUCacheHashMap(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, ListNode>(capacity);
	}
	
	public void put(int key, int value) {
		
		if(map.containsKey(key)) {
			ListNode node = map.get(key);
			node.value = value;
			
			removeNode(node);
			addNode(node);
		}
		else {
			if(map.size() >= capacity) {
				map.remove(head.key);
				removeNode(head);
			}
			
			ListNode node = new ListNode(key,value);
			addNode(node);
			map.put(key,node);
		}
	}
	
	public int get(int key) {
		if(map.get(key)==null)
			return -1;
		
		ListNode node = map.get(key);
		
		removeNode(node);
		addNode(node);
		
		return node.value;
	}
	
	
	public void addNode(ListNode node) {
		//Add Node at the end / tail 
		if(tail!=null) {
			tail.next = node;
		}
		node.prev = tail;
		node.next = null;
		tail = node;
		
		// If there are only no node.. head and tail is the same
		if(head == null) {
			head = tail;
		}
	}
	
	public void removeNode(ListNode node) {
		// Remove node in between if the value is found otherwise remove it from end.
		if(node.prev!=null) {
			node.prev.next = node.next;
		}
		else {
			head = node.next;
		}
		
		if(node.next!=null) {
			node.next.prev = node.prev;
		}
		else {
			tail = node.prev;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 2;
		LRUCacheHashMap lru = new LRUCacheHashMap(capacity);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.get(1);
		lru.put(3, 3);
		lru.get(2);
		lru.put(4, 4);
		lru.get(1);
		lru.get(3);
		lru.get(4);
		
	}

}
