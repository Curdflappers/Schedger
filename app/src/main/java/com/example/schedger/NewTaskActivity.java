package com.example.schedger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
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
