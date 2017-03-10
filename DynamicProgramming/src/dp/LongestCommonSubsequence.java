package dp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LongestCommonSubsequence {
	
	public static Output longestCommonSubsequence(char[] A,char[] B){
		
		//int[][] lcs = new int[A.length+1][B.length+1]; 
		Sequence[][] slcs = new Sequence[A.length+1][B.length+1];
		
		
		for (int z=0;z<A.length+1;z++){
		for(int y=0;y<B.length+1;y++){
			slcs[z][y]= new Sequence(0,'F');
		}
		}
		
		for (int i=0;i<A.length+1;i++){
			//lcs[i][0]=0;
			slcs[i][0].setVal(0);
		}
		for(int j=0;j<B.length+1;j++){
			//lcs[0][j]=0;
			slcs[0][j].setVal(0);
		}
		int p=0;
		int q=1;
		for(int m=0;m<A.length;m++){
			p++;
			for(int n=0;n<B.length;n++){
				
				if (A[m]==B[n]){
					//lcs[p][q]=1+lcs[p-1][q-1];
					slcs[p][q].setVal(1+slcs[p-1][q-1].getVal());
					slcs[p][q].setC('I');
					
				}else if(slcs[p][q-1].getVal()>=slcs[p-1][q].getVal()){
					//lcs[p][q]=lcs[p][q-1];
					slcs[p][q].setVal(slcs[p][q-1].getVal());
					slcs[p][q].setC('L');
				}else{
					//lcs[p][q]=lcs[p-1][q];
					slcs[p][q].setVal(slcs[p-1][q].getVal());
					slcs[p][q].setC('U');
				}
				q++;
			}
			q=1;
			
		}
		Output output = new Output();
		output.length=slcs[A.length][B.length].getVal();
		//System.out.println(slcs[A.length][B.length].getVal());
		
		int t=A.length;
		int s=B.length;
		StringBuffer seq = new StringBuffer();
		while(t>0 && s>0){
			
			if(slcs[t][s].getC()=='I'){
				seq.append(A[t-1]);
				 t=t-1;s=s-1;			
			}else if (slcs[t][s].getC()=='L'){
				s--;
			}else if (slcs[t][s].getC()=='U'){
				t--;
			}
		}
		output.sequence = seq.reverse().toString();
		return output;
	}
	
	public static void main(String[] args){
		
		String inputName = "input.txt";
		String outputName = "output.txt";
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			br = new BufferedReader(new FileReader(inputName));
			String[] strings = new String[2];
			int i=0;
			while(i<2){
				strings[i] = br.readLine();
				i++;
			}
			Output out = longestCommonSubsequence(strings[0].toCharArray(),strings[1].toCharArray());	
			pw = new PrintWriter(new FileWriter(outputName));
			pw.println(out.length);
			pw.println(out.sequence);
			
			br.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}

 class Sequence{
	
	int val;
	char c;
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public Sequence (int val,char c){
		
		this.val=val;
		this.c=c;
	}
	
}
 
 class Output{
	 
	 int length;
	 String sequence;
	 
 }

