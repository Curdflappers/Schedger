package com.example.schedger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setContentView(R.layout.activity_main);

        LinearLayout tasks = (LinearLayout)findViewById(R.id.tasks);
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tasks_intent = new Intent(MainActivity.this,TaskActivity.class);
                startActivity(tasks_intent );
            }
        });


        LinearLayout events = (LinearLayout)findViewById(R.id.events);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent events_intent = new Intent(MainActivity.this,Events.class);
                startActivity(events_intent );
            }
        });

        DateTime startTime = new DateTime(2016, 11, 19, 13, 20);
        DateTime endTime = new DateTime(2016, 11, 20, 14, 20);
        DateTime finalTime = new DateTime(2016, 12, 24, 13, 20);

        // initialize tasks
        Task task1 = new Task("09Math Homework", startTime, endTime.plus(9), new Duration(1));
        Task task2 = new Task("05Chem Homework", startTime, endTime.plus(5), new Duration(1));
        Task task3 = new Task("-1Run Errands", startTime, endTime.plus(-1), new Duration(1));
        Task task4 = new Task("12Buy Groceries", startTime, endTime.plus(12), new Duration(1));
        Task task5 = new Task("French Homework", startTime, endTime, new Duration(1));
        Task task6 = new Task("Comp Sci Project", startTime, endTime, new Duration(1));
        Task task7 = new Task("Comp Sci Exam (Study)", startTime, endTime, new Duration(1));
        Task task8 = new Task("French Exam (Study)", startTime, endTime, new Duration(1));
        Event event1 = new Event("Comp Sci Lecture", startTime, endTime,"comp sci buidling", "CS 367", false );
        Event event2 = new Event("Comp Sci Lecture", startTime, endTime,"comp sci buidling", "CS 302", false );
        Event event3 = new Event("Comp Sci Lecture", startTime, endTime,"comp sci buidling", "CS 354", false );
        Event event4 = new Event("Comp Sci Lecture", startTime, endTime,"comp sci buidling", "CS 368", false );

        for( int i = 0; i < Planner.tasks.size(); i++ )
        {
            TextView textView1 = new TextView(this);
            textView1.setText(Planner.tasks.get(i).getName() + "\n" + Planner.tasks.get(i).getTimeLeft());
            textView1.setBackgroundResource(R.drawable.border);
            textView1.setPadding(10, 10, 10, 10);
            if (Planner.tasks.get(i).getUrgency().equals("red"))
                textView1.setBackgroundResource(R.color.red);
            else if (Planner.tasks.get(i).getUrgency().equals("yellow"))
                textView1.setBackgroundResource(R.color.yellow);
            else if (Planner.tasks.get(i).getUrgency().equals("green"))
                textView1.setBackgroundResource(R.color.green);
            tasks.addView(textView1);
        }

        for( int i = 0; i < Planner.events.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(Planner.events.get(i).getName());
            events.addView(textView);
        }
    }
}
