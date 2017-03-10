package stacks;

import java.util.Stack;

public class PostFixEvaluation {
	
	public static char[] a = new char[]{'2','5','+','7','*','4','-'};
	
	public static int evaluate(char[] c){
		
		int value=0;
		Stack<Integer> stack = new Stack<Integer>();
		int op1;
		int op2;
		
		for(int i=0;i<c.length;i++){
			
			switch(c[i]){
			
				case '+':
					op2=stack.pop();
					op1=stack.pop();
					stack.push(op1+op2);
					break;
				
				case '-':
					op2=stack.pop();
					op1=stack.pop();
					stack.push(op1-op2);
					break;
				
				case '*':
					op2=stack.pop();
					op1=stack.pop();
					stack.push(op1*op2);
					break;
				
				default:
				stack.push(Character.getNumericValue(c[i]));	
				break;
			}
						
			
		}
		
		if(!stack.isEmpty()){
			value = stack.pop();
		}
		return value;
	}
	
	public static void main(String[] args){
	
		System.out.println(evaluate(a));
		
		
	}
	

}
