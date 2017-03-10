package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BipartiteDFS {
	
	public static Vertex v1 = new Vertex();
	public static Vertex v2 = new Vertex();
	public static Vertex v3 = new Vertex();
	public static Vertex v4 = new Vertex();
	public static Vertex v5 = new Vertex();

	public static void main(String[] args) {
		
		v1.setData("v1");
		v2.setData("v2");
		v3.setData("v3");
		v4.setData("v4");
		v5.setData("v5");
	
		v1.setDistance(0);
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
		//list2.add(v5);
		
		v2.setVertexList(list2);
		
		List<Vertex> list3 = new ArrayList<Vertex>();
		list3.add(v1);
		list3.add(v5);
		
		v3.setVertexList(list3);
		
		List<Vertex> list4 = new ArrayList<Vertex>();
		list4.add(v2);
		
		list4.add(v5);
		
		v4.setVertexList(list4);
		
		List<Vertex> list5 = new ArrayList<Vertex>();
		list5.add(v3);
		list5.add(v4);
		
		v5.setVertexList(list5);
		
		
		Stack<Vertex> stack = new Stack<Vertex>();
		Stack<Vertex> cystack = new Stack<Vertex>();
		v1.setColor(0);
		stack.push(v1);
		
		while(!stack.isEmpty()){
			
			Vertex v = stack.pop();
			int clr = v.getColor();
			if(v.getDistance()==0){
				v.setDistance(1);
				System.out.println("Explored vertex is" + v.getData());
			}
			List<Vertex> vers = v.getVertexList();
			
			for(int i=0;i<vers.size();i++){
				
				if(vers.get(i).getDistance()==0){
					vers.get(i).setColor(1-clr);
					vers.get(i).setPredecessor(v.getData());
					stack.push(vers.get(i));
					cystack.push(vers.get(i));
				}else if(vers.get(i).getDistance()!=0 && vers.get(i).getColor()==v.getColor())
				{
					
					System.out.println("Not Bipartite");
				}
				
			}
			
		}

	}

}
