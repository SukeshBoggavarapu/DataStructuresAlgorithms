package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfArrays {
	
	public List<List<Integer>> permutations(List<List<Integer>> nums){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(res,new ArrayList<Integer>(),nums,new boolean[nums.size()]);
		//backtrack(res,new ArrayList<Integer>(),nums);
		return res;
		
	}
	
	public void backtrack(List<List<Integer>> res, List<Integer> temp,List<List<Integer>> nums,boolean[] used){
		
		
		if(temp.size()==nums.size()){	
			res.add(new ArrayList<Integer>(temp));
		}
		
		for(int i=0;i<nums.size();i++){
			if(used[i]) continue;
			if(i>0 && !used[i] && !used[i-1]) continue;
			used[i]=true;
			
			for(int j=0;j<nums.get(i).size();j++){
				if(temp.contains(nums.get(i).get(j))) continue;
				temp.add(nums.get(i).get(j));
				backtrack(res,temp,nums,used);
				temp.remove(temp.size()-1);
				
			}		
			used[i]=false;
		}
		
	}

	public static void main(String[] args) {
		ArrayOfArrays aoa = new ArrayOfArrays();
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(4));
		List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(6,7));
		List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(10,12,13));
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		List<List<Integer>> result = aoa.permutations(list);
		System.out.println(result);
		
	}

}
