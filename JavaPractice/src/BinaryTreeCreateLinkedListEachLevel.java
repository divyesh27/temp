import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BinaryTreeCreateLinkedListEachLevel {

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
		
		
		
	}

	public static ArrayList<LinkedList<TreeNode>> createList(TreeNode root) {
		
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>> ();
		createList(root, lists, 0);
		return lists;
	}
	public static void createList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if(root == null)
			return;
		
		LinkedList<TreeNode> list = null;
		if(lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}
		else {
			list = lists.get(level);
		}
		list.add(root);
		createList(root.left, lists, level+1);
		createList(root.right, lists, level+1);
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
