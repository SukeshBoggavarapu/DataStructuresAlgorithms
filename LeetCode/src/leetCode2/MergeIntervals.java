package leetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	

    public List<Interval> merge(List<Interval> intervals) {
    	
    	sort(intervals);
        List<Interval> res = new ArrayList<Interval>();
        
        if(intervals==null || intervals.size()==0)
            return res;
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        if(intervals.size()==1){
            res.add(new Interval(start,end));
            return res;
        }
        
        for(int i=1;i<intervals.size()-1;i++){
            
            if(intervals.get(i).start<=end){
                end=Math.max(end,intervals.get(i).end);
            }else{
                Interval period = new Interval(start,end);
                res.add(period);
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
            
        }
        
        res.add(new Interval(start,end));
        
        return res;
        
    }
    
    public void sort(List<Interval> intervals){
    	
    	Collections.sort(intervals, new myComp());
    }
    
    public class myComp implements Comparator<Interval>{

		@Override
		public int compare(Interval i1, Interval i2) {
			// Returns Ascending Order
			return i1.start -i2.start;
		}
    	
    }
    

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		mi.merge(new ArrayList<Interval>(Arrays.asList(new Interval(1,4),new Interval(0,4))));;
	}

}

 class Interval {
    int start;
   int end;
  Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


