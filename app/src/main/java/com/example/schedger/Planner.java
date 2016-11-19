package com.example.schedger;

import java.util.ArrayList;

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
        events.add(event);
    }
}
