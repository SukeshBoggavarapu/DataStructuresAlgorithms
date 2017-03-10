package binarySearchTrees;

public class DeleteBST {
	
	public static BinarySearchTreeNode deleteBST(BinarySearchTreeNode root ,int data){
		if(root==null)
			return null;
		if(data<root.getData())
			root.setLeftNode(deleteBST(root.getLeftNode(),data));
		else if (data>root.getData())
			root.setRightNode(deleteBST(root.getRightNode(),data));
		else {
			if(root.getLeftNode()!=null && root.getRightNode()!=null){
			BinarySearchTreeNode maxNode = findMax(root.getLeftNode());
			root.setData(maxNode.getData());
			root.setLeftNode(deleteBST(root.getLeftNode(),root.getData()));
			}
			else if(root.getLeftNode()==null || root.getRightNode()==null){
				root = root.getLeftNode() != null ? root.getLeftNode() : root.getRightNode();
			}
		}
		return root;
	}
	
	public static BinarySearchTreeNode deleteBSTIterative(BinarySearchTreeNode root,int data){
		
		if(root==null)
			return null;
		
		BinarySearchTreeNode temp =root;
		BinarySearchTreeNode parent =null;
		boolean isRight = false;
		
		while(temp!=null){	
			
			if(data<temp.getData()){
				parent =temp;
				temp=temp.getLeftNode();
				isRight=false;
			}
			else if(data>temp.getData()){
				parent =temp;
				temp =temp.getRightNode();
				isRight=true;
			}
			
			if(data==temp.getData()){
				if(temp.getLeftNode()!=null && temp.getRightNode()!=null){
					BinarySearchTreeNode maxNode = findMax(temp.getLeftNode());
					temp.setData(maxNode.getData());
					parent=temp;
					temp=temp.getLeftNode();
					data=maxNode.getData();
				}else if(temp.getLeftNode()==null|| temp.getRightNode()==null){
					if(isRight)
						parent.setRightNode(temp.getLeftNode()!=null ? temp.getLeftNode() :temp.getRightNode());
					else
						parent.setLeftNode(temp.getLeftNode()!=null ? temp.getLeftNode() :temp.getRightNode());
					break;
				}
			}	
			
			
		}
		return root;
	}

	private static BinarySearchTreeNode findMax(BinarySearchTreeNode node) {
		
		if(node == null)
			return null;
		while(node.getRightNode()!=null)
			node = node.getRightNode();	
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = deleteBST(BinarySearchTreeNode.createBinarySearchTree2(),10);
		BinarySearchTreeNode root2 = deleteBSTIterative(BinarySearchTreeNode.createBinarySearchTree(),3);
		System.out.println(root+""+root2);
	}

}
