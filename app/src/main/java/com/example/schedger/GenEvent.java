package com.example.schedger;

import java.util.Calendar;

/**
 * Created by mwwie on 2016-11-19.
 */

public class GenEvent extends Event
{
    private Task task;

    public Task getTask() { return task; }
    public void setTask(Task t) { task = t; }

    public GenEvent(String n, Calendar s, Calendar e, String l, String c, Task t)
    {
        super(n, s, e, l, c);
        setTask(t);

    }
}
