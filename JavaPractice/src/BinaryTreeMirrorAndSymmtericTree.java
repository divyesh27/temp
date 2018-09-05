
public class BinaryTreeMirrorAndSymmtericTree {

	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	Node a, b, root;
	
	public boolean treeMirror(Node a, Node b) {
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		
		return a.data == b.data && treeMirror(a.left,b.right) && treeMirror(a.right,b.left);
	}
	
	public boolean treeSymmetric(Node root) {
		return treeMirror(root, root);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMirrorAndSymmtericTree tree = new BinaryTreeMirrorAndSymmtericTree();
		tree.a = tree.new Node(1);
		tree.b = tree.new Node(1);
		tree.a.left = tree.new Node(2);
		tree.a.right = tree.new Node(3);
		tree.a.left.left = tree.new Node(4);
		tree.a.left.right = tree.new Node(5);
		
		tree.b.left = tree.new Node(3);
		tree.b.right = tree.new Node(2);
		tree.b.right.left = tree.new Node(5);
		tree.b.right.right = tree.new Node(4);
		
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(2);
        tree.root.left.left = tree.new Node(3);
        tree.root.left.right = tree.new Node(4);
        tree.root.right.left = tree.new Node(4);
        tree.root.right.right = tree.new Node(3);
		
        if(tree.treeMirror(tree.a, tree.b) == true)
			System.out.println("Yes trees are mirror image");
		else
			System.out.println("No trees are not mirror image");
        
        if(tree.treeSymmetric(tree.root) == true)
        	System.out.println("Yes Subtree is a mirror image");
		else
			System.out.println("No Subree is not a mirror image");
	}

}
