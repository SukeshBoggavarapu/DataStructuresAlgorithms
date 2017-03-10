package leetCode;

import java.util.HashMap;
import java.util.Map;

public class DecreasingFrequencies {
	
	
	
	public static void sortNumbers(int[] nums){
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums.length;i++){
			
			if(!map.containsKey(nums[i])){
				
				map.put(nums[i], 1);
			}else {
				map.put(nums[i],map.get(nums[i])+1);
			}
		}
		int count =0;
		BSTNode root = null;
		for (Integer in : map.keySet()){
			
			if(count==0){
			
			 root = new BSTNode(in,map.get(in));
			count++;
			}else {
				BSTNode node = new BSTNode(in,map.get(in));
				buildTree(root,node);
			}
			
		}
		
		inOrderTraversal(root);		
		
	}

	private static void inOrderTraversal(BSTNode root) {
		
		if(root==null){
			return;
		}
		inOrderTraversal(root.right);
		System.out.println(root.value);
		inOrderTraversal(root.left);
		
	}

	private static BSTNode buildTree(BSTNode root, BSTNode node) {
		
		if(root==null){
			return node;
		}
		
		if(node.frequency<=root.frequency){	
			root.left = buildTree(root.left,node);
		}else if(node.frequency>root.frequency){
			root.right=buildTree(root.right,node);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] vals = new int[]{3,5,6,7,23,8,56,5,8,5,7,45,23,6,8,57,3,3,3,3};
		sortNumbers(vals);
	}

}
 class BSTNode{
	
	int value;
	int frequency;
	BSTNode left;
	BSTNode right;
	public BSTNode(int value, int frequency){
		this.value=value;
		this.frequency=frequency;
	}
}
