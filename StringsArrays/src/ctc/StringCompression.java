package ctc;

public class StringCompression {
	
	public String compressString(String s){
		
		int curCount =1;
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<s.length();i++){
			
			if(s.charAt(i)==s.charAt(i-1))
				curCount++;
			else
			{
				sb.append(s.charAt(i-1)+""+curCount);
				curCount=1;
			}
			
		}
		
		sb.append(s.charAt(s.length()-1)+""+curCount);
		
		return sb.length()<s.length() ? sb.toString() : s;
		
	}

	public static void main(String[] args) {
		StringCompression sc= new StringCompression();
		System.out.println(sc.compressString("abcddddddd"));
	}

}
