package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingOneQueue {
	
	
	Queue queue ;
	
	public void push(int x){
		
		Queue q = new LinkedList();
		q.add(x);
		q.add(queue);
		queue=q;
	}
	
	
	public int pop(){
		
		int data = (int) queue.poll();
		queue = (Queue) queue.peek();
		return data;
		
	}
	
	public int top(){
		
		return (int) queue.peek();
	}
	
	public boolean isEmpty(){
		return queue==null ? true :false;
	}
	
	public static void main(String[] args){
		
		StackUsingOneQueue stk = new StackUsingOneQueue();
		stk.push(3);
		stk.push(5);
		stk.push(7);
		System.out.println(stk.pop());
		stk.pop();
		stk.push(9);
		System.out.println(stk.top());
		stk.pop();
		stk.pop();
		System.out.println(stk.isEmpty());
		
		
	}

}
