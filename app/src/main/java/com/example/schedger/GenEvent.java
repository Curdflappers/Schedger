package com.example.schedger;

import org.joda.time.DateTime;

/**
 * Created by mwwie on 2016-11-19.
 */
public class GenEvent extends Event
{
    /**
     * The task this is linked to
     */
    private Task task;

    public Task getTask() { return task; }

    /**
     * Generates a new event as usual and adds linked task (does not update task's reference)
     * @param n name
     * @param s start
     * @param e end
     * @param l location
     * @param c comments
     * @param t task this is linked to (cannot be changed)
     */
    public GenEvent(String n, DateTime s, DateTime e, String l, String c, Task t)
    {
        super(n, s, e, l, c, false);
        task = t;
    }
}
