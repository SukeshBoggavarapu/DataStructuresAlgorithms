package leetCode;

public class AddTwoNumbers2 {
	
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head1 = reverseList(l1);
        ListNode head2 = reverseList(l2);
        ListNode head = null;
        ListNode temp =null;
        /*List<Integer> list = new ArrayList<Integer>();
        list.*/
        int carry=0;
        int val1 =0;
        int val2=0;
        int data =0;
        while(head1!=null || head2!=null){
            
            if(head1!=null){
                
                val1=head1.val;
                head1=head1.next;
                
                
            }
            
            if(head2!=null){
                
                val2=head2.val;
                head2=head2.next;
            }
            
            data = val1+val2;
            if(carry==1){
            data = 1+data;
            carry=0;
            }
            
            if(head==null){
                head = new ListNode(data%10);
                temp=head;
            }else {
                    ListNode node  = new ListNode(data%10);
                    temp.next=node;
                    temp=temp.next;
            }
            
            if(data>=10){
                carry=1;
            }
            val1=0;
            val2=0;
        }
        
        if(carry==1){
             ListNode node  = new ListNode(1);
             temp.next=node;
        }
        
        return head;
        
    }
    
    public static ListNode reverseList(ListNode l){
        
        if(l==null ){
            return null;
        }else if(l.next==null){
            return l;
        }
        
        ListNode m= l.next;
        ListNode n= m.next;
        
        m.next=l;
        l.next=null;
        ListNode p= reverseList(n);
        if(n!=null){
        n.next=m;
        }
        if(p==null){
        	return m;
        }
        
        return p;
    }

	public static void main(String[] args) {
		ListNode head1 = new ListNode(7);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);
		head1.next.next.next = new ListNode(3);
		
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);
		
		addTwoNumbers(head1, head2);
		System.out.println("");
	}
}

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 


