package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Permutations {
	
	public List<List<Integer>> permutations(int[] nums){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		//For Duplicates
		backtrack(res,new ArrayList<Integer>(),nums,new boolean[nums.length]);
		//backtrack(res,new ArrayList<Integer>(),nums);
		return res;
		
		
	}
	public void backtrack(List<List<Integer>> res , List<Integer> tempList , int[] nums ,boolean[] used){
	//public void backtrack(List<List<Integer>> res , List<Integer> tempList , int[] nums){
		
		if(tempList.size()==nums.length)
			res.add(new ArrayList<Integer>(tempList));
		
		for(int i=0;i<nums.length;i++){
			
			/*if(tempList.contains(nums[i]))
				continue;*/
			//Duplicates
			if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) continue; 
			used[i] =true;
			tempList.add(nums[i]);
			//backtrack(res,tempList,nums);
			backtrack(res,tempList,nums,used);
			used[i] = false;
			tempList.remove(tempList.size()-1);
			
		}
	}

	public static void main(String[] args) {
		Permutations pm = new Permutations();
		pm.permutations(new int[]{5,5,6});
		/*String[] strs = new String[]{"Jacks","Kate","Locke"};
		Set<String> set = new HashSet<String>(Arrays.asList(strs));*/
		/*set.add("Sukesh");
		set.add("Jack");
		set.add("Jackson");*/
	
		//set.forEach(System.out :: println);
		/*Iterator<String> itr = set.iterator();
		while(itr.hasNext()){
			String str = itr.next();
			if(str=="Sukesh")
				itr.remove();
			else
				System.out.println(str);
		}*/
		
		/*for(String strs : set){
			if(strs=="Sukesh")
				set.remove(strs);
			else
				System.out.println(strs);
		}*/
		
	}

}
