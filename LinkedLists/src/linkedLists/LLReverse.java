package linkedLists;

public class LLReverse {
	
	public ListNode llReverse(ListNode head){
		
		if(head.next==null)
			return head;
		
		ListNode p = head.next;
		head.next=null;
		ListNode newHead = llReverse(p);
		p.next=head;
		return newHead;
		
	}

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		
		
		l1.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		l5.setNext(l6);
		l6.setNext(l7);
		l7.setNext(l8);
		l8.setNext(l9);
		
		LLReverse llr = new LLReverse();
		ListNode res = llr.llReverse(l1);
		System.out.println();
	}

}
