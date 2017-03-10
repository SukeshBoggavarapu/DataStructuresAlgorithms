package leetCode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersWithoutReversing {
	
	
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        List<Integer> list1 = new ArrayList<Integer>();
        int length1=0;
        while(l1!=null){
            list1.add(l1.val);
            l1=l1.next;
            length1++;
        }
        
        List<Integer> list2 = new ArrayList<Integer>();
        int length2=0;
        while(l2!=null){
            list2.add(l2.val);
            l2=l2.next;
            length2++;
        }
        
        int diff = length1-length2;
        List<Integer> list = null;
        if(diff<=0){
            list= list1;
            list1=list2;
            diff=-diff;
        }else {
            list=list2;
        }
        int k=0;
      for(int i =diff;i<list1.size();i++){
             int sum = list.get(k)+list1.get(i);
             k++;
           if(i==0){
               list1.set(i,sum);
           }else{
          list1.set(i,sum%10);
          
          if(sum>=10){
             int carry=1;
            int j=i-1;
             while(j>0){
             if(carry==1){
            	  if(list1.get(j)+1>=10){
                      carry=1;
                  }else {
                      carry=0;
                  }
             list1.set(j,(list1.get(j)+1)%10);
           
             }
             j--;
             
            }
            if(carry==1){
                list1.set(0,list1.get(0)+1);
            }
          }
      }
      }
      ListNode head = null;
      ListNode temp = null;
      if(list1.get(0)>=10){
          
          head = new ListNode(1);
          head.next = new ListNode(list1.get(0)%10);
          temp = head.next;
          
      }else {
          head = new ListNode(list1.get(0));
          temp = head;
      }
      
      
      
      for(int i=1;i<list1.size();i++){
          
          temp.next = new ListNode(list1.get(i));
          temp = temp.next;
          
      }
      
      return head;
      
    }
        
	

	public static void main(String[] args) {
		ListNode head1 = new ListNode(8);
		head1.next = new ListNode(9);
		head1.next.next = new ListNode(9);
		
		
		ListNode head2 = new ListNode(2);
		
		
		addTwoNumbers(head1, head2);
		System.out.println("");
	}

}
