package binarySearchTrees;

public class LCAOrShortestPathBetweenNodes {
	
	public static BinarySearchTreeNode shortestPath(BinarySearchTreeNode root ,int val1 ,int val2){
		
		if(root==null)
			return null;
		if(root.getData()==val1 || root.getData()==val2)
			return root;
		if((val1<root.getData() && val2>root.getData()) || (val1>root.getData() && val2<root.getData())){	
			return root;
		}else if(val1<root.getData() && val2<root.getData()){
			return shortestPath(root.getLeftNode(),val1,val2);
		}else {
			return shortestPath(root.getRightNode(),val1,val2);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(shortestPath(BinarySearchTreeNode.createBinarySearchTree(), 1, 42).getData());
		
	}

}
