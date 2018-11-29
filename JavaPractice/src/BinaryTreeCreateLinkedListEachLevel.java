import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

	public static List<LinkedList<TreeNode>> createList(TreeNode root) {

		List<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createList(root, lists, 0);
		return lists;
	}

	public static void createList(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
		if (root == null)
			return;

		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createList(root.left, lists, level + 1);
		createList(root.right, lists, level + 1);
	}

	public static void display(List<LinkedList<TreeNode>> root) {
		if (root != null) {
			for (LinkedList<TreeNode> l : root) {
				for (TreeNode r : l) {
					System.out.print(r.data + "\t");
				}
				System.out.println();
			}
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
		List<LinkedList<TreeNode>> s = createList(node);
		display(s);
	}

}
