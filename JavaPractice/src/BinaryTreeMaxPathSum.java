
public class BinaryTreeMaxPathSum {

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
		BinaryTreeMaxPathSum bt = new BinaryTreeMaxPathSum();
		
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
		/*
		TreeNode tree;
		tree = bt.new TreeNode(10);
        tree.left = bt.new TreeNode(2);
        tree.right = bt.new TreeNode(10);
        tree.left.left = bt.new TreeNode(20);
        tree.left.right = bt.new TreeNode(1);
        tree.right.right = bt.new TreeNode(-25);
        tree.right.right.left = bt.new TreeNode(3);
        tree.right.right.right = bt.new TreeNode(4);
        */
		System.out.println(node.data);
		System.out.println(bt.MaxPathSum(node));
	}

	private int MaxPathSum(TreeNode node)
	{
		if(node == null || (node.left == null && node.right == null))
			return -1;
		
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		
		CalculateSum(node,max);
		return max[0];
	}
	private int CalculateSum(TreeNode node, int[] max)
	{
		if(node == null)
			return 0;
		int left = CalculateSum(node.left, max);
		int right = CalculateSum(node.right, max);
		
		int current = Math.max(node.data, Math.max(node.data + left, node.data + right));
		
		max[0] = Math.max(max[0], Math.max(current,left + node.data + right));
		
		return current;
	}
}
