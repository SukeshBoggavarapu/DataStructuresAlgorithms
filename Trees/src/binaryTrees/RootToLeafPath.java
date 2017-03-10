package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RootToLeafPath {
	
	static int[] list = new int[256];
	
	public static void rootToLeafPaths(BinaryTreeNode root){
		
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		
		stk.push(root);
		BinaryTreeNode temp;
		Map<BinaryTreeNode,BinaryTreeNode> map = new HashMap<BinaryTreeNode,BinaryTreeNode>();
		map.put(root, root);
		
		while(!stk.isEmpty()){
			
			temp = stk.pop();
			
			if(temp.getLeftNode()==null && temp.getRightNode()==null){
				printPath(map,temp);
			}
			
			if(temp.getRightNode()!=null){
				stk.push(temp.getRightNode());
				map.put(temp.getRightNode(), temp);
			}
			if(temp.getLeftNode()!=null){
				stk.push(temp.getLeftNode());
				map.put(temp.getLeftNode(), temp);
			}
		}
		
	}
	
	public static void rootToLeafPathRecursive(BinaryTreeNode node ,int i){
		if(node ==null)
			return;
		list[i] = node.getData();
		i++;
		//printPathR(list,i); To Print all ancestors/paths
		if(node.getLeftNode()==null && node.getRightNode()==null){
			printPathR(list,i);
		}
		
		rootToLeafPathRecursive(node.getLeftNode(),i);
		rootToLeafPathRecursive(node.getRightNode(),i);
		
		
	}

	private static void printPathR(int[] list2,int length) {
		
		for(int i=0;i<length;i++){
			System.out.print(list2[i]);
		}
		System.out.println();
	}

	private static void printPath(Map<BinaryTreeNode,BinaryTreeNode> map, BinaryTreeNode leaf) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(leaf.getData());
	//	System.out.println(leaf.getData());
		while(map.get(leaf)!=leaf){
		//	System.out.println(map.get(leaf).getData());
			stack.push(map.get(leaf).getData());
			leaf=map.get(leaf);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		
		//RootToLeafPath.rootToLeafPaths(BinaryTreeNode.createTree2());
		RootToLeafPath.rootToLeafPathRecursive(BinaryTreeNode.createTree2(),0);
	}

}
