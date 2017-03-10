package dpCTC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSubsets {
	
	
	public int numberOfSubsets(int n){
		
		if(n==0)
			return 1;
		if (n==1)
			return 2;
		return 2*numberOfSubsets(n-1);
		
	}
	
	public List<List<Integer>> numberOfSubsetsDp(int n){
	
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		
		if(n==0){
			return new ArrayList<>();
		}
		list.add(new ArrayList<>());
		list.add(new ArrayList<>(Arrays.asList(1)));
		if(n==1){
			return list;
		}
		
		if(n>1){
			for(int i=2;i<=n;i++){
				int size = list.size();
				for(int j=0;j<size;j++){		
					List<Integer> currentList = new ArrayList<Integer>(new ArrayList<>(list.get(j)));
					currentList.add(i);
					list.add(currentList);
				}
				
			}
			
		}
		
		return list;
		
		
	}
	
	public List<List<Integer>> getSubsets(List<Integer> listOfNums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		if(listOfNums.size()==0)
			return new ArrayList<List<Integer>>();
		
		list.add(new ArrayList<Integer>());
		
		for(int i=0;i<listOfNums.size();i++){
			
			int size = list.size();
			
			for(int j=0;j<size;j++){
				
				List<Integer> currentList = new ArrayList<Integer>(list.get(j));
				currentList.add(listOfNums.get(i));
				list.add(currentList);
			}
			
		}
		
		return list;
	}
	

	public static void main(String[] args) {
		NumberOfSubsets ns = new NumberOfSubsets();
		System.out.println(ns.numberOfSubsets(3));
		List<List<Integer>> list = ns.numberOfSubsetsDp(3);
		int sum=0;
	/*	for(int i=1;i<list.size();i++){
			
			int size = list.get(i).size();
			
			for(int j=0;j<size;j++){
				sum = sum +list.get(i).get(j);
			}
			System.out.println();
			
		}
		
		System.out.println(sum);*/
		
		List<List<Integer>> slist = ns.getSubsets(new ArrayList<Integer>(Arrays.asList(5,1,4)));
		for(int i=1;i<slist.size();i++){
			
			int size = slist.get(i).size();
			
			for(int j=0;j<size;j++){
				System.out.println(slist.get(i).get(j));
				sum = sum +slist.get(i).get(j);
			}
			System.out.println();
			
		}
		System.out.println(sum);
		
	}

}
