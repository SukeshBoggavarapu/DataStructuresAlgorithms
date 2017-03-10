package leetCode;

public class DeleteNodeInBST {
	
public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null)
            return root;
        
        if(root.val==key){
            
            if(root.left ==null && root.right ==null){
                return null;
            }else if(root.left ==null || root.right ==null){
                return root.left == null ? root.right : root.left;
            }else {
                int value=findLargestVal(root.left);
                root.val =value;
                root.left =deleteNode(root.left,value);
            }
                
        }else if(root.val<key){
           root.right= deleteNode(root.right,key);
        }else if(root.val>key){
           root.left= deleteNode(root.left,key);
        }
        
        return root;
    }
    
    public static int findLargestVal (TreeNode node){
        
        if(node.right==null)
            return node.val;
        
        while(node.right!=null){
            node=node.right;
        }
        
        return node.val;
        
    }
    
 public static TreeNode deleteNodeIterative(TreeNode root, int key) {
        
        if(root==null)
            return root;
            
        TreeNode fakeNode = new TreeNode(-1);
        fakeNode.right = null;
        fakeNode.left = root;
        
        TreeNode prev =fakeNode;
        TreeNode temp = fakeNode.left;
        
        boolean isRight = false;
        
        
       while(temp!=null){
           
           if(temp.val == key){
               
               if(temp.left == null && temp.right == null){
                   
                   if(isRight){
                       prev.right=null;
                   }else {
                       prev.left=null;
                   }
                   break;
               }else if(temp.left==null || temp.right ==null) {
                   if(isRight){
                       prev.right = temp.left==null ? temp.right : temp.left;
                   }else {
                       prev.left = temp.left==null ? temp.right : temp.left;
                   }
                   break;
               }else {
                   int value = findLargestVal(temp.left);
                   temp.val = value;
                   prev=temp;
                   temp = temp.left;
                   key=value;
                   isRight =false;
               }
               
               
           }else if(temp.val<key){
               prev = temp;
               temp = temp.right;
               isRight=true;
             
               
           }else if(temp.val>key) {
               prev = temp;
               temp = temp.left;
               isRight=false;
           }
           
          
       }
        
        return fakeNode.left;
    }

 	public static void main(String[] args){
 		
 		TreeNode root = new TreeNode(5);
 		root.left = new TreeNode(3);
 		root.right = new TreeNode(6);
 		root.left.left= new TreeNode(2);
 		root.left.right = new TreeNode(4);
 		root.right.left = null;
 		root.right.right = new TreeNode(7);
 		
 		System.out.println(deleteNodeIterative(root, 3));
 		
 		
 		
 	}
}
