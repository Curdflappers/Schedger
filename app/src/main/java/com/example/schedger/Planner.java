package com.example.schedger;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

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
class Planner {
    static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<Event> events = new ArrayList<>();
    private static boolean quietHoursAdded = false;

    /**
     * Populates the planner with quiet hours,
     * event from 11pm to 7am every day. This avoids scheduling during
     * late night hours.
     */
    static void populateQuietHours()
    {
        if(quietHoursAdded) { return; }
        DateTime now = DateTime.now();
        // 11pm
        DateTime quietStart = new DateTime(now.getYear(),
            now.getMonthOfYear(),
            now.getDayOfMonth(),
            23,
            0);
        for(int i = 0; i < 7; i++)
        {
            new Event("Quiet Hours", quietStart, quietStart.plusHours(8), true);
            quietStart = quietStart.plusDays(1);
        }
        quietHoursAdded = true;
    }

    /**
     * Inserts the planner item at the appropriate position
     * to the appropriate list
     * @param item the item (either a task or event) to add
     */
    static void AddItem(PlannerItem item)
    {
        // Account for task or event
        List<? extends PlannerItem> list;
        boolean isTask = false;
        if(item instanceof Task) {
            list = tasks;
            isTask = true;
        } else if (item instanceof Event) {
            list = events;
        } else {
            throw new UnsupportedOperationException(
                    "Can only add Tasks and Events");
        }

        // Find insertion index
        int start = 0;
        int end = list.size();
        while(end > start)
        {
            int middle = (start + end) / 2;
            int compare = item.compareTo(list.get(middle)); // ignore warning
            if(compare == 0) { start = middle; break; }
            if(compare < 0) // check first half
            {
                end = middle;
            }
            else { start = middle + 1;} // else check second half
        }

        // Add to appropriate list
        if(isTask) { tasks.add(start, (Task)item); }
        else { events.add(start, (Event)item); }
    }

    /**
     * Generates the schedule for the user.
     * Iterates through each incomplete task without a linked event,
     * Goes through each event, finds free time to complete the task
     * and inserts a new linked event at that time slot.
     * TODO: No conflict flags or resolution
     */
    static void GenerateSchedule()
    {
        for(Task task : tasks) {
            if(!task.isCompleted() && task.getLinkedEvent() == null) // must add gen event
            {
                for(int i = 0; i < events.size(); i++) {
                    DateTime prevEnd = events.get(i).getEnd();
                    DateTime nextStart = i == events.size() - 1 ?
                            null : events.get(i+1).getStart();

                    // if should add genEvent for task
                    if(nextStart == null || // no event after this
                        (nextStart.getMillis() - prevEnd.getMillis()) // time between events
                        > task.getDuration().getMillis()) // > duration of task
                    {
                        // create and add new gen event to the planner and to the task
                        LinkedEvent e = new LinkedEvent(task.getName(), prevEnd,
                                prevEnd.plus(task.getDuration().getMillis()), task);
                        task.setLinkedEvent(e);
                        break; // move on to the next event
                    }
                }
            }
        }
    }

    /*/
    //Makes files for the user, stores their task and event arrays as strings
    public static void Save()
    {
        ArrayList<String> data = new ArrayList<String>();
        for(int i = 0; i < tasks.size(); i++){
            data.add(tasks.get(i).toString());
        }
        //Used to separate tasks and events
        data.add(" ");
        for (int i = 0; i < events.size(); i++){
            data.add(events.get(i).toString());
        }

        for (int i = 0; i < data.size(); i++){
            
        }
    }
    //*/
}
