
public class ReverseLinkedListValueInteger {

	static int sum=0;
	static String sb = "";
	static Node head;
	static class Node
	{
		int data;
		Node next;
		
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	static void reverseValuetoString(Node node) {
		if(node == null)
			return;
		reverseValuetoString(node.next);
		appendString(node.data);
	}
	
	static String appendString(int data) {
		return sb+=data;
		
	}
	static void reverseValues(Node node) {
		if(node == null)
			return;
		reverseValues(node.next);
		computeValues(node.data);
	}
	
	static void computeValues(int val) {
		sum = (sum*100) + val;
	}
	Node ReverseList(Node node)
	{
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
    void printlist(Node node)
	{
		while(node != null)
		{
			System.out.println(node.data + " ");
			node = node.next;
		}
		
	}
    public Node reverse(Node node)
    {
        if(node == null || node.next == null)
            return node;
        
        Node current = node.next;
        node.next = null;
        Node head = reverse(current);
        current.next = node; 
        
        return head; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedListValueInteger rl = new ReverseLinkedListValueInteger();
		head = new Node(53);
		head.next = new Node(41);
		head.next.next = new Node(23);
		head.next.next.next = new Node(21);
		reverseValuetoString(head);
		System.out.println(sb);
		int n = Integer.parseInt(sb);
		System.out.println(n);
		/*
		System.out.println("Original Linked list is :");
        rl.printlist(head);
        head = rl.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list : ");
        rl.printlist(head);
        */
	}

}
