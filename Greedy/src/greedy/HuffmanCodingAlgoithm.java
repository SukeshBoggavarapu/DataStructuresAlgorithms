package greedy;

public class HuffmanCodingAlgoithm {
	
	public static void HuffmanAlgo(BinaryCharacter[] cArray){
		
		PriorityQueue2 pq = new PriorityQueue2();
		pq.buildHeap(cArray);
		
		BinaryCharacter temp = null;
		
		for (int i=1;i<cArray.length;i++){
			
			temp = new BinaryCharacter();
			temp.setLeft(pq.extractMin());
			temp.setRight(pq.extractMin());
			temp.setFrequency(temp.getLeft().getFrequency()+temp.getRight().getFrequency());
			temp.setC('z');
			pq.insert(temp);
		}
		
		
			System.out.println(temp);
		
		
		
		
	}
	
	public static void main(String[] args){
		
		BinaryCharacter[] array = new BinaryCharacter[6];
		array[0]= new BinaryCharacter('a',12);
		array[1]= new BinaryCharacter('e',14);
		array[2]= new BinaryCharacter('b',2);
		array[3]= new BinaryCharacter('f',85);
		array[4]= new BinaryCharacter('c',7);
		array[5]= new BinaryCharacter('d',13);
		
		HuffmanAlgo(array);
	}

}
