package leetCode2;
public class RotateMatrix {
	
	
	
	//Method 1 - Transpose and exchange elements along column wise
	public void rotate1(int[][] matrix){
		
		//Transpose
		int m = matrix.length;
		int n= matrix[0].length;
		int temp=0;
		for(int i=0;i<m;i++){
			
			for(int j=i+1;j<n;j++){
				temp = matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
			
		}
		
		//Exchange along column
		for(int i=0;i<m;i++){
			
			for(int j=0;j<n/2;j++){
				temp = matrix[i][j];
				matrix[i][j]=matrix[i][m-1-j];
				matrix[i][m-1-j]=temp;
			}
		}
		
	}
	
	//Method2 -- In a single loop rotate the corner elements 
	public void rotate2(int[][] matrix){
		
		int n=matrix.length;
		int temp=0;
		for(int i=0;i<n/2;i++){
			
			for(int j=0;j<Math.ceil(n/2.);j++){
				
				temp = matrix[i][j];
				matrix[i][j]=matrix[n-1-j][i];
				matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
					
			}
			
		}
		
	}
	
	public void rotateACW(int[][] matrix){
		
		int n = matrix.length;
		
		for(int i=0;i<n;i++){
			
			for(int j=i+1;j<n;j++){
				
				int temp = matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
				
			}
		}
		
		for(int i=0;i<n/2;i++){
			
			for(int j=0;j<n;j++){
				
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-1-i][j];
				matrix[n-1-i][j]=temp;
				
			}
			
		}
		
	}
	
	public void rotateACW2(int[][] matrix){
		
		int n = matrix.length;
		for(int i=0;i<n/2;i++){
			for(int j=0;j<Math.ceil(n/2.);j++){
				
				int temp = matrix[i][j];
				matrix[i][j]=matrix[j][n-1-i];
				matrix[j][n-1-i]=matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j]=matrix[n-1-j][i];
				matrix[n-1-j][i]=temp;
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		
		int[][] mat = new int[3][3];
		int k=1;
		for(int i=0;i<3;i++){
			
			for(int j=0;j<3;j++){
				mat[i][j]=k;
				k++;
			}
		}
		
		RotateMatrix rc = new RotateMatrix();
		//rc.rotate1(mat);
		//rc.rotate2(mat);
		//rc.rotateACW(mat);
		rc.rotateACW2(mat);
		System.out.println();
		
	}

}

