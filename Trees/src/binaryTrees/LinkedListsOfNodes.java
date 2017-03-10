package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListsOfNodes {
	
	public List<ListNode> linkedListOfNodes(BinaryTreeNode root){
		List<ListNode> res = new ArrayList<ListNode>();
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		queue.offer(null);
		ListNode node = new ListNode();
		ListNode p = node;
		while(!queue.isEmpty()){
			BinaryTreeNode curr = queue.poll();		
			if(curr!=null){
				p.next=new ListNode(curr.data);
				p=p.next;
			}else{
				
			}	
		}
		return null;
	}

	public static void main(String[] args) {

	}

}

class ListNode{
	
	int data;
	ListNode next;
	
	public ListNode(int data){
		
		this.data=data;
		//this.next=next;
		
	}
	
	public ListNode(){}
	
}