package binarySearchTrees;

public class InsertBST {
	
	public BinarySearchTreeNode insertBSTRecursive(BinarySearchTreeNode root , int data){
		
		if(root==null){
			BinarySearchTreeNode node = new BinarySearchTreeNode(data,null,null);
			return node;
		}else {
			if(data<root.getData())
			 root.setLeftNode(insertBSTRecursive(root.getLeftNode(),data));
			else if(data>root.getData())
			 root.setRightNode(insertBSTRecursive(root.getRightNode(), data));
			else {
				return root;
			}
		}
		return root;
	}
	
	public BinarySearchTreeNode insertBSTIterative(BinarySearchTreeNode root,int data){
		
		if(root==null){
			BinarySearchTreeNode node = new BinarySearchTreeNode(data,null,null);
			return node;
		}
		
		BinarySearchTreeNode temp=root;
		BinarySearchTreeNode parent=null;
		while(temp!=null){
			parent=temp;
			if(data<temp.getData())
				temp=temp.getLeftNode();
			else if(data>temp.getData())
				temp=temp.getRightNode();
			else 
				break;
		}
		
		if(temp==null){
			BinarySearchTreeNode node = new BinarySearchTreeNode(data,null,null);
			if(data>parent.getData())
				parent.setRightNode(node);
			else
				parent.setLeftNode(node);
		}
		
		return root;
		
	}

	public static void main(String[] args) {
		InsertBST iBST = new InsertBST();
		BinarySearchTreeNode root = iBST.insertBSTRecursive(BinarySearchTreeNode.createBinarySearchTree2(), 1);
		BinarySearchTreeNode root2 = iBST.insertBSTIterative(BinarySearchTreeNode.createBinarySearchTree2(), 1);
		System.out.println(root+""+root2);
	}

}
