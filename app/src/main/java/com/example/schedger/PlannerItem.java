package com.example.schedger;

import org.joda.time.DateTime;

/**
 * This contains basic information shared between both events and tasks.
 * Includes name, start, and end
 * Created by mwwie on 2016-12-26.
 */
public abstract class PlannerItem<T> implements Comparable<T> {
    /** The name of this item */
    protected String name;

    /** The start and end time of this item */
    protected DateTime start, end;

    /** The recurrence model for this item
     * Currently just a boolean don't worry about it too much
     */
    protected boolean recurrence;

    public PlannerItem(String n, DateTime s, DateTime e, boolean r)
    {
        name = n;
        start = s;
        end = e;
        recurrence = r;
    }

    public String getName() { return name; }
    public DateTime getStart() { return new DateTime(start); }
    public DateTime getEnd() { return new DateTime(end); }
    public boolean getRecurrence() { return recurrence; }

    public void setName(String n) { name = n; }
    public void setStart(DateTime s) { start = s; }
    public void setEnd(DateTime e) { end = e; }
    public void setRecurrence(boolean r) { recurrence = r; }

    /** Important information about this item */
    public abstract String display();
}
