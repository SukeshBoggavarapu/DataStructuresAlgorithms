package strings;

public class WordSearch1 {
	
	public boolean wordSearch(char[][] board,String word){
		
		if(word==null)
			return false;
		
		for(int i=0;i<board.length;i++){
			
			for(int j=0;j<board[0].length;j++){
				
				if(dfs(board,i,j,word.toCharArray(),0))
					return true;
			}
		}
		
		return false;
			
	}

	private boolean dfs(char[][] board, int i, int j, char[] word,int charIndex) {
		
		char c = board[i][j];
		
		if(c=='#' || c!=word[charIndex])
			return false;
		
		if(charIndex==word.length-1)
			return true;
		
		board[i][j]='#';
		if(i>0 && dfs(board,i-1,j,word,charIndex+1))
			return true;
		else if(j>0 && dfs(board,i,j-1,word,charIndex+1))
			return true;
		else if(i<board.length-1 && dfs(board,i+1,j,word,charIndex+1))
			return true;
		else if(j<board[0].length-1 && dfs(board,i,j+1,word,charIndex+1))
			return true;
		board[i][j]=c;
		
		return false;
	}

	public static void main(String[] args) {
		
		WordSearch1 ws1 = new WordSearch1();
		System.out.println(ws1.wordSearch(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, "eat"));
	}

}
