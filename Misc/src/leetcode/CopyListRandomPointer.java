package leetcode;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class CopyListRandomPointer {
	
	Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
	
	public RandomListNode copyListMap(RandomListNode head){
		
		RandomListNode temp =head;
		
		while(temp!=null){
			map.put(temp, new RandomListNode(temp.label));
			temp=temp.next;
		}
		
		temp=head;
		while(temp!=null){
			map.get(temp).next=map.get(temp.next);
			map.get(temp).random=map.get(temp.random);
			temp=temp.next;
		}
		
		return map.get(head);
		
	}
	
	public RandomListNode copyList(RandomListNode head){
		
		
		//Copy each pointer and assign to its right
		RandomListNode temp = head;
		while(temp!=null){
			
			RandomListNode next = temp.next;
			RandomListNode copy = new RandomListNode(temp.label);
			temp.next=copy;
			copy.next=next;
			temp=next;
			
		}
		//Copy the random pointers
		temp=head;
		while(temp!=null){	
			temp.next.random=temp.random.next;
			temp=temp.next.next;			
		}
		
		//Extract the two lists
		temp=head;
		RandomListNode copyhead = temp.next;
		RandomListNode copy = copyhead;
		
		while(copy.next!=null){
			
			temp.next=temp.next.next;
			temp=temp.next;
			
			copy.next=copy.next.next;
			copy=copy.next;
			
			
		}
		
		temp.next=temp.next.next;
		
		return copyhead;
		
	}
}
