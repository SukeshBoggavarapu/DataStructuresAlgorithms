package graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	String data;
	int distance;
	String predecessor;
	Vertex pred;
	int vertexNumber;
	public Vertex getPred() {
		return pred;
	}

	public void setPred(Vertex pred) {
		this.pred = pred;
	}

	List<Vertex> vertexList = new ArrayList<Vertex>();
	int color;
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(String predecessor) {
		this.predecessor = predecessor;
	}

	
}
