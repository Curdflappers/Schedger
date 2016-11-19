package com.example.schedger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;

import static com.example.schedger.R.color.red;
import static com.example.schedger.R.drawable.border;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        setContentView(R.layout.activity_main);

        LinearLayout tasks = (LinearLayout )findViewById(R.id.tasks);
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tasks_intent = new Intent(MainActivity.this,Events.class);
                startActivity(tasks_intent );
            }
        });


        LinearLayout events = (LinearLayout )findViewById(R.id.events);
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tasks_intent = new Intent(MainActivity.this,Events.class);
                startActivity(tasks_intent );
            }
        });

        DateTime startTime = new DateTime(2016, 11, 19, 13, 20);
        DateTime endTime = new DateTime(2016, 11, 20, 14, 20);
        DateTime finalTime = new DateTime(2016, 12, 24, 13, 20);

        Task task1 = new Task("Complete Math HW", startTime, startTime, 1);
        Task task2 = new Task("Complete Science HW", startTime, startTime, 1);
        Task task3 = new Task("test", startTime, startTime, 1);
        Task task4 = new Task("test", endTime, endTime, 1);
        Task task5 = new Task("test", startTime, startTime, 1);
        Task task6 = new Task("test", endTime, endTime, 1);
        Task task7 = new Task("test", startTime, startTime, 1);
        Task task8 = new Task("test", startTime, finalTime, 1);

        for (int i = 0; i < Planner.tasks.size(); i++)
        {

        }

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

        for( int i = 0; i < Planner.tasks.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(Planner.tasks.get(i).getName());
            events.addView(textView);
        }
    }
}
