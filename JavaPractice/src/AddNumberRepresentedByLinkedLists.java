
public class AddNumberRepresentedByLinkedLists {

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	
	public Node AddNumList(Node l1, Node l2) {
		
		if(l1 == null || l2 == null)
			return null;
		
		Node l1rev = reverseList(l1);
		Node l2rev = reverseList(l2);
		int sum=0;
		int carry = 0;
		
		Node result = null;
		//Node head = result;
		while(l1rev != null && l2rev != null) {
			
			sum = l1rev.data + l2rev.data + carry;
			carry = sum / 10;
			sum = sum % 10;
			Node temp = new Node(sum);
			temp.next = result;
			result = temp;
			//result.next = new Node(sum);  // this is for the values last first
			//result = result.next;   // this is for the values last first
			l1rev = l1rev.next;
			l2rev = l2rev.next;
		}
		if(carry > 0 && l1 != null) {
            Node temp = new Node(carry+l1rev.data);
            temp.next = result;
            result = temp;
            l1rev = l1rev.next;
			//result.next = new Node(carry);  // This is to store values last first
		}
		while(l1rev != null) {
            Node temp = new Node(l1rev.data);
            temp.next = result;
            result = temp;
            l1rev = l1rev.next;
        }
		return result;
		//result.next.next = null; // this is to store values last first
		//return head.next;  // send back the value last first.
	}
	
	public static Node reverseList(Node l1) {
		
		if(l1 == null || l1.next == null )
			return l1;
		Node current = l1.next;
		l1.next = null;
		Node head = reverseList(current);
		current.next = l1;
		return head;
	}
	// Below solution is not completely correct it is off with one digit at end
	public Node AddNumListSameSize(Node l1, Node l2, int carry) {
		// public static int carry = 0;
		if (l1 == null)
			return null;

		int sum;
		Node res = new Node(0); // dummy list
		res.next = AddNumListSameSize(l1.next, l2.next, carry);

		sum = l1.data + l2.data + carry;
		carry = sum / 10;
		sum = sum % 10;
		res.data = sum;

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddNumberRepresentedByLinkedLists ab = new AddNumberRepresentedByLinkedLists();
		Node l1 = ab.new Node(7);
		l1.next = ab.new Node(4);
		l1.next.next = ab.new Node(7);
		
		Node l2 = ab.new Node(8);
		l2.next = ab.new Node(6);
		l2.next.next = ab.new Node(4);
		
		/*
		Node l1 = ab.new Node(5);
		l1.next = ab.new Node(3);
		l1.next.next = ab.new Node(1);
		
		Node l2 = ab.new Node(2);
		l2.next = ab.new Node(2);
		l2.next.next = ab.new Node(3);
		
		Node sum = ab.AddNumListSameSize(l1, l2, 0);
		while(sum!=null) {
			System.out.println(sum.data);
			sum = sum.next;
		}
		*/
		Node sum1 = ab.AddNumList(l1, l2);
		while(sum1 !=null) {
			System.out.println(sum1.data);
			sum1 = sum1.next;
		}

	}
}
