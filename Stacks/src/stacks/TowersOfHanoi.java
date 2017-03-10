package stacks;

import java.util.Stack;

public class TowersOfHanoi {
	
	
	public static void towersOfHanoi(int n ,Stack<Integer> src , Stack<Integer> aux , Stack<Integer> dest){
		
		if(n==1){
			dest.push(src.pop());
			return;		
		}	
			
		towersOfHanoi(n-1,src,dest,aux);	
		dest.push(src.pop());
		towersOfHanoi(n-1,aux,src,dest);
		
	}
	
	public static void towersOfHanoiIterative(int n, Stack<Integer> src , Stack<Integer> aux ,Stack<Integer> dest){
		
		for (int i=1;i<=n;i++){
			
			
			if(i%3==1){
				
				move(src,dest);
				
			}else if(i%3==2){
				
				move(src,aux);
				
			}else if(i%3==0){
				
				move(aux,dest);
				
			}
		}
	}
	
	public static void move(Stack<Integer> stack1 , Stack<Integer> stack2){
		
		if(stack1.isEmpty() && stack2.isEmpty())
			   return;
		
		if(!stack1.isEmpty() && !stack2.isEmpty()){
			
			if(stack1.peek()>stack2.peek()){
				stack1.push(stack2.pop());
			}else {
				stack2.push(stack1.pop());
			}
		}else if(stack1.isEmpty()){
			stack1.push(stack2.pop());
		}else {
			stack2.push(stack1.pop());
		}
		
	}
	
	public static void main(String[] args){
		
		Stack<Integer> src = new Stack<Integer>();
		src.push(6);
		src.push(5);
		src.push(4);
		src.push(3);
		src.push(2);
		src.push(1);
		Stack<Integer> aux = new Stack<Integer>();
		Stack<Integer> dest = new Stack<Integer>();
		//towersOfHanoi(5, src, aux, dest);
		int numOfDisks = src.size();
		int numOfMoves =(int) Math.pow(2, numOfDisks)-1;
		
		if(numOfDisks%2==0){
			towersOfHanoiIterative(numOfMoves,src,dest,aux);
		}else {
			towersOfHanoiIterative(numOfMoves,src,aux,dest);
		}
		while(!dest.isEmpty()){
			System.out.println(dest.pop());
		}
	}

}
