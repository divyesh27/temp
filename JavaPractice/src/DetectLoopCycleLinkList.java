
public class DetectLoopCycleLinkList {

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
	
	public static int DetectRemoveLoop(Node head)
	{
		Node fast = head.next;
		Node slow = head;
		while(fast != null && fast.next != null)
		{
			if(slow == fast)
			{
				System.out.println("Found loop");
				break;
			}
			slow = slow.next;
			fast = fast.next.next;	
		}
		if(slow == fast)
		{
			slow = head;
			while(slow != fast.next)
			{
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
		return 0;
	}
	
	static void printlist(Node head)
	{
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node h1 = new Node(4);
		h1.next = new Node(6);
		h1.next.next = new Node(7);
		h1.next.next.next = new Node (10);
		h1.next.next.next.next = new Node(11);
		h1.next.next.next.next.next = h1.next.next;
		DetectRemoveLoop(h1);
		printlist(h1);
		
		
	}

}
