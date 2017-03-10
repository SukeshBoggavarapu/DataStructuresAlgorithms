package dpCTC;

public class RobotWalk {
	
	int count =1;
	
	public int numberOfPaths(int[][] board,int x,int y){
		
		if(x==0 && y==0){
			return 0;
		}
		if(x==0 || y==0){
			return 1;
		}
			
		 int path1 = numberOfPaths(board,x,y-1);
		 int path2 =numberOfPaths(board,x-1,y);
		 return path1+path2;
	}
	
	public int numberOfPathsDP(int[][] board , int x ,int y){
		if(x==0 && y==0){
			return 0;
		}
		if(x==0 || y==0){
			return 1;
		}
		
		int[][] dpPaths = new int[x+1][y+1];
		dpPaths[0][0]=0;
		for (int i=1;i<=y;i++){
			dpPaths[0][i]=1;	
		}
		for (int i=1;i<=x;i++){
			dpPaths[i][0]=1;	
		}
		
		for (int i=1;i<=x;i++){
			
			for(int j=1;j<=y;j++){
				
				dpPaths[i][j]= dpPaths[i-1][j]+dpPaths[i][j-1];
				if(i==2 && j==1)
					dpPaths[i][j]=0;
			}
		}
		
		
		return dpPaths[x][y];
		
	}

	public static void main(String[] args) {
		
		
		RobotWalk rw = new RobotWalk();
		int[][] board = new int[3][4];
		System.out.println(rw.numberOfPathsDP(board, 2, 2));
	}

}
