package stacks;

public class FixedArrayStack<E> {
	
	protected int capacity;
	
	 int size ;
	 
	 int top =-1;
	
	 final int CAPACITY=10;
	
	protected E[] stackRep;
	
	public FixedArrayStack(){		
		this.capacity=CAPACITY;
		stackRep = (E[]) new Object[capacity];
		
	}
	
	public FixedArrayStack(int cap){
		this.capacity=cap;
		stackRep = (E[])new Object[capacity];
	}
	
	public void push(E data) throws Exception{
		if(size==capacity){
			throw new Exception("Stack is full");	
		}
		stackRep[++top]=data;		
	}
	
	public int size(){
		return top+1;
	}
	
	public E pop() throws Exception{
		
		if(isEmpty()){	
			throw new Exception("Stack is Empty");
		}
		E value = stackRep[top];
		stackRep[top--]=null;	
		return value;
	}
	
	public E peek() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is Empty");
		}
		
		return stackRep[top];
	}
	
	public boolean isEmpty(){
		return (top<0);
	}
	
	public String toString(){
		
		String s =" ";
		for(int i=top;i>=0;i--){
			
			s=s+String.valueOf(stackRep[i]);
			
		}
		return s;
	}
	
	public static void main(String[] args){
		
		
		FixedArrayStack<Integer> stack = new FixedArrayStack<Integer>(20);
		System.out.print(stack.size());
		System.out.print(stack.capacity);
		try {
			stack.push(5);
			stack.push(4);
			stack.push(7);
			stack.push(9);
			System.out.print(stack.size());
			System.out.print(stack.peek());
			stack.pop();
			System.out.print(stack.size());
			System.out.print(stack.peek());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print(stack.toString());
	}
	
}
