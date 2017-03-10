package leetCode;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
	
	public boolean isValidSudoku(char[][] board){
		
		int m = board.length;
		int n= board[0].length;
		
		Set<Character> rowSet = new HashSet<Character>();
		Set<Character> columnSet = new HashSet<Character>();
		Set<Character> cubeSet = new HashSet<Character>();
		
		for(int i=0;i<m;i++){
					
			for(int j=0;j<n;j++){
				
				if(board[i][j]!='.'){
					
					if(!rowSet.add(board[i][j]))
						return false;
				}
				
				if(board[j][i]!='.'){
					if(!columnSet.add(board[j][i]))
						return false;
				}
				
				int rowIndex =i/3;
				int columnIndex = i%3;
				if(board[rowIndex*3+j/3][columnIndex*3+j%3]!='.'){
					if(!cubeSet.add(board[rowIndex*3+j/3][columnIndex*3+j%3]))
						return false;
				}
				
			}
			rowSet.clear();
			columnSet.clear();
			cubeSet.clear();
			
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
