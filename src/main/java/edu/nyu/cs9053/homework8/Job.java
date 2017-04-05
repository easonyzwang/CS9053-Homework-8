package edu.nyu.cs9053.homework8;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yzwang on 2017/4/1.
 */

public class Job {

    public Calendar startTime = Calendar.getInstance();
    public Calendar finishTime = Calendar.getInstance();
    public int weight;

    public Job(Calendar startTime, Calendar finishTime, int weight) {
        this.weight = weight;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public void setStartTime(int year, int month, int date, int hour, int minute, int second) {
        startTime.set(year, month, date, hour, minute, second);
    }

    public void setFinishTime(int year, int month, int date, int hour, int minute, int second) {
        finishTime.set(year, month, date, hour, minute, second);
    }

    public Date getStartTime() {

        return startTime.getTime();
    }

    public Date getFinishTime() {
        return finishTime.getTime();
    }

    public int getWeight() {
        return weight;
    }
}
