package com.example.schedger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
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

    public Calendar getStart() {
        return start;
    }

    public void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getEnd() {
        return end;
    }

    public void setEnd(Calendar end) {
        this.end = end;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String name;
    private Calendar start;
    private Calendar end;

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
    public Event(String n, Calendar s, Calendar e, String l, String c)
    {
        name = n;
        start = s;
        end = e;
        location = l;
        comments = c;
    }

    /**
     * @return the duration of this event in milliseconds
     */
    public long duration() { return end.getTimeInMillis() - start.getTimeInMillis(); }
}
