package binaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversal {
	
	static int min;
	static int max;
	static int sum;
	
	public static void verticalTraversal(BinaryTreeNode root){
		
		findMinMax(root,0);
		
		for(int i=min;i<=max;i++){
			printNodes(root,i,0);
			System.out.println(sum);
			sum=0;
		}
		
	}

	private static void printNodes(BinaryTreeNode node,int dist,int rootpos) {
		if(node==null)
			return;
		
		if(dist==rootpos)
			sum=sum+node.getData();
		printNodes(node.getLeftNode(),dist,rootpos-1);
		printNodes(node.getRightNode(),dist,rootpos+1);
		
	}

	private static void findMinMax(BinaryTreeNode root,int dist) {
		
		if(root==null)
			return;
		if(dist<min)
			min=dist;
		else if(dist>max)
			max=dist;
		findMinMax(root.getLeftNode(),dist-1);
		findMinMax(root.getRightNode(),dist+1);
	}

	
	public static void verticalTraversalHashMap(BinaryTreeNode node){
		
		Map<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
		
		verTraUsingPostOrderTrav(map,node,0);
		
		for(Integer key : map.keySet()){
			for(int i=0;i<map.get(key).size();i++){
				System.out.print(map.get(key).get(i));
			}
			System.out.println();
		}
		
		
	}
	private static void verTraUsingPostOrderTrav(Map<Integer, ArrayList<Integer>> map, BinaryTreeNode node, int pos) {
		if(node==null)
			return;
		if(node.getLeftNode()!=null)
			verTraUsingPostOrderTrav(map, node.getLeftNode(), pos-1);
		if(node.getRightNode()!=null)
			verTraUsingPostOrderTrav(map, node.getRightNode(), pos+1);
		if(map.containsKey(pos))
			map.get(pos).add(node.getData());
		else
			map.put(pos, new ArrayList<Integer>(Arrays.asList(node.getData())));
	}
	

	public static void main(String[] args) {
		//verticalTraversal(BinaryTreeNode.createTree2());
		verticalTraversalHashMap(BinaryTreeNode.createTree());
	}

}
