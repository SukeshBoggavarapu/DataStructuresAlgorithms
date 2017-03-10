package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BlackRock2 {
	final String SELL="SELL";

	public static String blackRock2(String s) {

		StringBuffer sb = new StringBuffer();
		//Change 1
		Map<String, Double[]> map = new TreeMap<String, Double[]>();
		int startIndex = 0;
		int startIndexBMQuantity=0;
		int endIndexBMQuantity=0;
		int endIndex1 = 0;
		int endIndex2=0;int endIndex=0;
		int j = 0;
		int i = 0;	
		int commaCount = 0;
		String s2 = s.substring(s.indexOf(":") + 1);
		int len1=s.indexOf(":");
		double sumNAVTicker =0;
		double sumNAVBM =0;
		while (i < len1 && j < s2.length()) {

			if (s.charAt(i) == ',' && commaCount == 0) {
				endIndex = i ;
				commaCount++;
				i++;
				j++;
			} else if ((s.charAt(i) == ',' || s2.charAt(j)==',') && commaCount == 1) {
				//Change to not equal to
				while(s.charAt(i)!=',')
					i++;
				endIndex1=i;
				//Change 2
				while(commaCount!=3){
					while(s2.charAt(j)!=',')
						j++;
					j++;
					if(commaCount==1)
						startIndexBMQuantity=j;
					else if(commaCount==2)
						endIndexBMQuantity=j-1;
					commaCount++;
				}
				endIndex2=j;
				//end
				while (i != len1 && s.charAt(i) != '@') {
					i++;
				}
				//Look here
				double val1 = Double.parseDouble(s.substring(endIndex1 + 1, i));
				while (j != s2.length() && s2.charAt(j) != '@') {
					j++;
				}
				//Change 3
				double val2 = Double.parseDouble(s2.substring(startIndexBMQuantity, endIndexBMQuantity));
				double val3 = Double.parseDouble(s2.substring(endIndex2, j));
				//Change 4
				Double[] vals = new Double[3];
				vals[0] = val1;
				vals[1]=val2;
				vals[2]= val3;
				sumNAVTicker = sumNAVTicker+ val1*val3;
				sumNAVBM = sumNAVBM+val2*val3;
				map.put(s.substring(startIndex, endIndex), vals);
				//end
				commaCount = 0;
				startIndex=i+1;
				
			} else {
				i++;
				j++;
			}
		}
		//Change 5
		
		/*for(Map.Entry<String[], Double[]> entry : map.entrySet()){
			sumNAV = sumNAV+ entry.getValue()[2];
		}*/
		//Change 6
		for(Map.Entry<String, Double[]> entry : map.entrySet()){
			double quantity = ((((entry.getValue()[1]*entry.getValue()[2])*sumNAVTicker)/sumNAVBM)/entry.getValue()[2])-entry.getValue()[0];
			sb.append("[");
			if(quantity>0){
				sb.append("BUY"+", "+entry.getKey() + ", "+String.format("%.2f", quantity));
			}else{
				sb.append("SELL"+", "+entry.getKey() + ", "+String.format("%.2f", quantity));
			}
			/*sb.append("[" + entry.getKey()[0]+", "+entry.getKey()[1]+", "
					+String.format("%.2f", entry.getValue()[0])+", "+String.format("%.2f", entry.getValue()[1])+", "+String.format("%.2f", (entry.getValue()[2]/sumNAV)));*/
			sb.append("], ");
		}
		sb.delete(sb.length() - 2,sb.length());
		System.out.println("---"+sumNAVTicker);
		System.out.println("---"+sumNAVBM);
		return sb.toString();

	}
	
	

	public static void main(String[] args) {
		BlackRock2 bc2 = new BlackRock2();
		/*String[] strs = new String[2];
		strs[0]=s.substring(startIndex, endIndex);
		strs[1]=s.substring(endIndex+1, endIndex1+1);*/
		/*
		 * String s= "Hello:World";
		 * 
		 * System.out.println(s.indexOf(":"));
		 */
		//[SELL, vodaphone ,290],[],[]
		//"VOD,Vodaphone,300@AIR,Airtel,23@CRI,cricket,15:VOD,Vodaphone,10,23@AIR,Airtel,330,35.6@CRI,cricket,155,13.2"
		//"VOD,Vodaphone,300@AIR,Airtel,23@CRI,cricket,15:VOD,Vodaphone,10@AIR,Airtel,330@CRI,cricket,155"
		System.out.println(bc2.blackRock2(
				"VOD,Vodaphone,10@AIR,Airtel,15@CRI,cricket,12:VOD,Vodaphone,16,2@AIR,Airtel,10,5@CRI,cricket,25,6"));
		
	}
}
class tickerComp implements Comparator<String[]>{

	@Override
	public int compare(String[] o1, String[] o2) {
		// TODO Auto-generated method stub
		return o1[0].compareTo(o2[0]);
	}
	
}
