package linkedLists;

public class ListNode{
	
	public ListNode next;
	
	public int data;
	
	public ListNode(int data){
		
		this.data=data;
		this.next=null;
	}

	public void setData(int data){
		this.data=data;
	}
	
	public int getData(){
		return data;
	}
	
	public void setNext(ListNode next){
		this.next=next;
	}
	
	public ListNode getNext(){
		
		return next;
	}
}
