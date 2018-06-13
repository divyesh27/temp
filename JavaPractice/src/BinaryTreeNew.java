
public class BinaryTreeNew {
	Node root;
	
	public void addNode(int key,String name)
	{
		Node newNode=new Node(key,name);
		
		if(root==null)
		{
			root=newNode;
		}
		else
		{
			Node focusNode=root;
		
		Node parent;
		while(true)
		{
			parent=focusNode;
			if(key<focusNode.key)
			{
				
				focusNode=focusNode.leftChild;
				if(focusNode==null)
				{
					parent.leftChild=newNode;
				}
				return;
			}
			else
			{
				focusNode=focusNode.rightChild;
				if(focusNode==null)
				{
					parent.rightChild=newNode;
				}
				return;
			}
		}
		}
	}
	public static void main(String arg[])
	{
		BinaryTreeNew bt=new BinaryTreeNew();
		bt.addNode(50, "Boss");
			 
		        bt.addNode(25, "Vice President");
			 
			        bt.addNode(15, "Office Manager");
		 
			        bt.addNode(30, "Secretary");
			 
			        bt.addNode(75, "Sales Manager");
		 
		        bt.addNode(85, "Salesman 1");
		        String s=bt.toString();
		        System.out.println(s);
		        bt.inOrderTraverseTree(bt.root);
		       
		       
		}
	
	public void inOrderTraverseTree(Node focusNode)
	{
		if(focusNode!=null)
		inOrderTraverseTree(focusNode.leftChild);
		System.out.println(focusNode);
		inOrderTraverseTree(focusNode.rightChild);
	}
public class Node
{
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	public Node(int key,String name)
	{
		this.key=key;
		this.name=name;
	}
	


public String toString()
{
	return name+"has value as -"+key;
}
}
}
