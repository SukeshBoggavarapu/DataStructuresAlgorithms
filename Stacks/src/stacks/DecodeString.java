package stacks;

import java.util.Stack;

public class DecodeString {
	
	 public static String decodeString(String s) {
	        
		 if(s==null || s.length()==0)
	            return s;
	        
	        Stack<Integer> stack1 = new Stack<Integer>();
	        Stack<String> stack2 = new Stack<String>();
	        int start =0;
	        boolean isFirst = true;
	        StringBuffer sb = new StringBuffer();
	        
	        for(int i=0;i<s.length();i++){
	            
	            if(s.charAt(i) >='0' && s.charAt(i) <='9'){
	                
	                if(isFirst){
	                    start =i;
	                    isFirst=false;
	                }
	                
	            }else if(s.charAt(i)=='['){
	                    
	                    int count = Integer.parseInt(s.substring(start,i));
	                    stack1.push(count);
	                    isFirst=true;
	                    stack2.push("[");
	                    
	           }else if(s.charAt(i)==']'){
	               
	               while(stack2.peek()!="["){
	               sb.append(stack2.pop());
	               }
	               stack2.pop();
	               
	               String str = "";
	               int val = stack1.pop();
	               while(val>0){
	                   str=str+sb.toString();
	                   val--;
	               }
	               stack2.push(str);
	               sb.replace(0,sb.length(),"");
	               
	           }else {
	               stack2.push(s.charAt(i)+"");
	           }
	        }
	        
	        sb.replace(0,sb.length(),"");
	        while(!stack2.isEmpty()){
	            
	            sb.append(stack2.pop());
	            
	        }
	        
	        return sb.reverse().toString();
	        
	    }       
	    
	 
	 public static void main(String[] args){
		 System.out.println(decodeString("3[a]2[bc]"));
	 }

}
