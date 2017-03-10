package strings;

public class WordNode {
	
	int steps;
	int len;
	WordNode parent;
	String word;
	    
	public WordNode(WordNode parent,String word,int len){
	        this.word=word;
	        this.parent=parent;
	        this.len=len;
	    }
	public WordNode(String word){
		this.word=word;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}

}
