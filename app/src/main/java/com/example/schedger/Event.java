package com.example.schedger;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.LocalDate;
import org.joda.time.format.ISODateTimeFormat;

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
     * @return the period during which this takes place
     */
    public Period duration() { return new Period(startTime, endTime); }

    /**
     *
     * @return
     */
    public String display()
    {
        String s = getName() + "\n"; // display name

        //display time
        DateTimeFormatter format = ISODateTimeFormat.dateHourMinute();
        s += getStart().toString(format) + " - " + getEnd().toString(format);
        /*
        Period duration = duration();
        DateTimeFormatter format;
        LocalDate today = DateTime.now().toLocalDate();
        // if within one week
        if(Days.daysBetween(DateTime.now(), getStart()).getDays() < 7) {
            // if starts today, omit indication of start date
            s += getStart().toLocalDate().equals(today)
                    ? "" : getStart().toString(DateTimeFormat.forPattern("E, HH:mm")) + " - ";

            // ends on same day, just show end time
            if (getStart().toLocalDate().equals(getEnd().toLocalDate())) {
                s += getEnd().toString(DateTimeFormat.forPattern("HH:mm"));
            }
            // Event starts and ends on different days within seven days of each other
            // "Tue, 11:00 - Wed, 15:00"
            // "11:00 - Thu, 13:00"
            else if (Days.daysBetween(getStart(), getEnd()).getDays() < 7) {
                s += getEnd().toString(DateTimeFormat.forPattern("E, HH:mm"));
            }
            // Event ends more than seven days after it starts
            // "Tue, 16:00 - 2017 Nov 24, 04:30"
            // "16:00 - Dec 12, 13:00"
            else {
                int endYear = getEnd().getYear();
                s += (endYear == getStart().getYear()) ? "" : endYear + " " +
                        getEnd().toString(DateTimeFormat.forPattern("MM dd, HH:mm"));
            }
        } // end within one week
        else if(getStart().)
        {

            if (getStart().toLocalDate().equals(getEnd().toLocalDate())) {
                s += getEnd().toString(DateTimeFormat.forPattern("HH:mm"));
            }
        }
        */
        return s;
    }
}
