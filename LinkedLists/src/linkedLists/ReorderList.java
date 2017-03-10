package linkedLists;

public class ReorderList {
	
	
	public static ListNode reorderList(ListNode l1){
		
		ListNode sp= l1;
		ListNode fp= l1;
		
		while(fp.getNext()!=null && fp.getNext().getNext()!=null){
			
			sp=sp.getNext();
			fp=fp.getNext().getNext();
		}
		
		ListNode r = sp.getNext();
		sp.setNext(null);
		
		ListNode np =reverseList(r);
		l1=merge(l1,np);
		
		return l1;
	}
	
	public static ListNode merge(ListNode l,ListNode m){
		if(m==null){
			return null;
		}
		
		ListNode n = l.getNext();
		ListNode r = m.getNext();
			l.setNext(m);
			m.setNext(null);	
		
		merge(n,r);
		m.setNext(n);
		return l;
	}
	
	public static ListNode reverseList(ListNode l){
		if(l.getNext()==null){
			return l;
		}
		
		ListNode m = l.getNext();
		l.setNext(null);
		ListNode p = reverseList(m);
		m.setNext(l);
		return p;
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
		ListNode l9 = new ListNode(9);
		
		
		l1.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		l5.setNext(l6);
		l6.setNext(l7);
		l7.setNext(l8);
		l8.setNext(l9);
		
		ListNode val = reorderList(l1);
		
		while(val!=null){
			System.out.println(val.getData());
			val=val.getNext();
		}
		
		
	}
}
