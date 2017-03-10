package stacks;

import java.util.Stack;

public class StackSort {
	
	
	public static void sortStack(Stack<Integer> stack){
		
		Stack<Integer> auxStack = new Stack<Integer>();
		
		while(!stack.isEmpty()){
			if(auxStack.isEmpty())
				auxStack.push(stack.pop());
			else {
				int val = stack.pop();
				
				if(val>auxStack.peek()){
					int count=0;
				while(!auxStack.isEmpty() && val>auxStack.peek()){
					stack.push(auxStack.pop());
					count++;
				}
				auxStack.push(val);
				while(count>0){
					auxStack.push(stack.pop());
					count--;
				}
				}else {
					auxStack.push(val);
				}	
			}
		}
		
		while(!auxStack.isEmpty()){
			System.out.println(auxStack.pop());
		}
		
	}
	
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		stack.push(5);
		stack.push(6);
		stack.push(8);
		stack.push(3);
		stack.push(9);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		
		sortStack(stack);
	}

}
