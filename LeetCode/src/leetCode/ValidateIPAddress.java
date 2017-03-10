package leetCode;

public class ValidateIPAddress {
	
	public void isValidAddress(String ip){
		
		for(int i=0;i<ip.length();i++){
			
			if(ip.charAt(i)=='.'){
				checkIsValidIp4(ip);
				break;
			}else if(ip.charAt(i)==':'){
				checkIsValidIp4(ip);
				break;
			}
		}
		
	}

	public void checkIsValidIp6(String ip) {
		
	}

	public void checkIsValidIp4(String ip) {
		int i=0;
		int si =0;
		int ei = si+3;
		for (;i<ip.length();){
			int val = Integer.valueOf(ip.substring(si,ei));
		}
		
	}

}
