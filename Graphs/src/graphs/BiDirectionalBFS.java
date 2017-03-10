package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiDirectionalBFS {
	
	public static Vertex v1 = new Vertex();
	public static Vertex v2 = new Vertex();
	public static Vertex v3 = new Vertex();
	public static Vertex v4 = new Vertex();
	public static Vertex v5 = new Vertex();
	public static Vertex v6 = new Vertex();
	public static Vertex v7 = new Vertex();
	public static Vertex v8 = new Vertex();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		v1.vertexNumber=1;
		v2.vertexNumber=2;
		v3.vertexNumber=3;
		v4.vertexNumber=4;
		v5.vertexNumber=5;
		v6.vertexNumber=6;
		v7.vertexNumber=7;
		v8.vertexNumber=8;
		
		List<Vertex> list1 = new ArrayList<Vertex>();
		list1.add(v2);
		list1.add(v3);
		
		v1.setVertexList(list1);
		
		List<Vertex> list2 = new ArrayList<Vertex>();
		list2.add(v1);
		//list2.add(v4);
		list2.add(v3);
		//list2.add(v5);
		
		v2.setVertexList(list2);
		
		List<Vertex> list3 = new ArrayList<Vertex>();
		list3.add(v1);
		//list3.add(v5);
		list3.add(v2);
		list3.add(v7);
		list3.add(v8);
		
		v3.setVertexList(list3);
		
		List<Vertex> list4 = new ArrayList<Vertex>();
		list4.add(v2);
		list4.add(v5);
		
		v4.setVertexList(list4);
		
		List<Vertex> list5 = new ArrayList<Vertex>();
		//list5.add(v3);
		//list5.add(v2);
		//list5.add(v4);
		list5.add(v6);
		
		v5.setVertexList(list5);
		
		
		List<Vertex> list6 = new ArrayList<Vertex>();
		list6.add(v5);

		v6.setVertexList(list6);

		List<Vertex> list7 = new ArrayList<Vertex>();
		list7.add(v3);
		list7.add(v8);

		v7.setVertexList(list7);
		
		List<Vertex> list8 = new ArrayList<Vertex>();
		list8.add(v3);
		list8.add(v7);
		v8.setVertexList(list8);
		
		Queue<Vertex> search1 = new LinkedList<Vertex>();
		v1.setColor(1);
		search1.offer(v1);
		
		Queue<Vertex> search2 = new LinkedList<Vertex>();
		v6.setColor(-1);
		search2.offer(v6);
		boolean isMet = false;
		Vertex up =null;
		Vertex down =null;
		Vertex curVertexUp =null;
		Vertex curVertexDown = null;
		int countFromUp=0;
		int countFromDown=0;
		while(!search1.isEmpty() && !search2.isEmpty()){
			
			up = search1.poll();
			List<Vertex> listUp = up.getVertexList();
			
			for(int i=0;i<listUp.size();i++){
				
				curVertexUp = listUp.get(i);
				if(curVertexUp.color!=1){
				if(curVertexUp.color==-1){
					isMet=true;
					break;
				}
				curVertexUp.color=1;
				curVertexUp.pred=up;
				search1.offer(curVertexUp);
				}
			}
			countFromUp+=1;
			
			if(isMet)
				break;
			else
				up=null;
			
			down = search2.poll();
			List<Vertex> listDown = down.getVertexList();
			
			for(int j=0;j<listDown.size();j++){
				curVertexDown = listDown.get(j);
				if(curVertexDown.color!=-1){
				
				if(curVertexDown.color==1){
					isMet=true;
					break;
				}
				curVertexDown.color=-1;
				curVertexDown.pred=down;
				search2.offer(curVertexDown);
				}	
				
			}
			countFromDown+=1;
			
			if(isMet)
				break;
			else
				down=null;
			
		}
		
		if(isMet){
		if(up==null){
			up=down;
			curVertexUp=curVertexDown;
		}
		System.out.println(up.vertexNumber);
		while(up.pred!=null){
			
			System.out.println(up.pred.vertexNumber);
			up=up.pred;
			
		}
		System.out.println(curVertexUp.vertexNumber);
		while(curVertexUp.pred!=null){
			System.out.println(curVertexUp.pred.vertexNumber);
			curVertexUp=curVertexUp.pred;
		}
			
		
		System.out.println(countFromUp+countFromDown);
		}else
			System.out.println("No Link");
		
		
		
		
	}

}
