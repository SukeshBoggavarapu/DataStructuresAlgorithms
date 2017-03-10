package leetCode;

import java.util.HashMap;
import java.util.Map;

public class TreePathSum3 {
	
	static int count =0;
    public static int pathSum(TreeNode root, int sum) {
        
    Map<Integer,Integer> prefixSum = new HashMap<Integer,Integer>();
    prefixSum.put(0,1);
    pathSumCount(root,0,sum,prefixSum);
    return count;
        
    }
    
    public static void pathSumCount(TreeNode root,int sum,int target,Map<Integer,Integer> prefixSum){
        
        if(root ==null)
            return;
        
        sum=sum+root.val;
        
        if(prefixSum.containsKey(sum-target)){
            
            count = count + prefixSum.get(sum-target);
        }
        
        if(!prefixSum.containsKey(sum)){
            prefixSum.put(sum,1);
        }else {
            prefixSum.put(sum,prefixSum.get(sum)+1);
        }
        
        pathSumCount(root.left,sum,target,prefixSum);
        pathSumCount(root.right,sum,target,prefixSum);
        
        prefixSum.put(sum,prefixSum.get(sum)-1);
        
        
        
        
    }
	    
	   public static void main(String[] args){
		   
		   TreeNode root = new TreeNode(10);
	 		root.left = new TreeNode(5);
	 		root.right = new TreeNode(-3);
	 		root.left.left= new TreeNode(3);
	 		root.left.right = new TreeNode(2);
	 		root.right.left = null;
	 		root.right.right = new TreeNode(11);
	 		root.left.left.left= new TreeNode(3);
	 		root.left.left.right= new TreeNode(-2);
	 		root.right.right.left = null;
	 		root.right.right.right = new TreeNode(1);
	 		
	 		pathSum(root,8);
	 		System.out.println(count);
	   } 

}
