package com.example.schedger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        LinearLayout tasksList = (LinearLayout)findViewById(R.id.tasksList);
        //TODO : TO FIGURE HOW TO CLICK EACH INDIVIDUALLY
        for( int i = 0; i < Planner.tasks.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(Planner.tasks.get(i).getName() + "\n" + Planner.tasks.get(i).getTimeLeft());
            textView.setBackgroundResource(R.drawable.border);
            textView.setPadding(10, 10, 10, 10);
            String urgency = Planner.tasks.get(i).getUrgency();
            if (urgency.equals("red"))
                textView.setBackgroundResource(R.color.red);
            else if (urgency.equals("yellow"))
                textView.setBackgroundResource(R.color.yellow);
            else if (urgency.equals("green"))
                textView.setBackgroundResource(R.color.green);
            tasksList.addView(textView);
        }

        LinearLayout layout = (LinearLayout) findViewById(R.id.tasksList);
        layout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(TaskActivity.this, NewTaskActivity.class));
            }
        });
        Button add = (Button) findViewById(R.id.addTask);
        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(TaskActivity.this, NewTaskActivity.class));
            }
        });
    }
}
