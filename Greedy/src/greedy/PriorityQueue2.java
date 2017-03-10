package greedy;


public class PriorityQueue2 {
	
	static BinaryCharacter[] treeArray = new BinaryCharacter[26];
	
	static int size =0;
	
	public void insert(BinaryCharacter n){
		
		size++;
		treeArray[size]=n;
		heapifyUp(size);
		
	}

	public void heapifyUp(int size) {
		
		int j;
		BinaryCharacter temp;
		int tempIndex;
		
		if(size>1){
			j=size/2;
			
			if(treeArray[size].getFrequency()<treeArray[j].getFrequency()){
				
				temp=treeArray[size];
				treeArray[size]=treeArray[j];
				treeArray[j]=temp;
				
				tempIndex=treeArray[size].getIndex();
				treeArray[size].setIndex(treeArray[j].getIndex());
				treeArray[j].setIndex(tempIndex);
				
			}
			
			size=j;
			
		}
		
	}
	
	
	public BinaryCharacter extractMin(){
		
		BinaryCharacter minValue = treeArray[1];
		treeArray[1]=treeArray[size];
		treeArray[1].setIndex(1);
		size--;
		heapifyDown(1);
		return minValue;
	}

	public void heapifyDown(int val) {
		
		int j ;
		int tempIndex;
		BinaryCharacter temp;
		while(2*val<=size){
			
		
		if(2*val==size || treeArray[2*val].getFrequency()<treeArray[2*val+1].getFrequency()){
			
			j= 2*val;
		}else{
			j=(2*val)+1;
		}
		
		if(treeArray[val].getFrequency()>treeArray[j].getFrequency()){
			
			temp = treeArray[val];
			treeArray[val]=treeArray[j];
			treeArray[j]=temp;
			
			tempIndex=treeArray[val].getIndex();
			treeArray[val].setIndex(treeArray[j].getIndex());
			treeArray[j].setIndex(tempIndex);
			
		}
		
		val=j;
		
		}
	}
	
	public void buildHeap(BinaryCharacter[] array){
		
		int parentSize = array.length/2-1;
		
		for(int i=0;i<array.length;i++){
			array[i].setIndex(i+1);
		}
		
		while(parentSize>=0){
			
			heapifyDownBuildHeap(parentSize,array.length-1,array);
			parentSize=parentSize-1;
		}
		
		size=array.length;
		
		System.arraycopy(array, 0, treeArray, 1, array.length);;
	}

	public void heapifyDownBuildHeap(int parentSize,int arrayLength,BinaryCharacter[] array) {
		
		int j;
		int tempIndex;
		BinaryCharacter temp;
		
		while(2*parentSize+1<=arrayLength){
			
			if((2*parentSize)+1==arrayLength){
				j=(2*parentSize)+1;
			}else if(array[(2*parentSize)+1].getFrequency()<array[(2*parentSize)+2].getFrequency()){
				j=(2*parentSize)+1;
			}else {
				j=(2*parentSize)+2;
			}
			
			if(array[parentSize].getFrequency()>array[j].getFrequency()){
				
				temp=array[parentSize];
				array[parentSize]=array[j];
				array[j]=temp;
				
				tempIndex=array[parentSize].getIndex();
				array[parentSize].setIndex(array[j].getIndex());
				array[j].setIndex(tempIndex);
			}
			
			parentSize=j;		
			
		}
		
	}
	
	public boolean isEmpty(){
		return (size==0);
	}
	
}
