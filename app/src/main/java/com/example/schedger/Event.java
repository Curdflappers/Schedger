package com.example.schedger;

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

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String name;
    private long start;
    private long end;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;
    private String comments;

    public Event(String n, long s, long e, String l, String c)
    {
        name = n;
        start = s;
        end = e;
        location = l;
        comments = c;
    }

    public long duration() { return end - start; }
}
