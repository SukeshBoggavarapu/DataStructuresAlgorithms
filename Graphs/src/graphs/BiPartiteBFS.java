package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiPartiteBFS{
	
	public static Vertex v1 = new Vertex();
	public static Vertex v2 = new Vertex();
	public static Vertex v3 = new Vertex();
	public static Vertex v4 = new Vertex();
	public static Vertex v5 = new Vertex();

	
	public static void main(String[] args){
		
		v1.setData("v1");
		v2.setData("v2");
		v3.setData("v3");
		v4.setData("v4");
		v5.setData("v5");
	
		
		v1.setDistance(1);
		v2.setDistance(0);
		v3.setDistance(0);
		v4.setDistance(0);
		v5.setDistance(0);
	
		
		v1.setPredecessor(null);
		v2.setPredecessor(null);
		v3.setPredecessor(null);
		v4.setPredecessor(null);
		v5.setPredecessor(null);
	
		
		List<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
	
		Graph graph = new Graph();
		graph.setVertices(vertices);
		
		
		List<Vertex> list1 = new ArrayList<Vertex>();
		list1.add(v2);
		list1.add(v3);
		
		v1.setVertexList(list1);
		
		List<Vertex> list2 = new ArrayList<Vertex>();
		list2.add(v1);
		list2.add(v4);
	
		//add
		//list2.add(v5);
		
		v2.setVertexList(list2);
		
		List<Vertex> list3 = new ArrayList<Vertex>();
		list3.add(v1);
		list3.add(v5);
		
		//add
		//list3.add(v4);
		
		v3.setVertexList(list3);
		
		List<Vertex> list4 = new ArrayList<Vertex>();
		list4.add(v2);
		
		//add
		list4.add(v5);
	
		
		v4.setVertexList(list4);
		
		List<Vertex> list5 = new ArrayList<Vertex>();
		list5.add(v3);
		
		//add
		list5.add(v4);
		
		
		v5.setVertexList(list5);
		
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		v1.setColor(0);
		queue.add(v1);
		
		while(!queue.isEmpty()){
			
			Vertex pop = queue.poll();
			int clr = pop.getColor();
			List<Vertex> list = pop.getVertexList();
			int length = pop.getVertexList().size();
			
			for(int i=0;i<length;i++){
				if(list.get(i).getDistance()==0){
				list.get(i).setDistance(1);
				list.get(i).setPredecessor(pop.getData());
				list.get(i).setColor(1-clr);
				queue.add(list.get(i));
				}else if(list.get(i).getColor()==clr){
					
				System.out.println("Not Bipartite");
				}
			}		
		}
		
		
		
		 
		
	}
	
	
	
	
}