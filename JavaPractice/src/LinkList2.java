
class Node1
{
	int data;
	Node1 next;
}

public class LinkList2
{
	public static void main(String arg[])
	{
		Node1 head=new Node1();
		head.data=1;
		head.next=null;
		
		insert(head,3);
		insert(head,5);
		insert(head,6);
		insert(head,7);
		insert(head,8);
		insert(head,9);
		
		//head=reverse(head);
		print(head);
		//returnN(head,2);
		//System.out.println("Position of 4" + returnN(head,4)+ "");
		
		System.out.println("Position of 3 from last--" + returnM(head,3)+ "");
	}
	
	public static void insert(Node1 head,int val)
	{
		while(head.next!=null)
		{
			head=head.next;
		}
		Node1 last=new Node1();
		last.data=val;
		last.next=null;
		
		head.next=last;
			
	}
	
	public static void print(Node1 head)
	{
		while(head!=null)
		{
			System.out.println(head.data+"");
			head=head.next;
		}
	}
	
	public static Node1 reverse(Node1 head)
	{
		Node1 current=new Node1();
		Node1 pre=new Node1();
		Node1 next=new Node1();
		
		current=head;
		pre=null;
		while(current!=null)
		{
			next=current.next;
			current.next=pre;
			pre=current;
			current=next;
		}
		head=pre;
		return head;
		}

		
	
	public static Node1 reverse2(Node1 head)
	{
		Node1 current=new Node1();
		Node1 pre=new Node1();
		Node1 next=new Node1();
		
		current=head;
		pre=null;
		
		while(current!=null)
		{
			next=current.next;
			current.next=pre;
			pre=current;
			current=next;
		}
		
		head=pre;
		return head;
		
		
	}
	
	public static boolean isloop(Node1 head)
	{
		Node1 slow=new Node1();
		Node1 fast=new Node1();
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow)
			{
				return true;
			}	
		
		}
		return false;
	}
	
	public static int returnN(Node1 head, int loc)
	{
		int pos=0;
		while(head!=null)
		{
			if(pos==loc)
			{
				//System.out.println("pos-"+pos+"loc"+loc+"data-"+head.data);
				return head.data;
			}
			pos++;
			head=head.next;
				
			}
		return 0;
		}
	

	public static int returnM(Node1 head, int loc)
	{
		int len=0,pos=0;
	Node1 temp=new Node1();
	Node1 temp1=new Node1();
//		if(head==null)
//		{
//			return 0;
//		}
	temp1=head;
		while(temp1!=null)
		{
			temp1=temp1.next;
			len++;
		}
		temp=head;
//		for(temp=head;temp!=null;temp=temp.next)
//		{
//			System.out.println("pos"+pos);
//			if(loc==pos)
//			{
//				System.out.println("pos"+pos);
//				return temp.data;
//			}
//			pos++;
//			System.out.println("pos"+pos);
//		}
		System.out.println("len-"+len);
		int l=len-loc;
		System.out.println("l - "+l);
		for(int i=0;i<l;i++)
		{
			
		
			temp=temp.next;
			System.out.println("temp data-"+temp.data);
			
		}
		return temp.data;
		
	}
}

	
