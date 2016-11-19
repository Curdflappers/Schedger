package com.example.schedger;

import org.joda.time.DateTime;
<<<<<<< HEAD
=======

import java.util.Calendar;
>>>>>>> f05fdd1e715ccff61307d20afb8fdc65eb6b932b

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

    public GenEvent(String n, DateTime s, DateTime e, String l, String c, Task t)
    {
        super(n, s, e, l, c);
        task = t;
    }
}
