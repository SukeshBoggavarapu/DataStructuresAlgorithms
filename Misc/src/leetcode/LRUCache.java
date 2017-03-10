package leetcode;

import java.util.Hashtable;

class DLLNode{
	int key;
	int value;
	DLLNode prev;
	DLLNode next;
}

public class LRUCache {
	
	DLLNode head;
	DLLNode tail;
	int count;
	int capacity;
	Hashtable<Integer,DLLNode> cache = new Hashtable<Integer,DLLNode>();
	
	public LRUCache(int capacity){
		
		this.count=0;
		this.capacity=capacity;
		
		head = new DLLNode();
		head.prev=null;
		
		tail= new DLLNode();
		tail.next=null;
		
		head.next=tail;
		tail.prev=head;
		
		
	}
	
	public void addNode(DLLNode node){
		
		node.prev=head;
		node.next = head.next;
		
		head.next.prev=node;
		head.next=node;
		
	}
	
	public void removeNode(DLLNode node){
		
		DLLNode pre = node.prev;
		DLLNode next=node.next;
		
		pre.next=next;
		next.prev=pre;
		
	}
	
	public void removeTail(){
		
		DLLNode pre = tail.prev;
		removeNode(pre);
		
		
	}
	
	public int get(int key){
		
		DLLNode cur = cache.get(key);
		if(cur==null)
			return -1;
		
		removeNode(cur);
		addNode(cur);
		return cur.value;
	}
	
	public void put(int key,int value){
		
		DLLNode cur = cache.get(key);
		
		if(cur==null){
			
			DLLNode node = new DLLNode();
			node.key=key;
			node.value=value;
			cache.put(key, node);
			addNode(node);
			
			++count;
			
			if(count>capacity){
				
				DLLNode temp = tail.prev;
				cache.remove(temp.key);
				removeNode(temp);
				--count;
			}
			
		}else{
			
			cur.value= value;
			removeNode(cur);
			addNode(cur);
			
		}
		
	}
	
	
	
}
 