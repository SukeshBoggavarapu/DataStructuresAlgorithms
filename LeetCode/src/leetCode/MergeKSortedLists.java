package leetCode;

public class MergeKSortedLists {
	
	
	public ListNode mergeSortedLists(ListNode[] listNodes){
		
		int size = listNodes.length;
		ListNode fakeNode = new ListNode(-1);
		ListNode temp = fakeNode;
		PriorityQueue queue = new PriorityQueue(size);
		for(int i=0;i<listNodes.length;i++){
			queue.add(listNodes[i]);
		}
		
		while(!queue.isEmpty()){
			ListNode minNode = queue.extractMin();
			temp.next=minNode;
			temp=temp.next;
			if(minNode.next!=null){
			queue.add(minNode.next);
			}
		}
		
		return fakeNode.next;
	}

	public static void main(String[] args) {
		ListNode[] nodes = new ListNode[4];
		ListNode node1 = new ListNode(-8);
		node1.next = new ListNode(-7);
		node1.next.next = new ListNode(-7);
		node1.next.next.next = new ListNode(-5);
		node1.next.next.next.next = new ListNode(1);
		node1.next.next.next.next.next = new ListNode(1);
		node1.next.next.next.next.next.next = new ListNode(3);
		node1.next.next.next.next.next.next.next = new ListNode(4);
		nodes[0]=node1;
		ListNode node2 = new ListNode(-2);
		/*node2.next = new ListNode(4);
		node2.next.next = new ListNode(7);*/
		nodes[1]=node2;
		ListNode node3 = new ListNode(-10);
		node3.next = new ListNode(-10);
		node3.next.next = new ListNode(-7);
		node3.next.next.next = new ListNode(0);
		node3.next.next.next.next = new ListNode(1);
		node3.next.next.next.next.next = new ListNode(3);
		/*node3.next.next.next.next.next.next = new ListNode(42);
		node3.next.next.next.next.next.next.next = new ListNode(43);
		node3.next.next.next.next.next.next.next.next = new ListNode(44);*/
		nodes[2]=node3;
		ListNode node4 = new ListNode(2);
		nodes[3]=node4;
		MergeKSortedLists msl = new MergeKSortedLists();
		ListNode resNode = msl.mergeSortedLists(nodes);
		System.out.println(resNode.val);
	}

}

class PriorityQueue{
	
	ListNode[] nodes ;
	int size;
	public PriorityQueue(int val){
		nodes = new ListNode[val];
		size=0;
	}
	
	
	public void add(ListNode node){
		
		nodes[size++]=node;
		
		if(size>=2){
			heapifyUp(size-1);
		}
	}
	
	private void heapifyUp(int i) {
		
		while(i>0){
			
			if(i%2==0){
				if(nodes[(i-2)/2].val>nodes[i].val){
					swap((i-2)/2,i);
				}
				i=(i-2)/2;
			}else{
				if(nodes[(i-1)/2].val>nodes[i].val){
					swap((i-1)/2,i);
				}
				i=(i-1)/2;
			}
			
			
		}
	}
	
	public void swap(int index1,int index2){
		
		ListNode temp = nodes[index1];
		nodes[index1]=nodes[index2];
		nodes[index2]=temp;
		
	}


	public ListNode extractMin(){
		
		ListNode res = nodes[0];
		nodes[0]=nodes[size-1];
		size--;
		heapifyDown(0,size-1);
		return res;
		
	}
	
	public void heapifyDown(int index,int pos){
		
		while(index<pos){
			
			if(pos==(2*index+1)){
				if(nodes[pos].val<nodes[index].val)
					swap(pos,index);
				index=pos;
			}else if(pos>=(2*index)+2){
				if(nodes[(2*index)+1].val<nodes[(2*index)+2].val){
					if(nodes[(2*index)+1].val<nodes[index].val)
						swap((2*index)+1,index);
					index=(2*index)+1;
				}else{
					if(nodes[(2*index)+2].val<nodes[index].val)
						swap((2*index)+2,index);
					index=(2*index)+2;
				}
			}
			 else
				return;
			
		}
		
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	
}




