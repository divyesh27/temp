import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeInOrderCreateDoublyLinkedList {

	public static class Node{
		int data;
		Node right;
		Node left;
		
		public Node(int d) {
			this.data = d;
			this.right = null;
			this.left = null;
		}
	}
	
	static Node first = null;
	static Node last = null;
	/*
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
	*/
	public static void main(String arg[]) {
		
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.right = new Node(5);
		root.left.right = new Node(3);
		
		createDoublyLinkedList(root);
		while(first != last) {
			System.out.println(first.data);
			first = first.right;
		}
		System.out.println(first.data);
	}

	public static Node createDoublyLinkedList(Node root)
	{
		if(root == null)
			return null;
		
		dfsInorder(root);
		first.left = last;    // close the loop by assigning first and last
		last.right = first;
		
		return first;
	}
	
	private static void dfsInorder(Node root) {
		
		if(root != null) {
			
			dfsInorder(root.left);  // go all the dfs left node
			
			if(last != null) {      // if the last node is initialize then assign need node to last
				last.right = root;
				root.left = last;
				
			}
			else {
				first = root;    // otherwise assign first node
			}
			last = root;        // assign the new node to last
			
			dfsInorder(root.right);  // go all the way dfs to right node
		}
	}
	
}
