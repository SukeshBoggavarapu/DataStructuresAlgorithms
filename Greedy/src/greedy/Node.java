package greedy;

public class Node {
	
	public int parent;
	String color;	
	String name;	
	int vertexNumber;
	double keyValue;
	int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Node(int parent,String color,int vertexNumber,double keyValue){
		
		this.parent=parent;
		this.color=color;
		this.vertexNumber=vertexNumber;
		this.keyValue=keyValue;
	}

	public double getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(double keyValue) {
		this.keyValue = keyValue;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public void setVertexNumber(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

}
