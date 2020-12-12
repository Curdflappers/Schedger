package com.example.schedger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.danlew.android.joda.JodaTimeAndroid;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.ArrayList;
import java.util.List;

import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setContentView(R.layout.activity_main);

        Planner.populateQuietHours();
        createButtonBindings();
        displayTasks();
        displayEvents();
        displaySevenDay();
    }

    /**
     * Creates binding for navigation buttons
     */
    private void createButtonBindings() {

        LinearLayout layoutTask = (LinearLayout)findViewById(R.id.tasks);
//        TextView moreTasks = (TextView) findViewById(R.id.seeMoreTasks);
        layoutTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_tasks = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(see_tasks);
            }
        });

        LinearLayout layoutEvent = (LinearLayout)findViewById(R.id.events);
//        TextView moreEvents = (TextView) findViewById(R.id.seeMoreEvents);
        layoutEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_events = new Intent(MainActivity.this, Events.class);
                startActivity(see_events);
            }
        });

        TextView tasksText = (TextView)findViewById(R.id.tasksText);
        tasksText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tasks_intent = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivity(tasks_intent);
            }
        });

        TextView eventsText = (TextView)findViewById(R.id.eventsText);
        eventsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent events_intent = new Intent(MainActivity.this, NewEvent.class);
                startActivity(events_intent);
            }
        });

        TextView seeMoreTasks = (TextView)findViewById(R.id.seeMoreTasks);
        seeMoreTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_tasks = new Intent(MainActivity.this, TaskActivity.class);
                startActivity(see_tasks);
            }
        });

        TextView seeMoreEvents = (TextView)findViewById(R.id.seeMoreEvents);
        seeMoreEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_events = new Intent(MainActivity.this, Events.class);
                startActivity(see_events);
            }
        });
    }

    /**
     * Display the tasks in the lefthand scrollview
     */
    private void displayTasks()
    {
        // Display tasks in left hand side of home screen (scrollable)
        for( int i = 0; i < Planner.tasks.size(); i++ ) {
            TextView textView1 = new TextView(this);
            textView1.setText(Planner.tasks.get(i).getName() +
                    "\n" + Planner.tasks.get(i).getTimeLeft());
            textView1.setBackgroundResource(R.drawable.border);
            textView1.setPadding(10, 10, 10, 10);
            textView1.setId(i + 10);
            String urgency = Planner.tasks.get(i).getUrgency();
            if (urgency.equals("red"))
                textView1.setBackgroundResource(R.color.red);
            else if (urgency.equals("yellow"))
                textView1.setBackgroundResource(R.color.yellow);
            else if (urgency.equals("green"))
                textView1.setBackgroundResource(R.color.green);
            ((LinearLayout)findViewById(R.id.tasks)).addView(textView1);
        }
    }

    /**
     * Display the events in the right hand scrollview
     */
    private void displayEvents() {
    // Display events in right hand side of home screen (scrollable)
    for( int i = 0; i < Planner.events.size(); i++ ) {
        if (!(Planner.events.get(i).getName().equals("Quiet Hours"))) {
            TextView textView = new TextView(this);
            textView.setText(Planner.events.get(i).display());
            textView.setBackgroundResource(R.color.lightBlue);
            ((LinearLayout)findViewById(R.id.events)).addView(textView);
        }
        }
    }

    /**
     * Display a day of the week
     * Assumes no conflicts
     * Displays a simple textview corresponding to each event for each day in the correct position
     */
    private void displayDayOfWeek(List<Event> day, LinearLayout layout, int daysFromNow)
    {
        DateTime now = (new DateTime()).plusDays(daysFromNow);
        long beginMillis = (new DateTime(now.getYear(),
                now.getMonthOfYear(), now.getDayOfMonth(), 7, 0)).getMillis(); // quiet hours end at 7 am
        long quietBegin = beginMillis + 1000 * 60 * 60 * 16; // 16 hours in a day (7h to 23h)

        long endMillis = 0;

        // for every event in the day
        for (Event event : day) {
            // Skip any event that shouldn't be displayed (during quiet hours)
            long eventStart = event.getStart().getMillis();
            long eventEnd = event.getEnd().getMillis();

            // if spacer is needed, add spacer (almost always)
            if (event.getStart().getMillis() > beginMillis) {
                layout.addView(sevenDayView(beginMillis, eventStart));
            } // end add spacer

            // format and add textView
            // format textView height
            endMillis = event.getEnd().getHourOfDay() < 23 ? eventEnd : quietBegin;
            long startMillis = event.getEnd().getHourOfDay() >= 7 ? eventStart : beginMillis;
            TextView textView = sevenDayView(startMillis, endMillis);
            textView.setText(event.getName());
            textView.setTextSize(10);
            textView.setGravity(1);
            textView.setBackgroundResource(R.color.red);
            layout.addView(textView);

            // update end time
            beginMillis = event.getEnd().getMillis();
        }
        layout.addView(sevenDayView(beginMillis, quietBegin));
    }

    /**
     * Returns a textView in a seven-day display (weighted based on end and start)
     * @param start the begin time of this (in millis)
     * @param end the end time of this (in millis)
     * @return a new LayoutParams of height=MATCH_PARENT, width=0, weight=(end - start) / total
     */
    private TextView sevenDayView(long start, long end)
    {
        TextView view = new TextView(this);
        view.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT, 0, (int)(end - start)));
        return view;
    }

    private void displaySevenDay()
    {
        LinearLayout monday = (LinearLayout) findViewById(R.id.Monday);
        LinearLayout tuesday = (LinearLayout) findViewById(R.id.Tuesday);
        LinearLayout wednesday = (LinearLayout) findViewById(R.id.Wednesday);
        LinearLayout thursday = (LinearLayout) findViewById(R.id.Thursday);
        LinearLayout friday = (LinearLayout) findViewById(R.id.Friday);
        LinearLayout saturday = (LinearLayout) findViewById(R.id.Saturday);
        LinearLayout sunday = (LinearLayout) findViewById(R.id.Sunday);

        LinearLayout[] layouts = new LinearLayout[]{monday, tuesday, wednesday, thursday, friday,
                saturday, sunday};

        List<Event> mondays = new ArrayList<>();
        List<Event> tuesdays = new ArrayList<>();
        List<Event> wednesdays = new ArrayList<>();
        List<Event> thursdays = new ArrayList<>();
        List<Event> fridays = new ArrayList<>();
        List<Event> saturdays = new ArrayList<>();
        List<Event> sundays = new ArrayList<>();

        List<List<Event>> days = new ArrayList<List<Event>>();
        days.add(mondays);
        days.add(tuesdays);
        days.add(wednesdays);
        days.add(thursdays);
        days.add(fridays);
        days.add(saturdays);
        days.add(sundays);

        // add events to days of week and display them
        if (Planner.events.size() > 0) {
            for(Event event : Planner.events)
            {
                Period timeFromNow = new Period(DateTime.now(), event.getStart());
                if(timeFromNow.getDays() > 6) // not happening this week
                { break; } // we have iterated through all events happening this week
                days.get(event.getStart().getDayOfWeek() - 1).add(event);
            }

            // display each layout
            for(int i = 0; i < days.size(); i++) {
                displayDayOfWeek(days.get(i), layouts[i], i);
            }
        }

        //Displays add task/event buttons when there are none
        Button showAddEvents = (Button) this.findViewById(R.id.addEventWhenNoEvents);
        if(Planner.events.size() <= 7){ // one for each day of the week
            showAddEvents.setVisibility(View.VISIBLE);
            showAddEvents.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    startActivity(new Intent(MainActivity.this, NewEvent.class));
                }
            });
        } else {
            showAddEvents.setVisibility(View.GONE);
        }

        Button showAddTasks = (Button) this.findViewById(R.id.addTaskWhenNoTasks);
        if(Planner.tasks.size() == 0){
            showAddTasks.setVisibility(View.VISIBLE);
            showAddTasks.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    startActivity(new Intent(MainActivity.this, NewTaskActivity.class));
                }
            });
        }else{
            showAddTasks.setVisibility(View.GONE);
        }
    }
}