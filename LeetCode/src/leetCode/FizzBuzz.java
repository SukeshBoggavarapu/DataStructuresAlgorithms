package leetCode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	
public static List<String> fizzBuzz(int n) {
        
        List<String> list = new ArrayList<String>();
        for(int i=1;i<n+1;i++){
            
            if(i%3!=0 && i%5 !=0)
            list.add(i+"");
            else if(i%3==0 && i%5!=0)
            list.add("Fizz");
            else if(i%3!=0 && i%5 ==0)
            list.add("Buzz");
            else if(i%3 ==0 && i%5 ==0)
            list.add("FizzBuzz");
            
        }
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz(9);
	}

}
