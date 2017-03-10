package greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntervalScheduling {
	
	public static Job[] c ;

	
	public static Set<Integer> scheduleJobs(Job[] jobs){
		
		c = new Job[jobs.length];
		
		Job[] jobsSorted = mergeSort(jobs);
		
		Set<Integer> jobsScheduled = new HashSet<Integer>();
		
		int f=0;
		
		for(int i=0;i<jobsSorted.length;i++){
			
			if(jobs[i].getStartTime()>=f){			
				jobsScheduled.add(jobs[i].getJobNumber());
				f=jobs[i].getFinishTime();
			}
			
		}
		
		return jobsScheduled;
		
		
	}

	private static Job[] mergeSort(Job[] jobs) {
		
		if(jobs.length==1){
			return jobs;
		}
		
		int size = jobs.length;
		
		
		Job[] j1 = Arrays.copyOfRange(jobs, 0, size/2);
		Job[] j2 = Arrays.copyOfRange(jobs, size/2, size);
		
		j1=mergeSort(j1);
		j2=mergeSort(j2);
		return merge(j1,j2);
	}

	private static Job[] merge(Job[] a, Job[] b) {
		  int size = a.length+b.length;
		    Job[] c = new Job[size];
		    
		   
		    int i =0 ; int j=0;int k=0;
		    
		    while(i<a.length && j<b.length){
		    
		      if(a[i].getFinishTime()<b[j].getFinishTime()){
		        
		        c[k]=(a[i]);
		        i++;
		        k++;
		      }else{
		      c[k]=(b[j]);
		        j++;
		        k++;
		              }
		    
		      if(i==a.length){
		      
		        while(j<b.length){
		        
		        c[k]=b[j];
		          j++;
		          k++;
		        }
		        break;
		      } else if(j==b.length){
		       while(i<a.length){
		        
		         c[k]=a[i];
		          i++;
		          k++;
		        }
		        break;
		      }   
		      
		    }
		    
		    return c; 
		  }
	
	
	
	public static void main(String[] args){
		
		Job job1 = new Job(1,0,3);
		Job job2 = new Job(2,0,4);
		Job job3 = new Job(3,2,4);
		Job job4 = new Job(4,3,5);
		Job job5 = new Job(5,4,6);
		Job job6 = new Job(6,4,7);
		Job job7 = new Job(7,5,8);
		Job job8 = new Job(8,7,9);
		Job job9 = new Job(9,8,9);
		
		Job[] jobs = new Job[]{job1,job2,job3,job4,job5,job6,job7,job8,job9};
		
		Set<Integer> jobsScheds =  scheduleJobs(jobs);
		
		for (Iterator iterator = jobsScheds.iterator(); iterator.hasNext();) {
			
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
			
		}
		
	}
	
	
	
	
	
	}

