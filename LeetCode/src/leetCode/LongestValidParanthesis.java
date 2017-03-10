package leetCode;

import java.util.Stack;

public class LongestValidParanthesis {
	//Non-DP solution
	public int longestValidParanthesis(String s){
		
		Stack<Integer> stk = new Stack<Integer>();
		for(int i=0;i<s.length();i++){
			
			if(s.charAt(i)=='(')
				stk.push(i);
			else if(s.charAt(i)==')'){
				if(!stk.isEmpty() && s.charAt(stk.peek())=='(')
					stk.pop();
				else
					stk.push(i);
			}
		}
		
		if(stk.isEmpty()) return s.length();
		int a=s.length();
		int b=0;
		int curMax=0;
		int max=0;
		while(!stk.isEmpty()){
			b= stk.pop();
			curMax = a-b-1;
			if(max<curMax)
				max=curMax;
			a=b;
		}
		if(max<a)
			max=a;
	return max;
		
	}
	
	public int longestValidParanthesisDP(String s){
		
		int[] dp = new int[s.length()];
		dp[0]=0;
		int max=0;
		
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==')'){
				if(s.charAt(i-1)=='('){
					dp[i]=dp[i-2]+2;
					max = Math.max(max, dp[i]);
				}	
				else if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
					dp[i]=dp[i-2]+2+(i-dp[i-1]-2>=0 ? dp[i-dp[i-1]-2] : 0);
					max = Math.max(max, dp[i]);
					}
				}
		}
		
		return max;
	}

	public static void main(String[] args) {
		LongestValidParanthesis lvp = new LongestValidParanthesis();
		//System.out.println(lvp.longestValidParanthesis("((())())))))"));
		System.out.println(lvp.longestValidParanthesisDP(")()()))"));
	}

}
