package linkedLists;

public class PartitionList {
	
	
	public ListNode partitonList(ListNode head,int val){
		
		ListNode temp1 = new ListNode(0);
		ListNode curtemp1= temp1;
		ListNode temp2 = new ListNode(0);
		ListNode curtemp2 = temp2;
		
		while(head!=null){
			
			if(head.data<val){
				curtemp1.next=head;
				curtemp1=curtemp1.next;
			}else{
				curtemp2.next=head;
				curtemp2=curtemp2.next;
			}
			
			head=head.next;
			
		}
		curtemp2.next=null;
		curtemp1.next=temp2.next;
		return temp1.next;
		
	}

	public static void main(String[] args) {
		PartitionList pl = new PartitionList();
		ListNode head = new ListNode(1);
		head.next= new ListNode(4);
		head.next.next= new ListNode(3);
		head.next.next.next= new ListNode(2);
		head.next.next.next.next= new ListNode(5);
		head.next.next.next.next.next= new ListNode(2);
		ListNode res = pl.partitonList(head, 3);
		System.out.println();
	}

}
