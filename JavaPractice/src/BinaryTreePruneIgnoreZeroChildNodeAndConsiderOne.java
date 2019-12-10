
public class BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne {

	public class Node {
		int key;
		
		Node rightChild;
		Node leftChild;

		public Node(int val) {
			this.key = val;
		}
		
	}
	
	public Node pruneTreeBasedOnZeroAndOne(Node root) {
		return containsOne(root) ? root : null;
	}
	
	public static boolean containsOne(Node root) {
		
		if(root == null) return false;
		
		boolean a1 = containsOne(root.leftChild);
		boolean a2 = containsOne(root.rightChild);
		
		if(!a1) root.leftChild = null;
		if(!a2) root.rightChild = null;
		
		return root.key == 1 || a1 || a2;
	
	}
	public static void print(Node result) {
		if(result == null)
			return;
		
		print(result.leftChild);
		print(result.rightChild);
		System.out.println(result.key);
	}
	
	public static void main(String args[]) {

		BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne bt = new BinaryTreePruneIgnoreZeroChildNodeAndConsiderOne();
		Node root = bt.new Node(1);
		root.leftChild = bt.new Node(1);
		root.rightChild = bt.new Node(1);
		root.leftChild.rightChild = bt.new Node(0);
		root.rightChild.rightChild = bt.new Node(1);
		root.leftChild.leftChild = bt.new Node(1);
	
		Node result = bt.pruneTreeBasedOnZeroAndOne(root);
		
		print(result);
	}

	
}