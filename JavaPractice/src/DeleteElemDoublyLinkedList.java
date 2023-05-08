class DoubleNode
{
	int data;
	DoubleNode prev;
	DoubleNode next;
	DoubleNode(int d)
	{
		data = d;
		prev = null;
		next = null;
	}
	
}


public class DeleteElemDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoubleNode root;
		root = InsertDoubleList(null,5);
		root = InsertDoubleList(root,10);
		root = InsertDoubleList(root,1);
		root = InsertDoubleList(root,11);
		root = InsertDoubleList(root,13);
		root = InsertDoubleList(root,3);
		root = InsertDoubleList(root,7);
		System.out.println(root.data);
		print(root);
		
	}
	
	public static void print(DoubleNode head)
	{
		while(head != null)
		{
			System.out.println(head.data + " ");
			head = head.next;
		}
	}
	private static DoubleNode InsertDoubleList(DoubleNode head, int data)
	{
		if(head == null)
		{
			head = new DoubleNode(data);
			return head;
		}
		
		if(head.next == null)
		{
			DoubleNode temp = new DoubleNode(data);
			head.next = temp;
			temp.prev = head;
			return head;
		}
		
		DoubleNode current = head;
		DoubleNode prev = head;
		
		while(current.next != null)
		{
			if(data > current.data)
			{
				prev = current;
				current = current.next;
			}
			else
			{
				DoubleNode temp = new DoubleNode(data);
				if(head == prev)
				{
					//temp.next = prev.next;
					temp.next = current;
					current.prev = temp;
					temp.prev = prev;
					head = temp;
				}
				else
				{
					prev.next = temp;
					temp.prev = prev;
					temp.next = current;
					current.prev = temp;
				}
				
			}
			if(current.next == null)
			{
				DoubleNode temp = new DoubleNode(data);
				current.next = temp;
				temp.prev = current;
				
			}
			
		}
		return head;
		
			
	}

}
