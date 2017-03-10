package leetCode;

public class AddTwoNumbers1 {
	
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        if(l1==null || l2==null){
	            return l1==null ? l2:l1;
	        }
	        int carry =0;
	        int sum =0;
	        boolean isFirst = true;
	        ListNode root =null;
	        ListNode returned =null;
	        
	        while(l1!=null || l2!=null){
	            
	            if(l1!=null){
	                sum=sum+l1.val;
	                l1=l1.next;
	            }
	            
	            if(l2!=null){
	                sum=sum+l2.val;
	                l2=l2.next;
	            }
	            
	            if(isFirst){
	                root = new ListNode(sum%10);
	                returned = root;
	                isFirst=false;
	            }else {
	                ListNode node = new ListNode(sum%10);
	                returned.next=node;
	                returned=returned.next;
	            }
	            
	            if(sum>=10)
	                carry=1;
	            else 
	                carry=0;
	            sum=carry;    
	        }
	        
	        if(carry==1){
	            returned.next = new ListNode(1);
	        }
	        
	        return root;
	        
	    }

	public static void main(String[] args) {
		ListNode head1 = new ListNode(7);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);
		head1.next.next.next = new ListNode(3);
		
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);
		
		ListNode res = addTwoNumbers(head1, head2);
		System.out.println(res.val);
	}

}
