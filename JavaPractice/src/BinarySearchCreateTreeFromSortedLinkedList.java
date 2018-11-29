import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchCreateTreeFromSortedLinkedList {

	public static class LinkListNode{
		int data;
		LinkListNode next;
		
		public LinkListNode(int d) {
			this.data = d;
			this.next = null;
		}
	}
	public static class TreeNode {
		int data;
		TreeNode right;
		TreeNode left;
		
		public TreeNode(int d) {
			this.data = d;
			this.right = null;
			this.left = null;
		}
	}
	public static void main(String arg[]) {
		int[] a = { 1, 8, 4, 5, 6, 7, 16, 10, 11, 13, 15 };
		Arrays.sort(a); // input array can be a sorted array so can avoid this step.
		display(createTree(a));
		LinkListNode head = new LinkListNode(5);
		head.next = new LinkListNode(51);
		head.next.next = new LinkListNode(41);
		head.next.next.next = new LinkListNode(31);
		head.next.next.next.next = new LinkListNode(11);
		head.next.next.next.next.next = new LinkListNode(61);
		int [] result = createList(head);
		for(int i : result)
			System.out.println(i);
	}

	public static int[] createList(LinkListNode head) {
		if(head == null)
			return null;
		List<Integer> list = new ArrayList<>();
		while(head != null) {
			list.add(head.data);
			head = head.next;
		}
		Collections.sort(list);
		return list.stream().mapToInt(i -> i).toArray();
	}
	
	public static TreeNode createTree(int [] input) {
		return createTree(input, 0, input.length-1);
	}
	
	public static TreeNode createTree(int [] input, int start, int end) {
		if(end < start)
			return null;
		
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(input[mid]);
		n.left = createTree(input,start,mid-1);
		n.right = createTree(input,mid+1,end);
		return n;
		
	}
	
	public static void display(TreeNode root)
	{
		if(root != null)
		{
			display(root.left);
			System.out.println("Number " + root.data);
			display(root.right);
		}
	}
	
}
