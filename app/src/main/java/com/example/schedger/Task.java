package com.example.schedger;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

/**
 * Created by Payton on 11/19/2016.
 */

public class Task extends PlannerItem<Task> {

    private int id;
    private Duration duration;
    private boolean completed;
    private LinkedEvent linkedEvent; // the linked event linked to this task

    public Task(String name, DateTime startTime, DateTime endTime, boolean recurrence,
                Duration duration, boolean completed)
    {
        super(name, startTime, endTime, recurrence);
        id++;
        this.duration = duration;
        this.completed = completed;
        Planner.AddItem(this);

        linkedEvent = null; // must be created through generate schedule method
    }

    public LinkedEvent getLinkedEvent() { return linkedEvent; }
    public void setLinkedEvent(LinkedEvent g) { linkedEvent = g; }

    /**
     * Sort by: endTime, duration, name
     * First endTime goes first
     * Last startTime goes first
     * Longer duration goes first
     * First alphabetically goes first
     * @param other
     */
    public int compareTo(Task other)
    {
        // First end time goes first
        long diff = getEnd().getMillis() - other.getEnd().getMillis();
        if(diff != 0) { return diff < 0 ? -1 : 1; }

        // Last start time goes first
        diff = getStart().getMillis() - other.getStart().getMillis();
        if(diff != 0) { return diff > 0 ? -1 : 1; }

        // Longer task goes first
        diff = duration.getMillis() - other.duration.getMillis();
        if(diff != 0) { return diff < 0 ? -1 : 1; }

        return name.compareTo(other.name);
    }

    public boolean equals(Object other)
    {
        return other instanceof Task && this.compareTo((Task)other) == 0;
    }

    public Duration getDuration()
    {
        return duration;
    }

    public void setDuration(Duration duration)
    {
        this.duration = duration;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    /**
     * Calculates the urgency (green, yellow, red) of this event based on time
     * @return urgency
     */
    public String getUrgency()
    {
        Duration d = new Duration(getEnd(), new DateTime());
        int hours = (int)(d.getStandardHours());
        return hours > 72 ? "green" : hours > 24 ? "yellow" : "red";
    }

    public String getTimeLeft()
    {
        int years, months, weeks, days, hours, minutes;
        String timeLeft = "Due in:";
        Period period = new Period(new DateTime(), getEnd());
        years = period.getYears();
        months = period.getMonths();
        weeks = period.getWeeks();
        days = period.getDays();
        hours = period.getHours();
        minutes = period.getMinutes();

        // how many time intervals have been recorded
        int detailsAdded = 0;

        if(years > 0) {
            timeLeft += " " + years + " year" + (years > 1 ? "s" : "");
            detailsAdded++;
        }
        if (months > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ")
                    + months + " month" + (months > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && weeks > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ")
                    + weeks + " week" + (weeks > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && days > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ")
                    + days + " day" + (days > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && hours > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ")
                    + hours + " hour" + (hours > 1 ? "s" : "");
            detailsAdded++;
        }
        if (detailsAdded < 2 && minutes > 0) {
            timeLeft += (detailsAdded == 1 ? ", " : " ")
                    + minutes + " minute" + (minutes > 1 ? "s" : "");
        }

        return timeLeft;
    }

    @Override
    public String toString(){
        return getName() + "\n" + getDuration().toString() + "\n" + getTimeLeft() + "\n";
    }
}
