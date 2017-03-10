package greedy;

public class BinaryCharacter {
	
	char c;
	int frequency;
	BinaryCharacter left;
	public BinaryCharacter getLeft() {
		return left;
	}

	public void setLeft(BinaryCharacter left) {
		this.left = left;
	}

	public BinaryCharacter getRight() {
		return right;
	}

	public void setRight(BinaryCharacter right) {
		this.right = right;
	}

	BinaryCharacter right;
	int index;
	
	public BinaryCharacter(char c, int frequency){
		this.c=c;
		this.frequency=frequency;
	}
	
	public BinaryCharacter(){
	
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
