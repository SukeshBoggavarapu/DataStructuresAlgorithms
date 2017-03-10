package strings;

public class IsoMorphicStrings {
	
	public static boolean isIsomorphic(String s,String t){
		  int[] vals1 = new int[256];
	       int[] vals2 = new int[256];
	       int count=1;
	       for(int i=0;i<s.length();i++){
	           if(vals1[s.charAt(i)]!=vals2[t.charAt(i)]) return false;
	           if(vals1[s.charAt(i)]==0){
	               
	               vals1[s.charAt(i)]=count;
	               vals2[t.charAt(i)]=count;
	               count++;
	               
	           }
	       }
	       
	       return true;
	}
	
	public static void main(String[] args){
		
		System.out.println(isIsomorphic("egt","baa"));
		
	}

}
