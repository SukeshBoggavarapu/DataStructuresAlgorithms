package stacks;

import java.util.Stack;

public class RemoveKdigits {
	
	public String removeKdigits(String num, int k) {
        
        if(num== null || num.length() == 0 || num.length() ==k)
            return "0";
            
        Stack<Character> stack = new Stack<Character>(); 
        
        /*The choice is if we encounter any small digit and a larger digit precedes it , the larger digit can be
         safely removed .*/
            
        for(int i=0;i<num.length();i++){
            
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                
                stack.pop();
                k--;
                
            }
            
            stack.push(num.charAt(i));
        }
        
        
        /*If it is leading sequence or non-decreasing , the safe way is to remove the last characters*/
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        StringBuffer sb = new StringBuffer();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        //To remove leading zeros, instead of reversing and deletion which makes it costly, we delete before reverse
        int index = sb.length()-1;
        while(index>=0 && sb.charAt(index)=='0'){
            sb.deleteCharAt(index);
            index--;
        }
        
        //The final length can be zero.
        
        return sb.length()==0 ? "0" : sb.reverse().toString();

}
}
