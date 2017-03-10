package leetCode2;

public class CountAndSay {
	
	 public String countAndSay(int n) {
		 
		 if(n==1)
			 return "1";
	     
		 String s = "11";
		 
		 for(int i=2;i<n;i++){
			 
			 StringBuffer sb = new StringBuffer();
			 int j=0;
			 while(j<=s.length()-1)
			 {
				 int curCount =1;
				 while(j<s.length()-1 && s.charAt(j)==s.charAt(j+1)){
					 curCount++;
					 j++;
				 }
				 if(j==s.length()-1){
					 if(s.charAt(j)==s.charAt(j-1))
						sb.append(curCount+""+s.charAt(j));
					 else
						sb.append(1+""+s.charAt(j));
				 }else
					 sb.append(curCount+""+s.charAt(j));
				 curCount=1;
				 j++;
			 }
			 s=sb.toString();	
		 }
		 
		 return s;
		 
	    }
	 

	public static void main(String[] args) {
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(3));
	}

}
