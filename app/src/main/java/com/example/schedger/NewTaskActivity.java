package com.example.schedger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class NewTaskActivity extends AppCompatActivity {
    public static EditText taskNameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        ImageButton saveTaskButton = (ImageButton)findViewById(R.id.saveTaskButton);
        saveTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskNameEdit = (EditText) findViewById(R.id.taskNameEdit);
                EditText taskStartEdit = (EditText) findViewById(R.id.taskStartEdit);
                EditText taskEndEdit = (EditText) findViewById(R.id.taskEndEdit);
                Intent tasks_intent = new Intent(NewTaskActivity.this,Events.class);
                startActivity(tasks_intent );
            }
        });
    }

    static void saveTask(View v)
    {
        // validate task


        // show dialog box if invalid
        // quit method
        // save to planner
        // return to previous screen
        // display "task saved" notification
    }
}
