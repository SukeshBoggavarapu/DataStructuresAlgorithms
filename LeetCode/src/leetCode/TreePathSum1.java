package leetCode;

import java.util.Stack;

public class TreePathSum1 {
	
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root ==null)
            return false;
        
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        TreeNode prev = null;
        int total=0;
        while(!stack.isEmpty()){
            
            TreeNode cur = stack.peek();
            
            if(prev==null || prev.left == cur || prev.right ==cur ){
                
                if(cur.left!=null)
                    stack.push(cur.left);
                else if(cur.right!=null)
                    stack.push(cur.right);
                total= total + cur.val;
                
                if(cur.left==null && cur.right==null){
                    if(total==sum)
                        return true;
                }
                
            }else if (cur.left==prev){
                if(cur.right!=null){
                    stack.push(cur.right);
                }
            }else {
                
                total= total - stack.pop().val;
                
                
            }
            
            prev=cur;
            
            
            
        }
        
      return false;  
    }

}
