
class Node
{
		int data;
		Node next;
}
	

public class LinkList {	

	
	public static void main(String[] args) {
	
		Node head = new Node();
		head.data = 1;
		head.next = null;
		
		/*
		Node first = new Node();
		first.data = 2;
		first.next = null;
		
		head.next = first;
		
		
		Node second = new Node();
		second.data = 3;
		second.next = null;
		
		first.next = second;
		*/
		
		insert(head,2);
		insert(head, 3);
		insert(head,4);
		insert(head,5);
		
		print(head);
		
	}
	
	public static void insert(Node head, int value)
	{
		while(head.next != null)
		{
			head = head.next;			
		}
		
		Node last = new Node();
		last.data = value;
		last.next = null;
		
		head.next = last;
		
	}
	
	public static void print(Node head)
	{
		while(head != null)
		{
			System.out.println(head.data + " ");
			head = head.next;
		}
	}
	
	
	public static Node ReverseLinkedList(Node head)
	{
		if(head==null)
			return head;
		if(head.next == null)
			return head;
		Node prev = null;
		Node temp;
		while(head!=null)
		{
			temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		
		return prev;
	}

	
}