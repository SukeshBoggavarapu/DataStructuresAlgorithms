package stacks;

public class DynamicArrayStack {
	protected int capacity;

	 int size ;
	 
	 int top =-1;
	
	 final int INITIALCAPACITY=10;
	
	protected int[] stackRep;
	
	public DynamicArrayStack(){		
		this.capacity=INITIALCAPACITY;
		stackRep = new int[capacity];
		
	}
	
	public DynamicArrayStack(int cap){
		this.capacity=cap;
		stackRep = new int[capacity];
	}
	
	public void push(int data) throws Exception{
		if(size==capacity){
			expand();
		}
		stackRep[++top]=data;		
	}
	
	public void expand(){
		
		int[] newStack = new int[2*capacity];
		System.arraycopy(stackRep,0,newStack,0,size());
		stackRep=newStack;
		
	}
	public int size(){
		return top+1;
	}
	
	public int pop() throws Exception{
		
		if(isEmpty()){	
			throw new Exception("Stack is Empty");
		}
		int value = stackRep[top];
		stackRep[top--]=Integer.MIN_VALUE;	
		return value;
	}
	
	public int peek() throws Exception{
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

}
