package greedy;

public class PriorityQueue {
	
	static Node[] nodes = new Node[10000];
	static int size=0;
	
	public void insert(Node node,double value){
		size=size+1;
		nodes[size]=node;
		node.setIndex(size);
		node.setKeyValue(value);
		heapifyUp(size);	
	}

	public void heapifyUp(int pos) {
		
		int j;
		Node tempNode;
		while(pos>1){
			j=pos/2;
			
			if(nodes[pos].getKeyValue()<nodes[j].getKeyValue()){	
				tempNode= nodes[pos];
				nodes[pos] = nodes[j];
				nodes[j] = tempNode;
				nodes[pos].setIndex(pos);
				nodes[j].setIndex(j);				
			}		
			pos=j;
		}
		
	}
	
	public Node extractMin(){
		
		Node minNode = nodes[1];
		
		nodes[1]=nodes[size];
		nodes[1].setIndex(1);
		size=size-1;
		if(size>1){
			heapifyDown(1);
		}	
		return minNode;
	}

	private void heapifyDown(int i) {
		int j;
		Node tempNode;
		while(2*i<=size){
			
			if(2*i==size || nodes[2*i].getKeyValue()<nodes[(2*i)+1].getKeyValue()){	
				j=2*i;	
			}else{
				j=(2*i)+1;
			}
			
			if(nodes[i].getKeyValue()>nodes[j].getKeyValue()){
				tempNode=nodes[i];
				nodes[i]=nodes[j];
				nodes[j]=tempNode;
				nodes[i].setIndex(i);
				nodes[j].setIndex(j);	
			}
			
			i=j;	
		}
	}
	
	public void decreaseKey(Node node,double value){
		
		nodes[node.getIndex()].setKeyValue(value);
		heapifyUp(node.getIndex());
	}
	
	public Node getNode(int i){
		
		return nodes[i];
	}
	
	public boolean isEmpty(){
		
		return (size==0);
	}
	
	

}
