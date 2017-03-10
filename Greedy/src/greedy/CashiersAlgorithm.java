package greedy;

import java.util.HashMap;
import java.util.Map;

import sorts.MergeSort;



public class CashiersAlgorithm {
	
	public static Map<Integer,Integer> minCoins(int A , int c1, int c2, int c3, int c4, int c5){
		
		int[] coins = new int[]{c1,c2,c3,c4,c5};
		
		MergeSort.mergeSort(coins);
		
		
		Map<Integer,Integer> resultSet = new HashMap<Integer,Integer>();
		
		if(A<coins[coins.length-1]){
			
			System.out.println("No solution");
		} 
		int i=0;
		int k=0;
		
		while(A>0){
					
				if(A>=coins[i]){		
					A=A-coins[i];
					resultSet.put(coins[i],++k);		
				}else {
					i++;
					k=0;
				}
		}
		
		
		return resultSet;
		
	}

	public static void main(String[] args){
		
		Map<Integer,Integer> coinsSized = minCoins(19,2,10,1,20,5);
	
		for (Integer val : coinsSized.keySet()) {
			
			System.out.println("Coin is "+ val + " -- Used :" + coinsSized.get(val));
			
		}
		
		
		
		
	}

}
