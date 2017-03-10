package greedy;

public class Job {

	int jobNumber;
	int startTime;
	int finishTime;
	
	public Job(int jobNumber,int startTime,int finishTime){
		
		this.jobNumber=jobNumber;
		this.startTime=startTime;
		this.finishTime=finishTime;
		
	}
	public int getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	
}
