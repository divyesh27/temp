/***
 * This is for finding min and max value in a given binary tree
 * @author divyesh.shah
 *
 */
public class BinaryTreeFindMinAndMaxValue {

	
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
		node.left.left.left.left = new TreeNode(11);
		node.left.left.left.right = new TreeNode(15);
		node.left.left.left.left.right = new TreeNode(14);
		node.left.left.left.right.right = new TreeNode(16);
		node.left.left.left.right.right.left = new TreeNode(17);
		System.out.println(findMinValueBinaryTree(node));
		System.out.println(findMaxValueBinaryTree(node));

	}

	public static int findMinValueBinaryTree(TreeNode root) {

		if(root == null)
			return Integer.MAX_VALUE;

		int min = root.data;

		int lmin = findMinValueBinaryTree(root.left);
		int rmin = findMinValueBinaryTree(root.right);

		if(lmin < min)
			min = lmin;
		if(rmin < min)
			min = rmin;

		//System.out.println("Min " + min + " Max " + max);
		return min;
	}

	public static int findMaxValueBinaryTree(TreeNode root) {

		if(root == null)
			return Integer.MIN_VALUE;

		int max = root.data;

		int lmax = findMaxValueBinaryTree(root.left);
		int rmax = findMaxValueBinaryTree(root.right);

		if(lmax > max)
			max = lmax;
		if(rmax > max)
			max = rmax;

		//System.out.println("Min " + min + " Max " + max);
		return max;
	}
}
