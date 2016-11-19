package com.example.schedger;

import org.joda.time.DateTime;

/**
 * Created by mwwie on 2016-11-19.
 */

public class GenEvent extends Event
{
    private Task task;

    public Task getTask() { return task; }
    public void setTask(Task t) { task = t; }

    public GenEvent(String n, DateTime s, DateTime e, String l, String c, Task t)
    {
        super(n, s, e, l, c);
        setTask(t);

    }
}
