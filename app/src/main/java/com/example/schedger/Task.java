package com.example.schedger;

import java.util.ArrayList;

import static android.R.attr.start;
import static android.R.id.edit;

/**
 * Created by Payton on 11/19/2016.
 */

public class Task {
    //Inititalize instances of Task


    private String name;
    private int startTime;
    private int endTime;
    private int duration;
    private boolean completed;

    public Task (String name, int startTime, int endTime, int duration)
    {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
            this.duration = duration;
            this.completed = false;
            Planner.AddTask(this);
    }



    public String getName()
    {
        return name;
    }

    public void editName(String name)
    {
        this.name = name;
    }

    public int getDuration()
    {
        return duration;
    }

    public void editDuration(int duration)
    {
        this.duration = duration;
    }

    public boolean isCompleted()
    {
        return completed;
    }
}
