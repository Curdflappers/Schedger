package com.example.schedger;

import org.joda.time.DateTime;

/**
 * Created by mwwie on 2016-11-19.
 */
public class LinkedEvent extends Event
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
     * @param t task this is linked to (cannot be changed)
     */
    public LinkedEvent(String n, DateTime s, DateTime e, Task t)
    {
        super(n, s, e, false);
        task = t;
    }
}
