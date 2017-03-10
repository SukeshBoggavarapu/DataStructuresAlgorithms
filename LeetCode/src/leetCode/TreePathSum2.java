package leetCode;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum2 {
	
	 static List<List<Integer>> fList = new ArrayList<List<Integer>>();
     static List<Integer> list = new ArrayList<Integer>();
   public static List<List<Integer>> pathSum(TreeNode root, int sum) {
  
  
       if(root ==null)
           return fList;
     pathSumList(root,sum,list);
           
     return fList;
   }
   
   public static void pathSumList(TreeNode root , int sum ,List<Integer> list){
       
       if(root==null)
           return;
       
       list.add(root.val);
       
       if(root.left==null && root.right==null ){
           if(root.val==sum)
               fList.add(new ArrayList<>(list));
       }else {
           pathSumList(root.left,sum-root.val,list);
           pathSumList(root.right,sum-root.val,list);
       }
	    
	    list.remove(list.size()-1);	
	    		
   }

		public static void main(String[] args){
	    	
	    	TreeNode root = new TreeNode(5);
	 		root.left = new TreeNode(4);
	 		root.right = new TreeNode(8);
	 		root.left.left= new TreeNode(11);
	 		root.left.right = null;
	 		root.right.left = new TreeNode(13);
	 		root.right.right = new TreeNode(4);
	 		root.left.left.left= new TreeNode(7);
	 		root.left.left.right= new TreeNode(2);
	 		root.right.right.left = new TreeNode(5);
	 		root.right.right.right = new TreeNode(1);
	    	List<List<Integer>> list = pathSum(root, 22);
	    	for(int i=0;i<list.size();i++){
	    		for(int j=0;j<list.get(i).size();j++){
	    			System.out.println(list.get(i).get(j));
	    		}
	    	}
	    	
	    	
	    	
	    }
	    

}
