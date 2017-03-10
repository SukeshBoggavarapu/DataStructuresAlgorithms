package dpCTC;

public class Nsteps {
	
	
	public int numberOfWaysToStairs(int n){
		
		int[] dpWays = new int[n+1];
		dpWays[0]=0;
		//One Stair
		dpWays[1]=1;
		//Two Stairs
		dpWays[2]=2;
		//Three Stairs
		dpWays[3]=4;
		
		for (int i=4;i<=n;i++){
			dpWays[n] = dpWays[n-1]+dpWays[n-2]+dpWays[n-3];
		}
		
		
		return dpWays[n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
