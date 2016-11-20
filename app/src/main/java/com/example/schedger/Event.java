package com.example.schedger;

import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 * An event is a scheduled timeframe during which the user cannot do anything else. Examples include
 * lectures, work, doing homework, or socializing.
 *
 * An event knows its duration and location as well.
 * Created by mwwie on 2016-11-19.
 */

public class Event implements Comparable<Event>
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getStart() {
        return startTime;
    }

    public void setStart(DateTime start) {
        this.startTime = start;
    }

    public DateTime getEnd() {
        return endTime;
    }

    public void setEnd(DateTime end) {
        this.endTime = end;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String name;
    private DateTime startTime;
    private DateTime endTime;
    private boolean recur;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;
    private String comments;

    /**
     * @param n name
     * @param s start
     * @param e end
     * @param l location
     * @param c comments
     */
    public Event(String n, DateTime s, DateTime e, String l, String c, boolean r)
    {
        name = n;
        startTime = s;
        endTime = e;
        location = l;
        comments = c;
        recur = r;
        Planner.AddEvent(this);
    }

    /**
     * In order of priority:
     * Earliest start
     * Earliest end
     * Alphabetical name
     * Bro why you got two of the same event that's not cool
     * @param e the event to compare to
     * @return negative if this comes before e, positive if after, 0 if equal
     */
    public int compareTo(Event e)
    {
        long diff = this.startTime.getMillis() - e.startTime.getMillis();
        if(diff != 0) { return (diff > 0 ? 1 : -1); }
        diff = this.endTime.getMillis() - e.endTime.getMillis();
        if(diff != 0) { return (diff > 0 ? 1 : -1); }
        return this.name.compareTo(e.name);
    }

    public boolean equals(Object o)
    {
        return o instanceof Event && compareTo((Event)o) == 0;
    }

    /**
     * @return the duration of this event in milliseconds
     *
     */
    //TODO Fix duration time to include more than just hour
    public Period duration() { return new Period(startTime, endTime); }
}
