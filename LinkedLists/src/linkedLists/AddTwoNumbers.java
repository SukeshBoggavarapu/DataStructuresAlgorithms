package linkedLists;

public class AddTwoNumbers {
	
	
	public static ListNode addInReverseOrder(ListNode l1,ListNode l2){
		
		ListNode value = new ListNode(0);
		
		ListNode p1=l1;
		ListNode p2=l2;
		ListNode p3= value;
		
		int carry = 0;
		while(p1!=null || p2!= null){
			
			if(p1!=null){	
				carry+=p1.getData();
				p1=p1.getNext();	
			}
			
			if(p2!=null){	
				carry+=p2.getData();
				p2=p2.getNext();
			}
			
			
			p3.setNext(new ListNode(carry%10));
			p3=p3.getNext();
			carry=carry/10;
			
		}
		
		if(carry==1){
			p3.setNext(new ListNode(1));
		}
		return value.getNext();
	}
	
public static ListNode addInRegularOrder(ListNode l1,ListNode l2){
		
		ListNode value = new ListNode(0);
		
		ListNode p3= value;
		
		
		ListNode n1=reverseList(l1);
		ListNode n2=reverseList(l2);
		
		ListNode p1=n1;
		ListNode p2=n2;
		int carry = 0;
		while(p1!=null || p2!= null){
			
			if(p1!=null){	
				carry+=p1.getData();
				p1=p1.getNext();	
			}
			
			if(p2!=null){	
				carry+=p2.getData();
				p2=p2.getNext();
			}
			
			
			p3.setNext(new ListNode(carry%10));
			p3=p3.getNext();
			carry=carry/10;
			
		}
		
		if(carry==1){
			p3.setNext(new ListNode(1));
		}
		ListNode reversed  = reverseList(value.getNext());
		return reversed;
	}
	
	public static void main(String[] args){
		
		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(7);
		ListNode l13 = new ListNode(8);
		l1.setNext(l12);
		l12.setNext(l13);
		
		ListNode l2 = new ListNode(4);
		ListNode l22 = new ListNode(9);
		ListNode l23 = new ListNode(3);
		l2.setNext(l22);
		l22.setNext(l23);
		
		ListNode sum = addInReverseOrder(l1,l2);
		while(sum!=null){
			System.out.println(sum.getData());
			sum=sum.getNext();
		}
		
		ListNode sumR = addInRegularOrder(l1,l2);
		
		while(sumR!=null){
			System.out.println(sumR.getData());
			sumR=sumR.getNext();
		}
	}
	
	public static ListNode reverseList(ListNode l){
		
		if(l.getNext()==null){
			return l;
		}
		
		ListNode m =l.getNext();
		l.setNext(null);
		ListNode p = reverseList(m);
		m.setNext(l);
		
		return p;
		
	}

}
