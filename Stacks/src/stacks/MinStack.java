package stacks;

public class MinStack {
	    
	    int top =-1;
	    int size=0;
	    final int DEFAULT_CAPACITY =3;
	    int capacity ;
	    int minCapacity ;
	    int[] stackArray = null;
	    int[] minArray = null;
	    int minSize =0;
	    int minTop =-1;
	    
	    /** initialize your data structure here. */
	    public MinStack() {
	        
	        this.capacity = DEFAULT_CAPACITY;
	        this.minCapacity= DEFAULT_CAPACITY;
	        stackArray = new int[capacity];
	        minArray = new int[capacity];
	    }
	    
	    public void push(int x) {
	        
	        if(size>=capacity){
	       
	        	int newCapacity = capacity*2;
	        	int[] newStack = new int[newCapacity];
	        	System.arraycopy(stackArray,0,newStack,0,size);
	        	stackArray=newStack;
	        	capacity=newCapacity;
	        
	        }
	        
	        if(minSize>=minCapacity){
	        	
	        	int newMinCapacity = minCapacity*2;
	        	int[] newMinStackArray = new int[newMinCapacity];
	        	System.arraycopy(minArray,0,newMinStackArray,0,minSize);
	        	minArray=newMinStackArray;
	        	minCapacity=newMinCapacity;	
	        }
	       
	    	stackArray[++top]=x;
            size++;
            
	        if(minTop==-1){
	            minArray[++minTop] = x;
	            minSize++;
	        }else if(x<=minArray[minTop]){
	            minArray[++minTop] = x;
	            minSize++;
	        }
	        
	        
	    }
	    
	    public void pop() {
	        
	        if(minArray[minTop]==stackArray[top]){
	            
	            minArray[minTop--]=0;
	            minSize--;
	        }
	    
	        if(size!=0){
	            stackArray[top--]=0;
	             size--;
	        } 
	            
	    }
	    
	    public int top() {
	        
	        int data =0;
	        if(size!=0){
	         data = stackArray[top];
	        }
	        
	        return data;
	        
	    }
	    
	    public int getMin() {
	        
	        return minArray[minTop];
	        
	    }

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */

	public static void main(String[] args) {
		
	
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.push(7);
		minStack.push(2);
		minStack.push(27);
		minStack.push(-5);
		minStack.push(56);
		minStack.push(-7);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		
		
	}

}
