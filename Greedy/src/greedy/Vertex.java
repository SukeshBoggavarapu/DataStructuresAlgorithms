package greedy;

import java.util.List;

public class Vertex {
	
	//For Kruskals
	public Vertex  parent;
	
	//ForPrims
	List<Edge> edgesFormed;
	
	String color;
	
	String name;
	
	int vertexNumber;
	
	public int getVertexNumber() {
		return vertexNumber;
	}

	public void setVertexNumber(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

	double key;
	
	public Vertex(String name,Vertex parent,String color,double key){
		
		this.name=name;
		this.parent=parent;
		this.color=color;
		this.key=key;
	}
	
public Vertex(int vertexNumber,Vertex parent,String color,double key){
		
		this.vertexNumber=vertexNumber;
		this.parent=parent;
		this.color=color;
		this.key=key;
	}

	public double getKey() {
		return key;
	}

	public void setKey(double key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public List<Edge> getEdgesFormed() {
		return edgesFormed;
	}

	public void setEdgesFormed(List<Edge> edgesFormed) {
		this.edgesFormed = edgesFormed;
	}

	public Vertex(Vertex parent){
		this.parent=parent;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	

}
