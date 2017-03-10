package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobber {
	
	public static int houseRobber(int[] moneyValues){
		
		if(moneyValues==null || moneyValues.length==0){
			return 0;
		}
		
		Houses[] money = new Houses[moneyValues.length];
		for(int y=0;y<moneyValues.length;y++){
			money[y]= new Houses();
		}
		int[] dp = new int[moneyValues.length];
		dp[0]=moneyValues[0];
		money[0].setVal(moneyValues[0]);
		money[0].setHouses(new ArrayList<Integer>(Arrays.asList(dp[0])));
		
		 if(moneyValues.length>1){
			dp[1]=Math.max(moneyValues[0], moneyValues[1]);
			money[1].setVal(dp[1]);
			money[1].setHouses(new ArrayList<Integer>(Arrays.asList(dp[1])));
			
				for(int i=2;i<moneyValues.length;i++){
			dp[i]= Math.max(dp[i-2]+moneyValues[i], dp[i-1]);
			if(dp[i-2]+moneyValues[i]>dp[i-1]){
				List<Integer> list = new ArrayList<Integer>();
				list.addAll(money[i-2].getHouses());
				list.add(moneyValues[i]);			
				money[i].setHouses(list);
			}else{
				money[i].setHouses(new ArrayList<Integer>(money[i-1].getHouses()));
			}
				
			}
		 }
		 
		 List<Integer> finalHouses = money[money.length-1].getHouses();
		 for(int i=0;i<finalHouses.size();i++){
			 System.out.println(finalHouses.get(i));
		 }
		
		return dp[dp.length-1];
	}
	
	public static void main(String[] args){
		
		int[] vals = new int[]{25,46,12,50,70,72,21,45,65};
		
		System.out.println(houseRobber(vals));
	}
	
	

}
