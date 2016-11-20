package com.example.schedger;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

import com.example.schedger.GenEvent;

/**
 * Created by Payton on 11/19/2016.
 */

public class Task implements Comparable<Task> {
    //Inititalize instances of Task

    private String name;
    private DateTime startTime;
    private DateTime endTime;
    private Duration duration;
    private boolean completed;

    private GenEvent genEvent; // the gen event associated with this task

    public Task (String name, DateTime startTime, DateTime endTime, Duration duration)
    {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.completed = false;
        Planner.AddTask(this);

        genEvent = null; // must be created through generate schedule method
    }

    public GenEvent getGenEvent() { return genEvent; }
    public void setGenEvent(GenEvent g) { genEvent = g; }

    /**
     * Sort by: endTime, duration, name
     * First endTime goes first
     * Longer duration goes first
     * First alphabetically goes first
     * @param other
     */
    public int compareTo(Task other)
    {
        long diff = this.endTime.getMillis() - other.endTime.getMillis();
        if(diff != 0) { return diff > 0 ? 1 : -1; }
        diff = this.duration.getMillis() - other.duration.getMillis();
        if(diff != 0) { return diff > 0 ? 1 : -1; }
        return name.compareTo(other.name);
    }

    public boolean equals(Object other)
    {
        return other instanceof Task && this.compareTo((Task)other) == 0;
    }

    public String getName()
    {
        return name;
    }

    public void editName(String name)
    {
        this.name = name;
    }

    public Duration getDuration()
    {
        return duration;
    }

    public void editDuration(Duration duration)
    {
        this.duration = duration;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public int getDay()
    {
        return this.startTime.getDayOfWeek();
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

        if (totalHours <= 24)
            return "red";
        else if (totalHours <= 72)
            return "yellow";
        else
            return "green";
    }

    public String getTimeLeft()
    {
        int years, months, weeks, days, hours, minutes;
        String timeLeft;
        DateTime current = getCurrent();
        Period period = new Period(current, endTime);
        years = period.getYears();
        months = period.getMonths();
        weeks = period.getWeeks();
        days = period.getDays();
        hours = period.getHours();
        minutes = period.getMinutes();

        timeLeft = "Due in:";

        // how many time intervals have been recorded
        int detailsAdded = 0;

        if(years > 0) {
            timeLeft += " " + years + " year" + (years > 1 ? "s" : "");
            detailsAdded++;
        }
        if (months > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ") + months + " month" + (months > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && weeks > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ") + weeks + " week" + (weeks > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && days > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ") + days + " day" + (days > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && hours > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ") + hours + " hour" + (hours > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && minutes > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ") + minutes + " minute" +
                    (minutes > 1 ? "s" : "");
        }

        return timeLeft;
    }

    @Override
    public String toString(){
        return getName() + "\n" + getDuration() + "\n" + getTimeLeft() + "\n";
    }
}
