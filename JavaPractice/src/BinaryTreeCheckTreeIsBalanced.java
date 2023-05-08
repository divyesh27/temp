import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BinaryTreeCheckTreeIsBalanced {

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
		
		TreeNode node = new TreeNode(5);
		node.right = new TreeNode(8);
		node.left = new TreeNode(4);
		node.right.left = new TreeNode(13);
		node.left.left = new TreeNode(11);
		node.left.left.right = new TreeNode(2);
		node.right.right = new TreeNode(4);
		node.right.right.right = new TreeNode(1);
		node.left.left.left = new TreeNode(7);
		node.right.right.left = new TreeNode(5);
		System.out.println(findBalanceTree(node));
	}
	
	public static int findBalanceTree(TreeNode root) {
		
		if(root == null)
			return -1;
		
		int leftheight = findBalanceTree(root.left);
		if(leftheight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rightheight = findBalanceTree(root.right);
		if(rightheight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int heightdiff = leftheight - rightheight;
		if(Math.abs(heightdiff) > 1) {
			System.out.println(heightdiff);
			return Integer.MIN_VALUE;
		}
		else
			return Math.max(leftheight, rightheight) + 1;
			
	}
	
}
