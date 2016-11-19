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

    public GenEvent(String n, DateTime s, DateTime e, String l, String c, Task t, boolean r)
    {
        super(n, s, e, l, c, r);
        task = t;
    }
}
