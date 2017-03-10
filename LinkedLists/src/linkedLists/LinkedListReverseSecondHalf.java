package linkedLists;

public class LinkedListReverseSecondHalf {
	
	public void reverseSecondHalf(ListNode root){
		
		ListNode sp = root;
		ListNode fp= root;
		ListNode temp=null;
		boolean isOdd =false;
		//int count =0;
		while(true){
			if(fp.next==null){
				isOdd =true;
				break;
			}
			else if(fp.next.next==null){
				break;
			}
			temp=sp;
			sp=sp.next;
			fp=fp.next.next;
			//count++;
		}
		//int length=0;
		/*if(isOdd)
			length=2*count+1;
		else
			length=2*count+2;*/
		if(isOdd)
			temp.next=reverse(sp);
		else
			sp.next=reverse(sp.next);
		
	}
	
	public ListNode reverse(ListNode head){
		
		ListNode prev=null;
		ListNode next =null;
		while(head!=null){
			
			next=head.next;
			head.next=prev;
			prev=head;
			head=next;
			
			
		}
		
		return prev;
		
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
		/*l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		l5.setNext(l6);
		l6.setNext(l7);
		l7.setNext(l8);*/
		//l8.setNext(l9);
		
		LinkedListReverseSecondHalf lrsh = new LinkedListReverseSecondHalf();
		lrsh.reverseSecondHalf(l1);
		System.out.println();
	}

}
