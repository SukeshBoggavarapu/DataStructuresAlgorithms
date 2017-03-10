package leetCode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToString {
    Map<Character,String> map1 = new HashMap<Character,String>();
	Map<Character,String> map2 = new HashMap<Character,String>();
	Map<Character,String> map3 = new HashMap<Character,String>();
    public String numberToWords(int num) {
        constructMap1(map1);
		constructMap2(map2);
		constructMap3(map3);
		
		if(num==0)
		    return "Zero";
        
		String s = String.valueOf(num);
		
		int length = s.length();
		if (length<=3)
			return helper1(s);
		else if(length<=6){
			int val = length%3;
			if(val==0){
			val=3;
			}
			String fh =helper1(s.substring(0, val)) + " Thousand";
			String sh = helper1(s.substring(val));
			if(!sh.isEmpty())
			    return fh+" "+sh;
			else
			    return fh;
		}else if(length<=9){
			int val = length%3;
			if(val==0){
			val=3;
			}
			String fh =helper1(s.substring(0, val)) + " Million";
			String sh = helper1(s.substring(val,val+3));
			if(!sh.isEmpty())
				sh = sh + " Thousand";
			String th = helper1(s.substring(val+3));
			String returned = fh;
			if(!sh.isEmpty())
			    returned = returned + " "+sh;
			if(!th.isEmpty())
			    returned = returned + " "+th;
			return returned;
			    
		}else {
			int val = length%3;
			if(val==0){
			val=3;
			}
			String fh =helper1(s.substring(0, val)) + " Billion";
			String sh = helper1(s.substring(val,val+3));
			if(!sh.isEmpty())
			   sh= sh + " Million";
			String th = helper1(s.substring(val+3 , val+6));
			if(!th.isEmpty())
			   th= th + " Thousand";
			String foh = helper1(s.substring(val+6));
			String returned =fh;
			if(!sh.isEmpty())
			    returned = returned+" "+sh;
			if(!th.isEmpty())
			    returned = returned +" "+th;
			if(!foh.isEmpty())
			    returned = returned + " "+foh;
			return returned;
		}
    }
    public String oneDigit(String s1){
		return map1.get(s1.charAt(0));
	}
	
	public String twoDigit(String s1){
		
		if(s1.charAt(0)=='1'){
			return map2.get(s1.charAt(1));		
		}else {
			String fh = map3.getOrDefault(s1.charAt(0),"");
			String sh = map1.getOrDefault(s1.charAt(1), "");
			if(!fh.isEmpty() && !sh.isEmpty())
			    return fh+" "+sh;
			else if(sh.isEmpty())
			    return fh;
			else 
			    return sh;
		}
	}
	
	public String threeDigit(String s1){
		
		String fh =map1.getOrDefault(s1.charAt(0), "");
		if(!fh.isEmpty()){
			fh=fh+" Hundred";
		}
		String sh = twoDigit(s1.substring(1));
		if(!sh.isEmpty() && !fh.isEmpty())
		    return fh+" "+sh;
		else if(sh.isEmpty())
		    return fh;
		else
		    return sh;
	}
	
	public String helper1(String s1){
		
		if(s1.length()==1){
			return oneDigit(s1);
		}else if (s1.length()==2){
			return twoDigit(s1);
		}else {	
			return threeDigit(s1);
		}	
	}
	
	public void constructMap3(Map<Character, String> map3) {
		
		map3.put('2', "Twenty");
		map3.put('3', "Thirty");
		map3.put('4', "Forty");
		map3.put('5', "Fifty");
		map3.put('6', "Sixty");
		map3.put('7', "Seventy");
		map3.put('8', "Eighty");
		map3.put('9', "Ninety");
	}

	public void constructMap2(Map<Character, String> map2) {
		
		map2.put('0', "Ten");
		map2.put('1', "Eleven");
		map2.put('2', "Twelve");
		map2.put('3', "Thirteen");
		map2.put('4', "Fourteen");
		map2.put('5', "Fifteen");
		map2.put('6', "Sixteen");
		map2.put('7', "Seventeen");
		map2.put('8', "Eighteen");
		map2.put('9', "Nineteen");
		
	}

	public void constructMap1(Map<Character, String> map1) {
		
		map1.put('1', "One");
		map1.put('2', "Two");
		map1.put('3', "Three");
		map1.put('4', "Four");
		map1.put('5', "Five");
		map1.put('6', "Six");
		map1.put('7', "Seven");
		map1.put('8', "Eight");
		map1.put('9', "Nine");
		
	}
	
	//Integer to String Better Solution
	public class Solution {
	    
	    public String[] lessThan20 = new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	    public String[] tens = new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	    public String[] thousands = new String[]{"","Thousand","Million","Billion"};
	    
	    public String numberToWords(int num) {
	  
	        if(num==0)
	            return "Zero";
	        
	        String words = "";
	        int i=0;
	        while(num>0){
	            
	            if(num%1000!=0)
	                words = helper(num%1000) + thousands[i] + " " +words;
	            num=num/1000;
	            i++;
	            
	        }
	        
	        return words.trim();
	        
	    }
	    
	    public String helper(int num){
	        
	        if(num==0)
	            return "";
	        if(num<20)
	            return lessThan20[num] + " ";
	        else if(num<100)
	            return tens[num/10] +" "+ helper(num%10);
	        else
	            return lessThan20[num/100] + " Hundred " + helper(num%100);
	        
	    }	
	}
	
}