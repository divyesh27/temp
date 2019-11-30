

public class FindBinaryTreeMaxLevelNodeSum {

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
	
	int[] arr = new int[1000];
	public int FindMaxLevelNodeSum(TreeNode root)
	{
		inOrder(root, 1);
		int indexMax = 0;
		for(int i=0; i<1000; i++) {
			indexMax = arr[i] > arr[indexMax] ? i : indexMax;
		}
		return indexMax;
	}
	
	public void inOrder(TreeNode root, int level) {
		
		if(root != null) {
			inOrder(root.left, level+1);
			arr[level] += root.data;
			inOrder(root.right, level+1);
			//list.add(list.get(level) + root.data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FindBinaryTreeMaxLevelNodeSum bt = new FindBinaryTreeMaxLevelNodeSum();
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
		System.out.println(bt.FindMaxLevelNodeSum(node));
	}

}
