package com.example.schedger;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.R.attr.start;

/**
 * An event is a scheduled timeframe during which the user cannot do anything else. Examples include
 * lectures, work, doing homework, or socializing.
 *
 * An event knows its duration and location as well.
 * Created by mwwie on 2016-11-19.
 */

public class Event
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
    public Event(String n, DateTime s, DateTime e, String l, String c)
    {
        name = n;
        startTime = s;
        endTime = e;
        location = l;
        comments = c;
        Planner.AddEvent(this);
    }

    /**
     * @return the duration of this event in milliseconds
     *
     */
    //TODO Fix duration time to include more than just hour
    public long duration() { return endTime.getHourOfDay() - startTime.getHourOfDay(); }
}
