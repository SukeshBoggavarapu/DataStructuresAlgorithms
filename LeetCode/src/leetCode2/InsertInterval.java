package leetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)
            return newInterval==null ? res : new ArrayList<Interval>(Arrays.asList(newInterval));
        if(newInterval==null)
            return intervals;
        
        int start = newInterval.start;
        int end= newInterval.end;
        
        Interval temp = new Interval();
        int i=0;
        boolean isStartDone = false;
        for(;i<intervals.size();i++){
           int curStart = intervals.get(i).start;
           int curEnd = intervals.get(i).end;
           if(!isStartDone){ 
            //For Start
            if(start>curEnd){
                res.add(intervals.get(i));
            }else if(start>=curStart && start<=curEnd){
                temp.start=curStart;
                isStartDone = true;
            }else if(start<curStart){
                temp.start=start;
                isStartDone=true;
            }
           }
           if(isStartDone){
           if(end<curStart){
               temp.end=end;
               res.add(temp);
               res.add(intervals.get(i));
               i++;
               break;
           }else if(end>=curStart && end<=curEnd){
               temp.end=curEnd;
               res.add(temp);
               i++;
               break;
           }else if(end>curEnd){
               if(i==intervals.size()-1){
                   temp.end=end;
                res.add(temp);
                i++;
               }
           }
           }
        }
        
        for(;i<intervals.size();i++){
            res.add(intervals.get(i));
        }
        if(!isStartDone)
            res.add(newInterval);
        
        return res;
        
    }



	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		ii.insert(new ArrayList<Interval>(Arrays.asList(new Interval(1,5))), new Interval(2,3));
	}

}
