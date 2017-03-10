package stacks;

import queues.LinkedListQueue;

public class StackUsingTwoQueues {
	
	LinkedListQueue queue1 = new LinkedListQueue();
	LinkedListQueue queue2 = new LinkedListQueue();
	
	public void push(int data){
		
		if(queue1.isEmpty()){
			queue2.enQueue(data);
		}else{
			queue1.enQueue(data);
		}
		
	}
	
	public int pop() throws Exception{
		
		if(!queue1.isEmpty()){
			
			for(int i=0;i<queue1.length()-1;i++){
				
				queue2.enQueue(queue1.deQueue());
			}
			return queue1.deQueue();
			
		}else{
			for(int i=0;i<queue2.length()-1;i++){
				
				queue1.enQueue(queue2.deQueue());
			}
			return queue2.deQueue();
			
		}
	}

}
