package leetCode2;

public class SpiralMatrix2 {
	
	public int[][] spiralMatrix2(int n){
		
		int[][] matrix = new int[n][n];
		int m=0;
		int rowStart=0;int rowEnd=n-1;
		int colStart=0;int colEnd=n-1;
		
		while(rowStart<=rowEnd && colStart<=colEnd){
			
			//Go Right
			for(int i=colStart;i<=colEnd;i++){
				matrix[rowStart][i]=++m;
			}
			rowStart++;
			//Go Down
			for(int i=rowStart;i<=rowEnd;i++){
				matrix[i][colEnd]=++m;
			}
			colEnd--;
			
			//Go Left
			if(rowStart<=rowEnd){
			for(int i=colEnd;i>=colStart;i--){
				matrix[rowEnd][i]=++m;
			}
			rowEnd--;
			}
			
			//Go Up
			if(colStart<=colEnd){
			for(int i=rowEnd;i>=rowStart;i--){
				matrix[i][colStart]=++m;
			}
			colStart++;
			}
			
		}
		return matrix;
		
	}

	public static void main(String[] args) {
		SpiralMatrix2 sm2 = new SpiralMatrix2();
		sm2.spiralMatrix2(3);
	}

}
