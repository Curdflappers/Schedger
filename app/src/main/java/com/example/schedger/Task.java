package com.example.schedger;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;

import static android.R.attr.start;
import static android.R.id.edit;

/**
 * Created by Payton on 11/19/2016.
 */

public class Task {
    //Inititalize instances of Task

    private String name;
    private DateTime startTime;
    private DateTime endTime;
    private int duration;
    private boolean completed;
    private DateTime dt;
    private int timeLeft;

    public Task (String name, DateTime startTime, DateTime endTime, int duration)
    {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.completed = false;
        Planner.AddTask(this);
    }



    public String getName()
    {
        return name;
    }

    public void editName(String name)
    {
        this.name = name;
    }

    public int getDuration()
    {
        return duration;
    }

    public void editDuration(int duration)
    {
        this.duration = duration;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public DateTime getCurrent() { return new DateTime(); }

    public String getUrgency()
    {
        int year, month, week, day, hour, minute, totalHours;
        year = endTime.getYear() - getCurrent().getYear();
        month = endTime.getMonthOfYear() - getCurrent().getMonthOfYear();
        week = endTime.getWeekOfWeekyear() - getCurrent().getWeekOfWeekyear();
        day = endTime.getDayOfMonth() - getCurrent().getDayOfMonth();
        hour = endTime.getHourOfDay() - getCurrent().getHourOfDay();
        minute = endTime.getHourOfDay() - getCurrent().getHourOfDay();

        totalHours = 0;

        if (year > 0 || month > 0 || week > 0)
            return "green";
        if (day > 0) {
            totalHours = day * 24;
            if (hour > 0)
                totalHours += hour;
        }
        else if (hour > 0)
            totalHours += hour;

        this.timeLeft = totalHours;

        if (totalHours <= 24)
            return "red";
        else if (totalHours <= 72)
            return "yellow";
        else
            return "green";
    }

    public String getTimeLeft()
    {
        int year, month, week, day, hour, minute;
        String timeLeft;
        year = endTime.getYear() - getCurrent().getYear();
        month = endTime.getMonthOfYear() - getCurrent().getMonthOfYear();
        week = endTime.getWeekOfWeekyear() - getCurrent().getWeekOfWeekyear();
        day = endTime.getDayOfMonth() - getCurrent().getDayOfMonth();
        hour = endTime.getHourOfDay() - getCurrent().getHourOfDay();
        minute = endTime.getHourOfDay() - getCurrent().getHourOfDay();

        timeLeft = "Due in: ";

        if (month > 0)
            timeLeft += month + " months, ";
        if (week > 0)
            timeLeft += week + " weeks, ";
        if (day > 0)
            timeLeft += day + " days, ";
        if (hour > 0)
            timeLeft += hour + " hours, ";
        if (minute > 0 || !(week > 0))
            timeLeft += minute + " minutes";


        return timeLeft;

    }

}
