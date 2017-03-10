package queues;

import java.util.Stack;

import linkedLists.ListNode;

public class ReverseQueueUsingStack {
	
	public static LinkedListQueue reverseQueue(LinkedListQueue queue){
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(!queue.isEmpty()){
			
			try {
				stack.push(queue.deQueue());
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
		while(!stack.isEmpty()){
			queue.enQueue(stack.pop());
		}
		
		return queue;
		
		
	}
	
	public static void main(String[] args) throws Exception{
		
		
		LinkedListQueue queue  = new LinkedListQueue();
		
		queue.enQueue(5);
		queue.enQueue(34);
		queue.enQueue(45);
		System.out.println(queue.deQueue());
		queue.enQueue(12);
		queue.enQueue(67);
		System.out.println(queue.deQueue());
		ListNode p = queue.head;
		while(p!=null){
			System.out.println(p.getData());
			p=p.getNext();
		}
		
		LinkedListQueue revQueue = reverseQueue(queue);
		
		while(!revQueue.isEmpty()){
			System.out.println(revQueue.deQueue());
		}
	}

}
