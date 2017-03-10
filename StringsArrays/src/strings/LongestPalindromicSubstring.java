package strings;

public class LongestPalindromicSubstring {
	
	int startIndex;
	int max =0;
	
	
	public String longestPalindromicSubstring(String s){
		
		for (int i=0;i<s.length()-1;i++){
			
			//Odd case
			extendPalindrome(s,i,i);
			//Even case
			extendPalindrome(s,i,i+1);	
			
		}
		return s.substring(startIndex, startIndex+max);
	}
	
	public void extendPalindrome(String s, int start,int end){
		
		
		while(start>=0 && end <s.length() && s.charAt(start)==s.charAt(end)){
			
			start--;
			end++;
		}
		
		
		if(max<end-start-1){
			max = end -start-1;
			startIndex = start+1;
		}
		
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindromicSubstring("babad"));
	}

}
