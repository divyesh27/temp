
public class FindMthNodeFromLastNodeLinkList {
	
	Node head;
	public class Node
	{
		int data;
		Node next;
		
		public Node(int d)
		{
			this.data = d;
			this.next = null;
		}
	}
	public void push(int val)
	{
		//Adding value at front of the list
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
	}
	public void FindMthNode(int n)
	{
		if(head == null || head.next == null)
			return;
		Node firstPointer = head;
		Node secondPointer = head;
		int count=0;
		while(count < n)
		{
			if(firstPointer == null)
			{	
				System.out.println(count);
				return;
			}
			count++;
			firstPointer = firstPointer.next;
		}
		
		while(firstPointer != null)
		{
			secondPointer = secondPointer.next;
			firstPointer = firstPointer.next;
		}
		System.out.println(secondPointer.data);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMthNodeFromLastNodeLinkList fml = new FindMthNodeFromLastNodeLinkList();
		fml.push(4);
		fml.push(19);
		fml.push(77);
		fml.push(11);
		//System.out.println(fml.head.data);
		fml.FindMthNode(3);
		
		

	}
	
}
