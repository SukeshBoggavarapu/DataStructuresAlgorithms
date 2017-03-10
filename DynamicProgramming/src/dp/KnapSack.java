package dp;

public class KnapSack {
	
	public static int knapSack(int[] vals, int[] wts ,int maxWeight){
		
		int[][] maxValue = new int[vals.length+1][maxWeight+1];
		
		int[][] path = new int[vals.length+1][maxWeight+1];
		
		for (int i=0;i<maxWeight+1;i++){
			maxValue[0][i]=0;
			path[0][i]=-1;
		}
		
		for (int i=0;i<vals.length+1;i++){
			
			maxValue[i][0]=0;
			path[i][0]=-1;
		}
		
		for (int i=1 ;i<vals.length+1;i++){
			
			for (int j=1;j<maxWeight+1;j++){
				
				if(wts[i-1]<=j){
					
					maxValue[i][j] = Math.max(vals[i-1]+maxValue[i-1][j-wts[i-1]], maxValue[i-1][j]);
					if(vals[i-1]+maxValue[i-1][j-wts[i-1]] > maxValue[i-1][j]){
						path[i][j]=1;
					}else {
						path[i][j]=0;
					}
					
				}else {
					maxValue[i][j] = maxValue[i-1][j];
					path[i][j]=0;
				}
				
			}
		}
		
		int j = maxWeight;
		
		for(int i= vals.length; i>=0;){
				
				if(path[i][j]==1){
					System.out.println(vals[i-1]);
					j=j-wts[i-1];
					i=i-1;		
				}else if(path[i][j]==0){
					i=i-1;
				}else {
					break;
				} 			
		}
		
		return maxValue[vals.length][maxWeight];
	}
	
	
	public static void main(String[] args){
		
		
		int[] vals = new int[]{6,10,12};
		int[] wts = new int[]{1,2,3};
		int maxWeight = 5;
		System.out.println(knapSack(vals, wts, maxWeight));
	}
	

}
