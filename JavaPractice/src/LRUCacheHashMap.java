import java.util.HashMap;
import java.util.Map;

public class LRUCacheHashMap {
	
	class ListNode {
		int val;
		ListNode prev, next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	int size = 0;
	int capacity;
	ListNode head, tail;
	Map<Integer, ListNode> map;
	
	public LRUCacheHashMap(int capacity) {
		head = new ListNode(-1);
		tail = new ListNode(-1);
		head.next = tail;
		tail.prev = head;
		map = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		ListNode node = map.getOrDefault(key, head);
		if(node.val != -1) {
			
		}
		return node.val;
	}
	
	public void set(int key, int val) {
		
		if(map.getOrDefault(key, head).val != -1) {
			
		}
		else {
			ListNode newNode = new ListNode(val);
			
			if(++size > capacity) {
				
			}
			map.put(key, newNode);
		}
	}
	
	private void moveToHead(ListNode node) {
		if(node == head || node.prev == head) {
			System.out.println("head: " + head.val);
			return;
		}
		removeNode(node);
		addNode(node);
	}
	
	private void addNode(ListNode newNode) {
		newNode.next = head.next;
		head.next.prev = newNode;
		head.next = newNode;
		newNode.prev = head;
	}
	
	private void removeNode(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = node.prev = null;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 2;
		LRUCacheHashMap lru = new LRUCacheHashMap(capacity);
		lru.set(2, 1);
		lru.set(1, 1);
		System.out.println(lru.get(2));
		lru.set(4, 1);
		System.out.println(lru.get(2));
		System.out.println(lru.get(1));
		
	}

}
