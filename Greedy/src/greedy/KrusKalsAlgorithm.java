package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KrusKalsAlgorithm {
	
	public static Set<Edge> minimumSpanTree(List<Edge> edges){
		
		Set<Edge> spannedEdges = new HashSet<Edge>();
		
		for(int i=0;i<edges.size();i++){
			
			Vertex v1 = edges.get(i).getVertex1();
			Vertex v2 = edges.get(i).getVertex2();
			
			if(!root(v1).equals(root(v2))){
				
				spannedEdges.add(edges.get(i));
				v1.setParent(v2.getParent());
				
			}
		}
		return spannedEdges;
	}
	
	private static Vertex root(Vertex v1) {
		if(v1.getParent().equals(v1)){
			return v1;
		}else{
			
			v1.setParent(root(v1.getParent()));
		}
		return v1.getParent();
	}

	public static void main(String[] args){
		
		Vertex a = new Vertex(null);
		a.setParent(a);
		Vertex b = new Vertex(null);
		b.setParent(b);
		Vertex c = new Vertex(null);
		c.setParent(c);
		Vertex d = new Vertex(null);
		d.setParent(d);
		Vertex e = new Vertex(null);
		e.setParent(e);
		Vertex f = new Vertex(null);
		f.setParent(f);
		Vertex g = new Vertex(null);
		g.setParent(g);
		Vertex h = new Vertex(null);
		h.setParent(h);
		Vertex i = new Vertex(null);
		i.setParent(i);
		
		
		
		Edge edge1 = new Edge(h,g,1);
		Edge edge2 = new Edge(i,c,2);
		Edge edge3 = new Edge(g,f,3);
		Edge edge4 = new Edge(c,f,4);
		Edge edge5 = new Edge(a,b,5);
		Edge edge6 = new Edge(b,c,8);
		Edge edge7 = new Edge(d,e,9);
		Edge edge8 = new Edge(e,f,10);
		Edge edge9 = new Edge(b,h,11);
		Edge edge10 = new Edge(a,h,12);
		Edge edge11 = new Edge(c,d,13);
		Edge edge12 = new Edge(d,f,14);
		
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);
		edges.add(edge6);
		edges.add(edge7);
		edges.add(edge8);
		edges.add(edge9);
		edges.add(edge10);
		edges.add(edge11);
		edges.add(edge12);
		
		Set<Edge> minSpanTreeVertex=minimumSpanTree(edges);
		
		for (Iterator<Edge> iterator = minSpanTreeVertex.iterator(); iterator.hasNext();) {
			
			Edge edge = (Edge) iterator.next();
			System.out.println(edge.getWeight());
			
		}
		
	}

}
