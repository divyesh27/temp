
public class BinaryTreeTraversePreOrder {

	static class Node{
		int data;
		Node left;
		Node right;

		public Node(int data)
		{
			this.data = data;
			left = null;
			right = null;
		}
	}

	public Node root;

	public BinaryTreeTraversePreOrder()
	{
		this.root = null;
	}
	
	public boolean find(int id)
	{
		Node current = root;
		while(current!=null)
		{
			if(current.data == id)
				return true;
			else if(current.data < id)
				current = current.right;
			else
				current = current.left;
		}
		return false;
	}
	
	public boolean delete(int id)
	{
		if(root == null)
			return false;
		
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data != id)
		{
			parent = current;
			if(current.data > id)
			{
				current = current.left;
				isLeftChild = true;
			}
			else
			{
				current = current.right;
				isLeftChild = false;
			}
			if(current == null)
				return false;
		}
		
		if(current.left == null && current.right == null)
		{
			if(current == root)
				root = null;
			if(isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		
		else if(current.right == null)
		{
			if(current == root)
				root = current.left;
			else if(isLeftChild)
				parent.left = current.left;
			else
				parent.right = current.left;
				
		}
		else if(current.left == null)
		{
			if(current == root)
				root = current.right;
			else if(isLeftChild)
				parent.left = current.right;
			else
				parent.right = current.right;
		}
		else if(current.left != null && current.right != null)
		{
			Node successor = getSuccessor(current);
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;
			successor.left = current.left;
		}
		return true;
	}
	public void insert(int id)
	{
		if(find(id))
			return;
		Node newNode  = new Node(id);
		if(root == null)
		{
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = root;
		while(true)
		{
			parent = current;
			if(id < current.data)
			{
				current = current.left;
				if(current == null)
				{
					parent.left = newNode;
					return;
				}	
			}	
			else
			{
				current = current.right;
				if(current == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
		
			
	}
	public Node getSuccessor(Node curr)
	{
		Node successor = null;
		Node parentsuccessor = null;
		Node current = curr.right;
		while(current != null)
		{
			parentsuccessor = successor;
			successor = current;
			current = current.left;
		}
		if(successor != curr.right)
		{
			parentsuccessor.left = successor.right;
			successor.right = curr.right;
		}
		return successor;
	}

	/**
	 * Pre Order or Pre-Order or preorder binary tree traversal with space complexity O(1)
	 * Big O notation 1 with out using stack
	 */
	public void preOrderTraverse(Node root) {
		if (root == null)
			return;

		Node current = root;
		while (current != null) {
			// If the current node has no left child
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				// Find the inorder predecessor of the current node
				Node predecessor = current.left;
				while (predecessor.right != null && predecessor.right != current)
					predecessor = predecessor.right;

				// If the predecessor's right child is null, establish the link
				if (predecessor.right == null) {
					System.out.print(current.data + " ");
					predecessor.right = current;
					current = current.left;
				} else {
					// Restore the predecessor's right child and move to the right subtree
					predecessor.right = null;
					current = current.right;
				}
			}
		}
	}

	public void preOrderTraverseRecursion(Node root) {
		if(root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
	public void display(Node root)
	{
		if(root != null)
		{
			display(root.left);
			System.out.println("Number " + root.data);
			display(root.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeTraversePreOrder b = new BinaryTreeTraversePreOrder();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Pre-order Traversal with Iteration Space complexity 1");
		b.preOrderTraverse(b.root);
		System.out.println("");
		System.out.println("Pre-order Traversal with recursion Space complexity H or N");
		b.preOrderTraverseRecursion(b.root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(b.root);

	}

}
