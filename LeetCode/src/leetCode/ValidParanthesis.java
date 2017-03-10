package leetCode;

import java.util.Stack;

public class ValidParanthesis {
	

    public boolean isValid(String s) {
        
        if(s.length()%2!=0)
            return false;
        Stack<Character> stk = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            
            switch(s.charAt(i)){
                case ']':
                    if(stk.pop()!='[')
                        return false;
                    break;
                case '}':
                    if(stk.pop()!='{')
                        return false;
                    break;
                case ')':
                    if(stk.pop()!='(')
                        return false;
                    break;
                default:
                    stk.push(s.charAt(i));
            }
        }
        
        return true;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
