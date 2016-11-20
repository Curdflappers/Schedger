package com.example.schedger;

import android.content.Context;

import java.util.ArrayList;

import org.joda.time.DateTime;

import java.io.File;
/**
 * Program tracks various information to help college students and presents it back to them in an
 * organized, easy to read app. Information includes: tasks, which will be listed from top to
 * bottom based on priority (emphasized further by color code: red meaning high priority, yellow
 * meaning medium, and green meaning low). Additionally, info includes an agenda, which tells the
 * student what they have to do for the coming week(s). This is also prioritized via regular, low
 * priority events such as recurring lectures, meeting with friends, and the like; they are colored
 * light blue. High priority events on the agenda are deadlines for events, they will disappear once
 * their related task is completed; they are colored dark blue.  * Users will be able to add or \
 * delete tasks and regular events at any time.
 */
public class Planner {
    public static ArrayList<Task> tasks = new ArrayList<Task>();
    public static ArrayList<Event> events = new ArrayList<Event>();
    // public static String path = getApplicationContext().getFilesDir()


    /**
     * Automatically inserts the task and maintains list sorting
     * Inserts using a binary search
     * @param task
     */
    public static void AddTask(Task task) {
        int start = 0;
        int end = tasks.size();
        while(end > start)
        {
            int middle = (start + end) / 2;
            int compare = task.compareTo(tasks.get(middle));
            if(compare == 0) { start = middle; break; }
            if(compare < 0) // check first half
            {
                end = middle;
            }
            else { start = middle + 1;}
        }
        tasks.add(start, task);
    }

    /**
     * Automatically inserts the event and maintaints list sorting
     * @param event
     */
    public static void AddEvent(Event event) {
        int start = 0;
        int end = events.size();
        while(end > start)
        {
            int middle = (start + end) / 2;
            int compare = event.compareTo(events.get(middle));
            if(compare == 0) { start = middle; break; }
            if(compare < 0) // check first half
            {
                end = middle;
            }
            else { start = middle + 1;}
        }
        events.add(start, event);
    }

    public static void GenerateSchedule()
    {
        for(Task task : tasks)
        {
            if(!task.isCompleted() && task.getGenEvent() == null) // must add gen event
            {
                for(int i = 0; i < events.size(); i++)
                {
                    DateTime prevEnd = events.get(i).getEnd();
                    DateTime nextStart = (i == events.size() - 1 ? null : events.get(i+1).getStart());
                    // if should add genEvent for task
                    if(nextStart == null || // no event after this
                            (nextStart.getMillis() - prevEnd.getMillis()) // time between events
                                    > task.getDuration().getMillis()) // > duration of task
                    {
                        // create and add new gen event to the planner and to the task
                        GenEvent e = new GenEvent(task.getName(), prevEnd,
                                prevEnd.plus(task.getDuration().getMillis()), "", "", task);
                        task.setGenEvent(e);
                        break; // no longer go through each event
                    } // end if should add new gen event
                } // end loop through each event
            } // end if task needs gen event

        } // end looping through all tasks
    }

    public static void Save()
    {

    }
}
