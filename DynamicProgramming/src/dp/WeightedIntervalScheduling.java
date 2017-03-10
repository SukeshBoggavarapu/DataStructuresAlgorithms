package dp;

public class WeightedIntervalScheduling {
	
	
	public static int weightedIntervalSchedule(int[] st, int[] ft ,int[] vals,int start ,int finish){
		
		
		int[] maxWeightDP = new int[st.length+1];
		
		maxWeightDP[0] = 0;
		
		int[] parent = new int[st.length];
		
		for(int i=0;i<st.length;i++){
		
				int val = binarySearch(ft,st[i]);
					parent[i] = val;
		}
		
		
		
		for(int i=1;i<maxWeightDP.length;i++){
			
			maxWeightDP[i] = Math.max(vals[i-1]+ maxWeightDP[parent[i-1]],maxWeightDP[i-1]);

		}
		
		
		return maxWeightDP[maxWeightDP.length-1];
		
		
		
	}

	private static int binarySearch(int[] ft, int i) {
		
		return  binarySearchForParent(ft,0,ft.length-1,i);
	}

	private static int binarySearchForParent(int[] ft, int i, int j, int val) {
		
		if(i>j)
			return i;
		
		if(i==j && val>ft[i]){
			return i==0 ? 0 : i;
		}else if(i==j && val<ft[i])
			return i==0 ? 0 : i-1;
		
		int mid = (i+j)/2;
		
		if(val<ft[mid]){
			return binarySearchForParent(ft,i,mid-1,val);
		}else if(val>ft[mid]){
			return binarySearchForParent(ft,mid+1,j,val);	
		}else if(val==ft[mid])
			return mid+1;
		
		return 0;
	}
	
	
	public static void main(String[] args){
		
		int[] st = new int[]{0,0,2,3,4,4,5,7,8};
		int[] ft = new int[]{3,4,4,5,6,7,8,9,9};
		int[] vals = new int[]{80,100,90,25,50,70,80,50,30};
		int start =0;
		int finish = 9;
		
		System.out.println(weightedIntervalSchedule(st, ft, vals, start, finish));
		
	}
	

}
