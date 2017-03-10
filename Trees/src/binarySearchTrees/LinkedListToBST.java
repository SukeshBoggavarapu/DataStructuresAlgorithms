package binarySearchTrees;


public class LinkedListToBST {
	
	
	public BinarySearchTreeNode lLtoBST(ListNode root , int start , int end){
		
		if(start>end)
			return null;
		
		int mid = start + (end-start)/2;
		
		BinarySearchTreeNode left = lLtoBST(root, start, mid-1);
		BinarySearchTreeNode rootNode = new BinarySearchTreeNode(root.val);
		rootNode.leftNode = left;
		if(root.next!=null){
			root.val = root.next.val;
			root.next = root.next.next;
		}
		
		rootNode.rightNode = lLtoBST(root, mid+1, end);
		return rootNode;
	}
	
	
	public static void main(String[] args){
		
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next =new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next.next = new ListNode(7);
		root.next.next.next.next.next.next.next =new ListNode(8);
		
		LinkedListToBST lloBST = new LinkedListToBST();
		BinarySearchTreeNode node = lloBST.lLtoBST(root,0,7);
		System.out.println();
		
	}

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
