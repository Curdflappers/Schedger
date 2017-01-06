package com.example.schedger;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * An event is a scheduled period during which the user cannot do anything else.
 * Examples include lectures, work, doing homework, or socializing.
 *
 * An event knows its duration and location as well.
 * Created by mwwie on 2016-11-19.
 */

public class Event extends PlannerItem<Event>
{
    /**
     * @param n name
     * @param s start
     * @param e end
     */
    public Event(String n, DateTime s, DateTime e, boolean r)
    {
        super(n, s, e, r);
        Planner.AddItem(this);
    }

    /**
     * In order of priority:
     * Earliest start
     * Earliest end
     * Alphabetical name
     * @param e the event to compare to
     * @return negative if this comes before e, positive if after, 0 if equal
     */
    public int compareTo(Event e)
    {
        // Earliest start first
        long diff = this.getStart().getMillis() - e.getStart().getMillis();
        if(diff != 0) { return (diff < 0 ? -1 : 1); }

        // Earliest end first
        diff = this.getEnd().getMillis() - e.getEnd().getMillis();
        if(diff != 0) { return (diff < 0 ? -1 : 1); }

        // Earlist alphabetical first
        return this.name.compareTo(e.name);
    }

    public boolean equals(Object o)
    {
        return o instanceof Event && compareTo((Event)o) == 0;
    }

    public String display()
    {
        String s = getName() + "\n"; // display name

        //display time
        DateTimeFormatter format = ISODateTimeFormat.dateHourMinute();
        s += getStart().toString(format) + " - " + getEnd().toString(format);
        return s;
    }

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
}
