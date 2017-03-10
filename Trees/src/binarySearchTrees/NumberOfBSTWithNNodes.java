package binarySearchTrees;

public class NumberOfBSTWithNNodes {
	
	public static int numberOfBSTs(int n){
		
		if(n==0 || n==1)
			return 1;
		if(n>1){
		
		int[] bstTotal = new int[n+1];
		//Empty Tree
			bstTotal[0] =1;
		//1 Node
			bstTotal[1]=1;
		for(int i=2;i<n+1;i++){
			for(int j=i;j>0;j--){
			bstTotal[i]=bstTotal[i]+(bstTotal[j-1]*bstTotal[i-j]);
			}
		}	
		return bstTotal[n];
		
		}else 
			return 0;
		
		
	}

	public static void main(String[] args) {
		System.out.println(numberOfBSTs(4));
	}

}
