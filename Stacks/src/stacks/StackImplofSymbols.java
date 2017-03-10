package stacks;

import java.util.Stack;
//headers MUST be above the first class

//one class needs to have a main() method
public class StackImplofSymbols
{
// arguments are passed using the text field below this editor
public static void main(String[] args)
{
 String s = "(Sukesh[UB])";
  System.out.print(s+" "+ s.length());
 Boolean result = validSymbol(s);
 System.out.println(result);
 

 

}

private static boolean validSymbol(String s){
Stack<Character> stk = new Stack<Character>();
 
 for(int i=0;i<s.length();i++){
   if(s.charAt(i)==')'){
 if(!stk.isEmpty() && stk.peek()=='(')
   stk.pop();
   else return false;
   }
   else if(s.charAt(i)==']'){
  if(!stk.isEmpty() && stk.peek()=='[')
   stk.pop();
   else return false; 
   }
   else if(s.charAt(i)=='(' || s.charAt(i)=='['){
   stk.push(s.charAt(i));
                     }
 }
 
 if(stk.isEmpty()){
 return true;
 }
 else{
 return false;}
   }
}
