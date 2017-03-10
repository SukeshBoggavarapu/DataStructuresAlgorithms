package linkedLists;

public class RemoveDuplicatesLinkedList {
	
	public ListNode removeDups(ListNode head){
		
		ListNode sp = head;
		
		ListNode fakeNode = head;
		ListNode cur =head;
		while(fakeNode!=null && fakeNode.next!=null){
			int val =fakeNode.data;
		while(cur!=null && cur.next!=null){
			
			if(val==cur.next.data){
				sp.next=cur.next.next;
				
				cur=cur.next;
			}
			else{
				sp.next=cur.next;
				
			    cur=cur.next;
			   
			}
			 sp=sp.next;
			
		}
	
		fakeNode=fakeNode.next;
		cur=fakeNode;
		sp=fakeNode;
		}
		return fakeNode.next;
		
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(1);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(6);
		
		
		l1.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		l5.setNext(l6);
		l6.setNext(l7);
		l7.setNext(l8);
		l8.setNext(l9);
		RemoveDuplicatesLinkedList rll = new RemoveDuplicatesLinkedList();
		rll.removeDups(l1);
		System.out.println();
	}

}
