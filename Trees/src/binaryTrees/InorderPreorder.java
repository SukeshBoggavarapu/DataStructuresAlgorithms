package binaryTrees;

public class InorderPreorder {
	
	static int preIndex=0;

	public static BinaryTreeNode buildTree(int[] inOrder,int[] preOrder){
		
		if(preOrder.length==0 || preOrder.length!=inOrder.length)
			return null;
		
		return buildTreeInPrOrders(preOrder,inOrder,0,inOrder.length-1);
	}

	

	private static BinaryTreeNode buildTreeInPrOrders(int[] preOrder, int[] inOrder, int inStart, int inEnd) 
	{
		if(inStart>inEnd)
			return null;
		int nodeVal = preOrder[preIndex++];
		BinaryTreeNode root = new BinaryTreeNode(nodeVal,null,null);
		int offset=inStart;
		for(;offset<inEnd;offset++){
			if(inOrder[offset]==nodeVal)
				break;
		}
		
		root.setLeftNode(buildTreeInPrOrders(preOrder,inOrder,inStart,offset-1));
		root.setRightNode(buildTreeInPrOrders(preOrder,inOrder,offset+1,inEnd));
		return root;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = new int[]{1,2,4,5,3,6};
		int[] inOrder = new int[]{4,2,5,1,6,3};
		BinaryTreeNode root = buildTree(inOrder, preOrder);
		System.out.println(root);
	}

}
