package queues;

import stacks.FixedArrayStack;


public class QueueUsingTwoStacks {
	
	FixedArrayStack<Integer> enQueueStack = new FixedArrayStack<Integer>();
	FixedArrayStack<Integer> deQueueStack = new FixedArrayStack<Integer>();
	
	public void enQueue(int data) throws Exception{
		
		enQueueStack.push(data);
	}
	
	public int deQueue() throws Exception{
		
		if(!deQueueStack.isEmpty())
		{
			return deQueueStack.pop();
		}else{
			
			while(!enQueueStack.isEmpty()){
				
				deQueueStack.push(enQueueStack.pop());
			}
		}
		
		return deQueueStack.pop();
		
	}
	

}
