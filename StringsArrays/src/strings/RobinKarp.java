package strings;

public class RobinKarp {
	
	
	public static boolean isSubstringMatches(String T, String p){
		
		
		int pVal =0;
		int m = p.length();
		for(int i=0;i<p.length();i++){
			pVal = pVal*10;
			pVal = pVal + Character.getNumericValue(p.charAt(i));
		}
		
		int[] tVal = new int[T.length()-m+1];
		
		
		for(int j=0;j<m;j++){	
			tVal[0] = tVal[0] *10;
			tVal[0] = tVal[0] + Character.getNumericValue(T.charAt(j));	
		}
		
		if(pVal==tVal[0])
			return true;
		
		for(int j=1;j<T.length()-m+1;j++){
			
			tVal[j]= (tVal[j-1]- ((int) Math.pow(10, m-1)*Character.getNumericValue(T.charAt(j-1))))*10 + Character.getNumericValue(T.charAt(j+m-1));
				
			if(pVal==tVal[j])
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		System.out.println(isSubstringMatches("2345678", "678"));
		
		
	}

}
