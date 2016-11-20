package com.example.schedger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

import net.danlew.android.joda.JodaTimeAndroid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setContentView(R.layout.activity_main);

        LinearLayout tasks = (LinearLayout )findViewById(R.id.tasks);
        TextView tasksText = (TextView) findViewById(R.id.tasksText);
        tasksText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tasks_intent = new Intent(MainActivity.this,NewTaskActivity.class);
                startActivity(tasks_intent );
            }
        });


        LinearLayout events = (LinearLayout )findViewById(R.id.events);
        TextView eventsText = (TextView) findViewById(R.id.eventsText);
        eventsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent events_intent = new Intent(MainActivity.this,Events.class);
                startActivity(events_intent );
            }
        });

        TextView seeMoreTasks = (TextView) findViewById(R.id.seeMoreTasks);
        seeMoreTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_tasks = new Intent(MainActivity.this,TaskActivity.class);
                startActivity(see_tasks );
            }
        });

        TextView seeMoreEvents = (TextView) findViewById(R.id.seeMoreEvents);
        seeMoreEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_events = new Intent(MainActivity.this,Events.class);
                startActivity(see_events );
            }
        });

        // Display tasks in left hand side of home screen (scrollable)
        for( int i = 0; i < Planner.tasks.size(); i++ ) {
            TextView textView1 = new TextView(this);
            textView1.setText(Planner.tasks.get(i).getName() + "\n" + Planner.tasks.get(i).getTimeLeft());
            textView1.setBackgroundResource(R.drawable.border);
            textView1.setPadding(10, 10, 10, 10);
            String urgency = Planner.tasks.get(i).getUrgency();
            if (urgency.equals("red"))
                textView1.setBackgroundResource(R.color.red);
            else if (urgency.equals("yellow"))
                textView1.setBackgroundResource(R.color.yellow);
            else if (urgency.equals("green"))
                textView1.setBackgroundResource(R.color.green);
            tasks.addView(textView1);
        }

        // Display events in right hand side of home screen (scrollable)
        for( int i = 0; i < Planner.events.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(Planner.events.get(i).getName());
            events.addView(textView);
        }

        // Display calendar in bottom of home screen
        LinearLayout monday = (LinearLayout) findViewById(R.id.Monday);
        for (int i = 0; i < Planner.tasks.size(); i++)
        {
            TextView textView = new TextView(this);
            textView.setWidth(20);
            textView.setHeight(30);
            textView.setBackgroundResource(R.color.red);
            monday.addView(textView);
        }

        //Displays add task/event buttons when there are none
        Button showAddEvents = (Button) this.findViewById(R.id.addEventWhenNoEvents);
        if(Planner.events.size() == 0){
            showAddEvents.setVisibility(View.VISIBLE);
            showAddEvents.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    startActivity(new Intent(MainActivity.this, NewEvent.class));
                }
            });
        }else {
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