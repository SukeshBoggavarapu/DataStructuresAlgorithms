package graphs;


import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	List<Vertex> vertices = new ArrayList<Vertex>();

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
	
	public int getSize(){
		return vertices.size();
	}
	

}
