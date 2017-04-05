package edu.nyu.cs9053.homework8;

import java.util.Date;
import java.util.ArrayList;

/**
 * Created by yzwang on 2017/4/1.
 */
public class LambdaScheduler {

    ArrayList<Date> jobsStartTime = new ArrayList<>();
    ArrayList<Date> jobsFinishTime = new ArrayList<>();
    ArrayList<Job> resultScheduler = new ArrayList<>();
    ArrayList<Job> scheduler = new ArrayList<>();

    //add Job objects
    public ArrayList<Job> addJob(Job...jobs) {
        for (Job job : jobs) {
            if (job == null || jobs.length < 1) {
                System.out.println("invalid input");
            } else scheduler.add(job);
        }
        return scheduler;
    }

    public ArrayList<Job> jobSelected(ArrayList<Job> scheduler){

        //bubble sort scheduler by Date type finishTime
        for(int i=0;i<scheduler.size();i++){
            for(int j=0;j<scheduler.size()-1-i;j++){
                Job temp;
                if ((scheduler.get(j)).getFinishTime().compareTo(scheduler.get(j).getFinishTime()) > 0) {
                    temp = scheduler.get(j);
                    scheduler.set(j, scheduler.get(j));
                    scheduler.set(j, temp);
                }
            }
        }
        //as same order as ArrayList scheduler, add Date type startTime and finishTime in ArrayList
        for (int i = 0; i<scheduler.size(); i++) {
                jobsStartTime.add(scheduler.get(i).getStartTime());
                jobsFinishTime.add(scheduler.get(i).getFinishTime());
            }

        resultScheduler.add(scheduler.get(0));

        //greedy selection algorithm
        int k = 0;
        for (int i = 1; i < scheduler.size()-1; i++){
            if(jobsStartTime.get(i).before(jobsFinishTime.get(k))){
                resultScheduler.add(scheduler.get(i));
                k = i;
            }
        }
        return resultScheduler;
    }

    //return and print the size result
    public int resultSchedulerSize(ArrayList<Job> resultScheduler){
        System.out.println(resultScheduler.size());
        return resultScheduler.size();
    }
}
