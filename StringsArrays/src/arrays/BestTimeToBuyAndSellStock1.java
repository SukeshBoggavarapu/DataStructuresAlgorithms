package arrays;

public class BestTimeToBuyAndSellStock1 {
	

    public int maxProfit(int[] prices) {
        
        if(prices==null || prices.length==0)
            return 0;
        
        int min = prices[0];
        int profit=0;
        int maxProfit=0;
        
        for(int i=1;i<prices.length;i++){
            
            if(prices[i]>min){
                
                profit = prices[i]-min;
                if(profit>maxProfit)
                    maxProfit= profit;
                
            }else {
                min=prices[i];
            }
            
        }
        
        return maxProfit;
        
    }

}
