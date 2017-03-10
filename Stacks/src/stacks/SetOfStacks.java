package stacks;

import java.util.Stack;

public class SetOfStacks {
	
	private final int numOfStacks =3;
	private final int DEFAULT_CAPACITY =4;
	
	Stack<Integer>[] stackArray ;
	int capacity;
	int size =0;
	int top =-1;
	int stackNumber ;
	
	public SetOfStacks(){
		
		this.capacity=numOfStacks;
		stackArray = new Stack[capacity];
		Stack<Integer> firstStack = new Stack<Integer>();
		stackArray[0]=firstStack;
		stackNumber =0;
		
	}
	
	public void push(int x){
		
		if(size>=DEFAULT_CAPACITY){
			
			Stack<Integer> newStack = new Stack<Integer>();
			stackArray[++stackNumber]=newStack;
			size=0;
			
		}
		
		stackArray[stackNumber].push(x);
		size++;
		
		
	}
	
	public int pop(){
		if(stackArray[stackNumber].size()==0){
			stackNumber--;
			size=stackArray[stackNumber].size();
		}
		int data = (int) stackArray[stackNumber].pop();
		size--;
		return data;
	}
	
	
	public int top(){
		if(stackArray[stackNumber].size()==0){
			stackNumber--;
		}
		int data = (int) stackArray[stackNumber].peek();
		return data;
	}
	
	
	public boolean isEmpty(){
		
		while(stackNumber>=0){
			if(stackArray[stackNumber].size()!=0)
					return false;
			stackNumber--;
		}
		return true;
	}
	
	public int popAt(int index){
		int data = stackArray[index].pop();
		return data;
	}
	
	
	public static void main(String[] args){
		
		SetOfStacks stacks = new SetOfStacks();
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		stacks.push(7);
		System.out.println(stacks.top());
		System.out.println(stacks.pop());
		System.out.println(stacks.popAt(0));
		stacks.push(8);
		stacks.push(9);
		stacks.push(20);
		System.out.println(stacks.pop());	
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
		System.out.println(stacks.pop());
	}
	
	
}
