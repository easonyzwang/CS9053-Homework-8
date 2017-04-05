package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by yzwang on 2017/4/1.
 */

public class LambdaWeightedScheduler {

    private ArrayList<Job> scheduler = new ArrayList<>();

    //add Job objects
    public ArrayList<Job> addJob(Job...jobs) {
        for (Job job : jobs) {
            if (job == null || jobs.length < 1) {
                System.out.println("invalid input");
            } else scheduler.add(job);
        }
        return scheduler;
    }

    public int weightedJobSelection (ArrayList<Job> scheduler) {
        //bubble sort scheduler by Date type finishTime
        for(int i = 0;i<scheduler.size();i++){
            for(int j = 0;j<scheduler.size()-1-i;j++){
                Job temp;
                if ((scheduler.get(j)).getFinishTime().compareTo(scheduler.get(j).getFinishTime()) > 0) {
                    temp = scheduler.get(j);
                    scheduler.set(j, scheduler.get(j));
                    scheduler.set(j, temp);
                }
            }
        }
        // weighted selection with Brute-Force algorithm
        int[] optimal = new int[scheduler.size()+1];
        optimal[0] = 0;
        for (int i = 0; i < scheduler.size() - 1  ; i++ ){
            int t = binarySearch(0, i , scheduler, scheduler.get(i).getStartTime());
            if (optimal[i] > optimal[t] + scheduler.get(i).getWeight()) {
                optimal[i+1] = optimal[i];
            }
            else {
                optimal[i+1] = optimal[t] + scheduler.get(i).getWeight();

            }
        }return optimal[scheduler.size()];
    }
    //use binary search to get jobs with finish time <= start time for i
    public int binarySearch(int start, int end, ArrayList<Job> scheduler, Date target){
        int mid;
        while(start + 1 < end){
            mid = start + (end + start) / 2;
            if(!target.before(scheduler.get(mid).getFinishTime())){
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (!scheduler.get(end).getFinishTime().after(target)){
            return end;
        }
        else{
            return start;
        }
    }

    //return and print the max cost result.
    public int resultSchedulerCost(int optimal) {
        System.out.println(optimal);
        return optimal;
    }
}
