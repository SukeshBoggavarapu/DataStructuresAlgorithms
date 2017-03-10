package linkedLists;

public class IsCycleExists {

	public static boolean isCycleExists(ListNode l){
		
		ListNode sp=l;
		ListNode fp =l;
		
		while(fp.getNext()!=null && fp.getNext().getNext()!=null){
		
			sp=sp.getNext();
			fp=fp.getNext().getNext();
			if(sp==fp){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);

		l1.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		l5.setNext(l3);
		l6.setNext(l7);
		l7.setNext(l8);
		l8.setNext(null);
		
		
		
		System.out.println(isCycleExists(l1));	}
}
