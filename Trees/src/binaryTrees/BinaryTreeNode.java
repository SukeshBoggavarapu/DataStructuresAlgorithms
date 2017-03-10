package binaryTrees;

public class BinaryTreeNode {
	
	public int data;
	public BinaryTreeNode leftNode;
	public BinaryTreeNode rightNode;
	public BinaryTreeNode parent;
	public int size;
	
	public BinaryTreeNode(int data,BinaryTreeNode leftNode,BinaryTreeNode rightNode){
		
		this.data=data;
		this.leftNode=leftNode;
		this.rightNode=rightNode;		
	}
	
	public BinaryTreeNode(int data){
		
		this.data=data;		
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data=data;
	}
	
	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public static BinaryTreeNode createTree(){
		
		BinaryTreeNode rootNode = new BinaryTreeNode(10,null,null);
		
		//LeftSubTree
		
		BinaryTreeNode leftSubTreeRoot1= new BinaryTreeNode(2,null,null);
		BinaryTreeNode leftLeafLeft = new BinaryTreeNode(8,null,null);
		leftSubTreeRoot1.setLeftNode(leftLeafLeft);
		BinaryTreeNode rightLeafLeft = new BinaryTreeNode(15,null,null);
		leftSubTreeRoot1.setRightNode(rightLeafLeft);
		
		//RightSubTree
		
		BinaryTreeNode rightSubTreeRoot1= new BinaryTreeNode(3,null,null);
		BinaryTreeNode leftLeafRight = new BinaryTreeNode(6,null,null);
		rightSubTreeRoot1.setLeftNode(leftLeafRight);
		BinaryTreeNode rightLeafRight = new BinaryTreeNode(7,null,null);
		rightSubTreeRoot1.setRightNode(rightLeafRight);
		
		rootNode.setLeftNode(leftSubTreeRoot1);
		rootNode.setRightNode(rightSubTreeRoot1);
		
		return rootNode;
	}
	
	public static BinaryTreeNode createTree2(){
		
		BinaryTreeNode rootNode = new BinaryTreeNode(10,null,null);
		
		//LeftSubTree
		
		BinaryTreeNode leftSubTreeRoot1= new BinaryTreeNode(2,null,null);
		BinaryTreeNode leftLeafLeft = new BinaryTreeNode(8,null,null);
		leftSubTreeRoot1.setLeftNode(leftLeafLeft);
		
		BinaryTreeNode leftLeafLeftL = new BinaryTreeNode(1,null,null);
		leftLeafLeft.setLeftNode(leftLeafLeftL);
		BinaryTreeNode leftLeafLeftR = new BinaryTreeNode(13,null,null);
		leftLeafLeft.setRightNode(leftLeafLeftR);
		
		BinaryTreeNode rightLeafLeft = new BinaryTreeNode(15,null,null);
		leftSubTreeRoot1.setRightNode(rightLeafLeft);
		
		BinaryTreeNode rightLeafLeftL = new BinaryTreeNode(46,null,null);
		rightLeafLeft.setRightNode(rightLeafLeftL);
		
		//RightSubTree
		
		BinaryTreeNode rightSubTreeRoot1= new BinaryTreeNode(3,null,null);
		BinaryTreeNode leftLeafRight = new BinaryTreeNode(6,null,null);
		rightSubTreeRoot1.setLeftNode(leftLeafRight);
		BinaryTreeNode rightLeafRight = new BinaryTreeNode(7,null,null);
		rightSubTreeRoot1.setRightNode(rightLeafRight);
		
		BinaryTreeNode rightLeafRightL = new BinaryTreeNode(21,null,null);
		rightLeafRight.setRightNode(rightLeafRightL);
		
		rootNode.setLeftNode(leftSubTreeRoot1);
		rootNode.setRightNode(rightSubTreeRoot1);
		
		return rootNode;
	}
	
public static BinaryTreeNode createTree3(){
		
		BinaryTreeNode rootNode = new BinaryTreeNode(0,null,null);
		
		//LeftSubTree
		
		BinaryTreeNode leftSubTreeRoot1= new BinaryTreeNode(2,null,null);
		BinaryTreeNode leftLeafLeft = new BinaryTreeNode(1,null,null);
		leftSubTreeRoot1.setLeftNode(leftLeafLeft);
		
		BinaryTreeNode leftLeafLeftL = new BinaryTreeNode(5,null,null);
		leftLeafLeft.setLeftNode(leftLeafLeftL);
		BinaryTreeNode leftLeafLeftR = new BinaryTreeNode(1,null,null);
		leftLeafLeft.setRightNode(leftLeafLeftR);
		
		//RightSubTree
		
		BinaryTreeNode rightSubTreeRoot1= new BinaryTreeNode(4,null,null);
		BinaryTreeNode leftLeafRight = new BinaryTreeNode(3,null,null);
		rightSubTreeRoot1.setLeftNode(leftLeafRight);
		BinaryTreeNode rightLeafRight = new BinaryTreeNode(-1,null,null);
		rightSubTreeRoot1.setRightNode(rightLeafRight);
		
		BinaryTreeNode leftLeafRightR = new BinaryTreeNode(6,null,null);
		leftLeafRight.setRightNode(leftLeafRightR);
		
		BinaryTreeNode rightLeafRightL = new BinaryTreeNode(8,null,null);
		rightLeafRight.setRightNode(rightLeafRightL);
		
		rootNode.setLeftNode(leftSubTreeRoot1);
		rootNode.setRightNode(rightSubTreeRoot1);
		
		return rootNode;
	}
	
	public static void main(String[] args){
		
		BinaryTreeNode rootNode = new BinaryTreeNode(10,null,null);
		
		//LeftSubTree
		
		BinaryTreeNode leftSubTreeRoot1= new BinaryTreeNode(2,null,null);
		BinaryTreeNode leftLeafLeft = new BinaryTreeNode(8,null,null);
		leftSubTreeRoot1.setLeftNode(leftLeafLeft);
		BinaryTreeNode rightLeafLeft = new BinaryTreeNode(15,null,null);
		leftSubTreeRoot1.setRightNode(rightLeafLeft);
		
		//RightSubTree
		
		BinaryTreeNode rightSubTreeRoot1= new BinaryTreeNode(3,null,null);
		BinaryTreeNode leftLeafRight = new BinaryTreeNode(6,null,null);
		rightSubTreeRoot1.setLeftNode(leftLeafRight);
		BinaryTreeNode rightLeafRight = new BinaryTreeNode(7,null,null);
		rightSubTreeRoot1.setRightNode(rightLeafRight);
		
		rootNode.setLeftNode(leftSubTreeRoot1);
		rootNode.setRightNode(rightSubTreeRoot1);
		
		BinaryTreeNode tempNode = rootNode;
		tempNode.getLeftNode().setLeftNode(null);
		
		System.out.println(tempNode.getLeftNode().getLeftNode());
		System.out.println(rootNode.getLeftNode().getLeftNode());
		
		
	}
	
public static BinaryTreeNode createTree4(){
		
		BinaryTreeNode rootNode = new BinaryTreeNode(50,null,null);
		
		//LeftSubTree
		
		BinaryTreeNode leftSubTreeRoot1= new BinaryTreeNode(30,null,null);
		BinaryTreeNode leftLeafLeft = new BinaryTreeNode(5,null,null);
		leftSubTreeRoot1.setLeftNode(leftLeafLeft);
		BinaryTreeNode rightLeafLeft = new BinaryTreeNode(20,null,null);
		leftSubTreeRoot1.setRightNode(rightLeafLeft);
		
		//RightSubTree
		
		BinaryTreeNode rightSubTreeRoot1= new BinaryTreeNode(60,null,null);
		BinaryTreeNode leftLeafRight = new BinaryTreeNode(45,null,null);
		rightSubTreeRoot1.setLeftNode(leftLeafRight);
		BinaryTreeNode rightLeafRight = new BinaryTreeNode(70,null,null);
		rightSubTreeRoot1.setRightNode(rightLeafRight);
		
		BinaryTreeNode leftLeafRightL = new BinaryTreeNode(65,null,null);
		rightLeafRight.setLeftNode(leftLeafRightL);
		BinaryTreeNode rightLeafRightR = new BinaryTreeNode(80,null,null);
		rightLeafRight.setRightNode(rightLeafRightR);
		
		rootNode.setLeftNode(leftSubTreeRoot1);
		rootNode.setRightNode(rightSubTreeRoot1);
		
		return rootNode;
	}
	
}
