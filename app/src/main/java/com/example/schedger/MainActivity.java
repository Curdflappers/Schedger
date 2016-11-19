package com.example.schedger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Task task1 = new Task("test", 1, 1, 1);
        Task task2 = new Task("test2", 1, 1, 1);
        Task task3 = new Task("test3", 1, 1, 1);
        Task task4 = new Task("test4", 1, 1, 1);
        Task task5 = new Task("test", 1, 1, 1);
        Task task6 = new Task("test2", 1, 1, 1);
        Task task7 = new Task("test3", 1, 1, 1);
        Task task8 = new Task("test4", 1, 1, 1);

        LinearLayout tasks = (LinearLayout)findViewById(R.id.tasks);
        for( int i = 0; i < Planner.tasks.size(); i++ )
        {
            TextView textView1 = new TextView(this);
            TextView textView2 = new TextView(this);
            textView1.setText(Planner.tasks.get(i).getName());
            textView2.setText("Due in: " + Planner.tasks.get(i).getDuration());
            tasks.addView(textView1);
            tasks.addView(textView2);
        }

        LinearLayout events = (LinearLayout)findViewById(R.id.events);
        for( int i = 0; i < Planner.tasks.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(Planner.tasks.get(i).getName());
            events.addView(textView);
        }
    }
}
