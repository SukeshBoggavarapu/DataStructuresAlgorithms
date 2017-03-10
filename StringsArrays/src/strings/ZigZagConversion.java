package strings;

public class ZigZagConversion {
	
	public String zigZagConversion(String s,int numRows){
		
		StringBuffer[] sb = new StringBuffer[numRows];
		for(int i=0;i<sb.length;i++)
			sb[i] = new StringBuffer();
		int i=0;
		
		while(i<s.length()){
		for(int idx=0;idx<numRows && i<s.length();idx++){		
			sb[idx].append(s.charAt(i++));	
		}
		
		for(int idx = numRows-2;idx>=1&&i<s.length();idx--){
			sb[idx].append(s.charAt(i++));
		}
		}
		
		for(int idx=1;idx<numRows;idx++){	
			sb[0].append(sb[idx]);
		}
		return sb[0].toString();
	}

	public static void main(String[] args) {
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.zigZagConversion("PAYPALISHIRING", 3));
	}

}
