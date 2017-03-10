package dp;

public class MinimumPathSum {
	
	public static int minimumPathSum(int[][] vals){
		
		if(vals.length==0 || vals==null){
			return 0;
		}
		
		int m = vals.length;
		int n = vals[0].length;
		
		int[][] dp = new int[m][n];
		char[][] path = new char[m][n];
		dp[0][0] = vals[0][0];
		path[0][0]='S';
		
		for(int i=1;i<m;i++){
			dp[i][0]=dp[i-1][0]+vals[i][0];
			path[i][0]='U';
		}
		
		for(int j=1;j<n;j++){
			dp[0][j]=dp[0][j-1]+vals[0][j];
			path[0][j]='R';
		}
		
		for(int i=1;i<m;i++){
			
			for(int j=1;j<n;j++){
				
				if(dp[i-1][j]<dp[i][j-1]){
					dp[i][j]=dp[i-1][j]+vals[i][j];
					path[i][j]='U';
				}else{
					dp[i][j]=dp[i][j-1]+vals[i][j];
					path[i][j]='R';
				}
			}
		}
		
		int i=m-1;
		int j=n-1;
		while(path[i][j]!='S'){
			System.out.println(vals[i][j]);
			if(path[i][j]=='U'){		
				i--;
			}else if(path[i][j]=='R'){
				j--;
			}	
		}
		System.out.println(vals[i][j]);
		
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args){
		
		int[][] matrix = new int[3][3];
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				matrix[i][j]=(int) Math.pow(2, i)+(int) Math.pow(3,j);
			}
			
		}
		
		System.out.println(minimumPathSum(matrix));
	}

}
