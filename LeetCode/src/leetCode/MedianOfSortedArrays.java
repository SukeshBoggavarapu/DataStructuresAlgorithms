package leetCode;

public class MedianOfSortedArrays {
	
	public double medianOfSortedArrays(int[] array1,int[] array2){
		
		
		int len1 = array1.length;
		int len2 = array2.length;
		if(len1>len2){
			//Swapping
			return medianOfSortedArrays(array2, array1);
		}
		Vals vals = binarySearch(array1,array2,0,len1);
		
		int i = vals.i;
		int j= vals.j;
		
		double val1;
		double val2;
		
		if(i-1<0 || j-1<0)
			val1 = i-1<0 ? array2[j-1] : array1[i-1];
		else
			val1 = Math.max(array1[i-1], array2[j-1]);
		
		if(i==len1 || j ==len2){
			val2 = i==len1 ? array2[j] : array1[i];
		}else
			val2 = Math.min(array1[i], array2[j]);
		
		if((len1+len2)%2 ==0)
	    	return (val1+val2)/2;	
		else
			return val1;

	}
	
	
	public Vals binarySearch(int[] A,int[] B,int imin,int imax){
		
		
		int i = (imin+imax)/2;
		int j = (A.length+B.length+1)/2 - i;
		
		if((i==0 || j==B.length || A[i-1]<=B[j]) && 
				(j==0 || i== A.length || B[j-1]<=A[i])){
			Vals vals = new Vals(i,j);
			return vals;
		}
		
		if(i>0  && A[i-1]>B[j]){
			
			//Decrease i
			return binarySearch(A,B,imin,i-1);
			
		}
		
		if(j>0 && B[j-1]>A[i]){
			
			//Increase i
			return binarySearch(A,B,i+1,imax);
			
		}
		
		return null;
		
	}
	
	class Vals{
		
		int i;
		int j;
		public Vals(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
	
	public static void main(String[] args){
		
		MedianOfSortedArrays msa = new MedianOfSortedArrays();
		System.out.println(msa.medianOfSortedArrays(new int[]{1,2},new int[]{5,6}));
		
		
	}

}
