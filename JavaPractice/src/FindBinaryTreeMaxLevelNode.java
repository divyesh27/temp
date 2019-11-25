
public class FindBinaryTreeMaxLevelNode {

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
	
	public int FindMaxLevelNode(TreeNode root)
	{
		if(root == null)
			return -1;
		else
			return 1 + Math.max(FindMaxLevelNode(root.left), FindMaxLevelNode(root.right));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FindBinaryTreeMaxLevelNode bt = new FindBinaryTreeMaxLevelNode();
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
		node.right.right.right.right = bt.new TreeNode(150);
		System.out.println(bt.FindMaxLevelNode(node));
	}

}
