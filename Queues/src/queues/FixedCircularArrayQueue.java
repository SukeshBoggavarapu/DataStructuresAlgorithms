package queues;

public class FixedCircularArrayQueue {
	
	protected int capacity;
	
	final int CAPACITY = 10;
	
	int[] arrayQueue ;
	
	int head;
	int tail;
	int size;
	
	public FixedCircularArrayQueue(){
		
		this.capacity = CAPACITY;
		arrayQueue = new int[capacity];
		head=0;tail=0;size=0;
		
	}
	
	public FixedCircularArrayQueue(int cap){
		
		this.capacity = cap;
		arrayQueue = new int[capacity];
		head=0;tail=0;size=0;	
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
	public int size(){
		
		return size;
	}
	
	public void enQueue(int data) throws Exception{
		
		if(size==capacity){
			
			throw new Exception ("Queue is Full");
			
		}
		size++;
		arrayQueue[tail]=data;
		tail++;
		
	}
	
	public int deQueue() throws Exception{
		
		if(size==0){
			
			throw new Exception("Queue is Empty");
		}
		
		size--;
		int val = arrayQueue[head];
		arrayQueue[head]= Integer.MIN_VALUE;
		head++;
		
		return val;
		
	}
	
	public boolean isFull(){
		
		return (size==capacity);
	}
	
	 
	

}
