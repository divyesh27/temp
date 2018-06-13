
public class MergeTwoSortedLinkedList {

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
	
	public static Node MergeTwoLists(Node head1, Node head2)
	{
		if(head1 == null && head2 == null)
			return null;
		
		Node h1 = head1;
		Node h2 = head2;
		Node fakeNode = new Node(0);
		Node ptr = fakeNode;
		
		while(h1!= null && h2!= null)
		{
			if(h1.data <= h2.data)
			{
				ptr.next = h1;
				h1 = h1.next;
			}
			else
			{
				ptr.next = h2;
				h2 = h2.next;
			}
			ptr = ptr.next;
		}
		if(h1 != null)
			ptr.next = h1;
		if(h2 != null)
			ptr.next = h2;
		
		return fakeNode.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node h1 = new Node(4);
		h1.next = new Node(6);
		h1.next.next = new Node(7);
		h1.next.next.next = new Node(10);
		
		Node h2 = new Node(3);
		h2.next = new Node(5);
		h2.next.next = new Node(9);
		h2.next.next.next = new Node(11);
		
		Node res;
		res = MergeTwoLists(h1,h2);
		while(res != null)
		{
			System.out.println(res.data);
			res = res.next;
		}
	}

}
