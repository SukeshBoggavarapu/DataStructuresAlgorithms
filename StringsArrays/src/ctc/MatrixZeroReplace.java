package ctc;

public class MatrixZeroReplace {
	
	public void matrixReplace(int[][] matrix){
		
		int len1=matrix.length;
		int len2 =matrix[0].length;
		
		for(int i=0;i<len1;i++){
			
			for(int j=0;j<len2;j++){
				
				if(matrix[i][j]==0){
					int k=0;
					while(k<len1){
						matrix[k][j]=0;
					}
					k=0;
					while(k<len2){
						matrix[i][k]=0;
					}
					
				}
				
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
