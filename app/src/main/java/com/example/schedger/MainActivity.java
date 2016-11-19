package com.example.schedger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.schedger.R.color.red;
import static com.example.schedger.R.drawable.border;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout tasks = (LinearLayout )findViewById(R.id.tasks);
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tasks_intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(tasks_intent );
            }
        });

        LinearLayout events = (LinearLayout )findViewById(R.id.events);


        Task task1 = new Task("test", 1, 1, 1);
        Task task2 = new Task("test2", 1, 1, 1);
        Task task3 = new Task("test3", 1, 1, 1);
        Task task4 = new Task("test4", 1, 1, 1);
        Task task5 = new Task("test", 1, 1, 1);
        Task task6 = new Task("test2", 1, 1, 1);
        Task task7 = new Task("test3", 1, 1, 1);
        Task task8 = new Task("test4", 1, 1, 1);

        for( int i = 0; i < Planner.tasks.size(); i++ )
        {
            TextView textView1 = new TextView(this);
            textView1.setText(Planner.tasks.get(i).getName() + "\n" + "Due in: " + Planner.tasks.get(i).getDuration());
            textView1.setBackgroundResource(R.drawable.border);
            textView1.setPadding(10, 10, 10, 10);
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
