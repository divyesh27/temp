import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFindPathToSum {

	class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int d)
		{
			data = d;
			left = null;
			right = null;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeFindPathToSum bt = new BinaryTreeFindPathToSum();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<>();
		/*
		TreeNode node = bt.new TreeNode(35);
		node.right = bt.new TreeNode(50);
		node.left = bt.new TreeNode(25);
		node.right.left = bt.new TreeNode(45);
		node.left.right = bt.new TreeNode(30);
		node.left.left = bt.new TreeNode(15);
		node.right.right = bt.new TreeNode(65);
		node.right.right.right = bt.new TreeNode(-100);
		node.left.left.left = bt.new TreeNode(10);
		node.right.left.left = bt.new TreeNode(50);
		*/
		TreeNode node = bt.new TreeNode(5);
		node.right = bt.new TreeNode(8);
		node.left = bt.new TreeNode(4);
		node.right.left = bt.new TreeNode(13);
		node.left.left = bt.new TreeNode(11);
		node.left.left.right = bt.new TreeNode(2);
		node.right.right = bt.new TreeNode(4);
		node.right.right.right = bt.new TreeNode(1);
		node.left.left.left = bt.new TreeNode(7);
		node.right.right.left = bt.new TreeNode(5);
		
		bt.pathSumCount(node,22,result,currentPath);
		System.out.println(result);
		
		
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) 
			return false;
		if(root.left == null && root.right == null && sum-root.data ==0)
			return true;
		return hasPathSum(root.left, sum-root.data) || hasPathSum(root.right, sum-root.data);
	}
	
	// Find number of path which matches sum and provide the list
	public void pathSumCount(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currentPath) {
		if(root == null)
			return;
		if(root.left == null && root.right == null) {
			if(root.data == sum) {
				currentPath.add(root.data);
				result.add(new ArrayList<>(currentPath));
				currentPath.remove(currentPath.size()-1);
			}
			return;
		}
		currentPath.add(root.data);
		pathSumCount(root.left, sum-root.data,result,currentPath);
		pathSumCount(root.right,sum-root.data,result,currentPath);
		currentPath.remove(currentPath.size()-1);
	}
}
