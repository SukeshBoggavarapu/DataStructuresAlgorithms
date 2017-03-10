package arrays;

public class DuplicatesFromSortArray {
	
	
	public void removeDuplicates(int[] arr){
		
		int id=1;
		
		for(int i=1;i<arr.length;i++){
			
			if(arr[i]!=arr[i-1]){
				
				arr[id++]=arr[i];
			}
			
		}
		
		System.out.println(id);
		
	}

	public static void main(String[] args) {
		DuplicatesFromSortArray ds = new DuplicatesFromSortArray();
		ds.removeDuplicates(new int[]{1,2,3,4,4,4,5,6,7,7,8});
	}

}
