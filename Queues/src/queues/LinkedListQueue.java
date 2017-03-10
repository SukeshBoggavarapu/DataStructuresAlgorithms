package queues;

import linkedLists.ListNode;

public class LinkedListQueue{
	
	 int length;
	
	 ListNode head;
	 ListNode tail;
	 
	 public boolean isEmpty(){
		 
		 return (length==0);
	 }
	 
	 public int length(){
		 return length;
		 
	 }
	 
	 public LinkedListQueue(){
		 
		 this.length=0;
		 head=null;
		 tail=null;
	 }
	 
	 public void enQueue(int data){
		 
		 	 
		 ListNode newNode = new ListNode(data);
		 
		 if(isEmpty()){
			 head=newNode;
		 }
		 else{
		 tail.setNext(newNode);	
		 }
		 tail=newNode;
		 length++;
	 }
	 
	 public int deQueue() throws Exception{
		 
		 if(isEmpty()){
			 throw new Exception("Queue is Empty");
		 }
		 
		 int val = head.getData();
		 ListNode newHead = head.getNext();
		 head.setNext(null);
		 head=newHead;
		 length--;
		 return val;
	 }
	 
	 public int isFirst() throws Exception{
		 
		 if(isEmpty()){
			 throw new Exception("Queue is Empty");	 
		 }
		 
		 int val = head.getData();
		 return val;
	 }
	 

}
