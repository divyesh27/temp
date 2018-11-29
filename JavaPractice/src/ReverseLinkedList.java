
public class ReverseLinkedList {

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
	
	Node ReverseList(Node node)
	{
		Node prev = null;
		Node current = node;
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
		ReverseLinkedList rl = new ReverseLinkedList();
		head = new Node(55);
		head.next = new Node(44);
		head.next.next = new Node(23);
		head.next.next.next = new Node(21);
		
		System.out.println("Original Linked list is :");
        rl.printlist(head);
       // head = rl.reverse(head);
        head = rl.ReverseList(head);
        System.out.println("");
        System.out.println("Reversed linked list : ");
        rl.printlist(head);
	}

}
