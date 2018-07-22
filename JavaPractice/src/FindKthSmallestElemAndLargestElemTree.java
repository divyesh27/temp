import java.util.Stack;

public class FindKthSmallestElemAndLargestElemTree {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(40);
		root.right = new TreeNode(60);
		root.left = new TreeNode(20);
		root.right.right = new TreeNode(70);
		root.left.right = new TreeNode(30);
		root.right.left = new TreeNode(50);
		root.left.left = new TreeNode(10);
		root.right.right.left = new TreeNode(65);
		root.left.left.right = new TreeNode(15);
		System.out.println(KthSmallestElement(root, 6));
		System.out.println(KthLargestElement(root, 6));
	}

	private static int KthSmallestElement(TreeNode root, int k) {
		TreeNode p = root;
		int result = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode t = stack.pop();
				k--;
				if (k == 0)
					result = t.data;
				p = t.right;

			}
		}
		return result;
	}

	private static int KthLargestElement(TreeNode root, int k) {
		TreeNode p = root;
		int result = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.right;
			} else {
				TreeNode t = stack.pop();
				k--;
				if (k == 0)
					result = t.data;
				p = t.left;

			}
		}
		return result;
	}
}
