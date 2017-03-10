package leetCode;

public class SudokuSolver {
	
	public void sudokuSolver(char[][] board){
		
		if(board==null || board.length==0)
			return;
		solve(board);
		
	}
	
	public boolean solve(char[][] board){
		
		for(int i=0;i<board.length;i++){
			
			for(int j=0;j<board[0].length;j++){
				
				if(board[i][j]=='.'){
					
					for(char k=1;k<=9;k++){
						
						if(isValidSudoku(board,i,j,k)){
							
							board[i][j]=k;
							
							if(solve(board))
								return true;
							else
								board[i][j]='.';
	
						}						
					}
					
					return false;
				}			
			}		
		}
		
		return true;
	}
	
	public boolean isValidSudoku(char[][] board,int row ,int column, char k){
		
		for(int i=0;i<board.length;i++){		
			if(board[row][i]==k) return false;
			if(board[i][column]==k) return false;
			if(board[3*row/3+i/3][3*column/3+i%3]==k) return false;	
		}
		
		return true;
		
		
	}
	

}
