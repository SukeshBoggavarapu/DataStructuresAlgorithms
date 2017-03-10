package strings;

public class KMP {
	
	public void isStringMatch(String txt, String pat){
		
		
		int[] prefix = prefixTable(pat);
		
		int i=0;
		int j=0;
		
		while(i<txt.length()){
			
			if(txt.charAt(i)==pat.charAt(j)){
				i++;
				j++;
			}
			if(j==pat.length()){
				System.out.println("Pattern Match found at" + (i-j));
				j=prefix[j-1];
			}else if (txt.charAt(i)!=pat.charAt(j)){ // Pattern mismatch after some matches
				
				if(j>0){
					
					j=prefix[j-1];
					
				}else {
					i++;
				}				
			}			
		}
	}
	
	private int[] prefixTable(String pat){
		
		int[] prefix = new int[pat.length()];
		
		prefix[0]=0;
		int len=0;
		int i=1;
		
		while(i<pat.length()){
			
			if(pat.charAt(len)==pat.charAt(i)){				
				len++;
				prefix[i]=len;
				i++;				
			}else if(len>0){//Mismatch after some matches			
				len=prefix[len-1];
			}else {//len==0		
				prefix[i]=0;
				i++;
			}
		}
		return prefix;
	}

}
