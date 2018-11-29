
public class SortUsingSelectSortOriginalUnsortedLinkedList {

	public static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	
	
	public static int getLength(Node head) {
		
		int count=0;
		if(head != null) {
			Node curr = head;
			
			while(curr != null) {
				curr = curr.next;
				count++;
			}
		}
		return count;
	}
	
	public static Node sort(Node head) {
		
		if(head == null)
			return null;
		
		int len = getLength(head);
		Node n = head;
		for(int i=0; i < len-1 ; i++) {
			
			Node minpointer = n;
			Node m = n.next;
			for(int j = i+1 ; j < len; j++) {
				if(m.data < minpointer.data) {
					minpointer = m;
				}
				m = m.next;	
			}
			int temp = minpointer.data;
			minpointer.data = n.data;
			n.data = temp;
			n = n.next;
		}
		return head;
	}
	
	public static void print(Node head)
	{
		while(head != null)
		{
			System.out.println(head.data + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node h1 = new Node(6);
		h1.next = new Node(4);
		h1.next.next = new Node(7);
		h1.next.next.next = new Node(10);
		h1.next.next.next.next = new Node(3);
		h1.next.next.next.next.next = new Node(5);
		h1.next.next.next.next.next.next = new Node(9);
		h1.next.next.next.next.next.next.next = new Node(11);
		h1.next.next.next.next.next.next.next.next = new Node(1);
		
		System.out.println("Before Sorting list");
		print(h1);
		Node h2 = sort(h1);
		System.out.println("After Sorting list");
		print(h2);
		
	}

}
