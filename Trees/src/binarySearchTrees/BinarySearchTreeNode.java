package binarySearchTrees;

public class BinarySearchTreeNode {

	 public BinarySearchTreeNode leftNode;
	 public BinarySearchTreeNode rightNode;
	 public int data;
	 public int size;
	 
	 public BinarySearchTreeNode(int data, BinarySearchTreeNode leftNode , BinarySearchTreeNode rightNode){
		 
		 this.data=data;
		 this.leftNode=leftNode;
		 this.rightNode=rightNode;
	 }
	 
    public BinarySearchTreeNode(int data){
		 
		 this.data=data;
	 }

	public BinarySearchTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinarySearchTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinarySearchTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinarySearchTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public static BinarySearchTreeNode createBinarySearchTree(){
		
		BinarySearchTreeNode root = new BinarySearchTreeNode(18,null,null);
		root.setLeftNode(new BinarySearchTreeNode(7,null,null));
		root.getLeftNode().setLeftNode(new BinarySearchTreeNode(3,null,null));
		root.getLeftNode().getLeftNode().setLeftNode(new BinarySearchTreeNode(1,null,null));
		root.getLeftNode().getLeftNode().setRightNode(new BinarySearchTreeNode(4,null,null));
		root.getLeftNode().setRightNode(new BinarySearchTreeNode(10,null,null));
		root.getLeftNode().getRightNode().setLeftNode(new BinarySearchTreeNode(8,null,null));
		root.getLeftNode().getRightNode().setRightNode(new BinarySearchTreeNode(11,null,null));
		root.setRightNode(new BinarySearchTreeNode(29,null,null));
		root.getRightNode().setLeftNode(new BinarySearchTreeNode(20,null,null));
		root.getRightNode().getLeftNode().setLeftNode(new BinarySearchTreeNode(19,null,null));
		root.getRightNode().getLeftNode().setRightNode(new BinarySearchTreeNode(25,null,null));
		root.getRightNode().setRightNode(new BinarySearchTreeNode(31,null,null));
		root.getRightNode().getRightNode().setLeftNode(new BinarySearchTreeNode(30,null,null));
		root.getRightNode().getRightNode().setRightNode(new BinarySearchTreeNode(42,null,null));
		return root;
	}
	
	public static BinarySearchTreeNode createBinarySearchTree2(){
		
		BinarySearchTreeNode root = new BinarySearchTreeNode(18,null,null);
		root.setLeftNode(new BinarySearchTreeNode(7,null,null));
		root.getLeftNode().setLeftNode(new BinarySearchTreeNode(3,null,null));
		root.getLeftNode().getLeftNode().setRightNode(new BinarySearchTreeNode(4,null,null));
		root.getLeftNode().setRightNode(new BinarySearchTreeNode(10,null,null));
		root.getLeftNode().getRightNode().setLeftNode(new BinarySearchTreeNode(8,null,null));
		root.setRightNode(new BinarySearchTreeNode(29,null,null));
		root.getRightNode().setLeftNode(new BinarySearchTreeNode(20,null,null));
		root.getRightNode().getLeftNode().setLeftNode(new BinarySearchTreeNode(19,null,null));
		root.getRightNode().getLeftNode().setRightNode(new BinarySearchTreeNode(25,null,null));
		return root;
	}
	
}
