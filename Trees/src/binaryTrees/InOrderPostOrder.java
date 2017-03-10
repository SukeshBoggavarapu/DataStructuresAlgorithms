package binaryTrees;

public class InOrderPostOrder {
	
	static int postIndex;
	
	public BinaryTreeNode inOrderPostOrder(int[] postOrder,int[] inOrder,int inStart, int inEnd){
		
		if(inStart>inEnd)
			return null;
		int nodeVal = postOrder[postIndex--];
		BinaryTreeNode node = new BinaryTreeNode(nodeVal,null,null);
		
		int offset = inStart;
		for(;offset<inEnd;offset++){
			if(inOrder[offset] == nodeVal)
				break;
		}
		
		node.setRightNode(inOrderPostOrder(postOrder,inOrder,offset+1,inEnd));
		node.setLeftNode(inOrderPostOrder(postOrder,inOrder,inStart,offset-1));
		
		return node;
	}
	public static void main(String[] args) {
		
		int[] inOrder = new int[]{4,2,5,1,6,3};
		int[] postOrder = new int[]{4,5,2,6,3,1};
		postIndex = postOrder.length-1;
		InOrderPostOrder ipo = new InOrderPostOrder();
		BinaryTreeNode root = ipo.inOrderPostOrder(postOrder,inOrder,0,inOrder.length-1);
		System.out.println(root);
	} 

}
