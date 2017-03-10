package dp;

public class PaintHouses {
	
	
	public int paintHouses(int[][] costs){
		
		if(costs==null || costs.length==0)
			return 0;
		
		int houses = costs.length;
		int colors = costs[0].length;
		
		int[][] paintCosts = new int[houses][colors];
		
		//For 1st house
		int min =Integer.MAX_VALUE;
		for(int i=0;i<colors;i++){
			paintCosts[0][i]=costs[0][i];
			if(paintCosts[0][i]<min)
				min = paintCosts[0][i];
		}
		
		if(houses==1)
			return min;
		int totalCost =0;
		for(int i=1;i<houses;i++){
			totalCost =Integer.MAX_VALUE;
			for(int j=0;j<colors;j++){
				
				paintCosts[i][j]= Math.min(paintCosts[i-1][(j+1)%3]+costs[i][j], paintCosts[i-1][(j+2)%3]+costs[i][j]);
				if(paintCosts[i][j]<totalCost)
					totalCost = paintCosts[i][j];
			}
		}
		
		
		return totalCost;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
