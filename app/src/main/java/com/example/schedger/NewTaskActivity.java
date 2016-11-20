package com.example.schedger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {
    public static EditText taskNameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        createSaveButtonListener();
        setDateTimePickerOrdering();
        populateDefaultValues();
    }

    /**
     * Adds the functionality of the save button
     */
    void createSaveButtonListener()
    {
        ImageButton saveTaskButton = (ImageButton)findViewById(R.id.saveTaskButton);
        saveTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskNameEdit = (EditText) findViewById(R.id.taskNameEdit);
                EditText taskStartDayEdit = (EditText) findViewById(R.id.taskStartDayEdit);
                EditText taskStartMonthEdit = (EditText) findViewById(R.id.taskStartMonthEdit);
                EditText taskStartYearEdit = (EditText) findViewById(R.id.taskStartYearEdit);
                EditText taskStartMinuteEdit = (EditText) findViewById(R.id.taskStartMinuteEdit);
                EditText taskStartHourEdit = (EditText) findViewById(R.id.taskStartHourEdit);
                EditText taskEndDayEdit = (EditText) findViewById(R.id.taskEndDayEdit);
                EditText taskEndMonthEdit = (EditText) findViewById(R.id.taskEndMonthEdit);
                EditText taskEndYearEdit = (EditText) findViewById(R.id.taskEndYearEdit);
                EditText taskEndMinuteEdit = (EditText) findViewById(R.id.taskEndMinuteEdit);
                EditText taskEndHourEdit = (EditText) findViewById(R.id.taskEndHourEdit);
                EditText taskDurationEdit = (EditText) findViewById(R.id.taskDurationEdit);

                DateTime startDate = new DateTime(
                        Integer.parseInt(taskStartYearEdit.getText().toString()),
                        Integer.parseInt(taskStartMonthEdit.getText().toString()),
                        Integer.parseInt(taskStartDayEdit.getText().toString()),
                        Integer.parseInt(taskStartHourEdit.getText().toString()),
                        Integer.parseInt(taskStartMinuteEdit.getText().toString()));
                DateTime endDate = new DateTime(
                        Integer.parseInt(taskEndYearEdit.getText().toString()),
                        Integer.parseInt(taskEndMonthEdit.getText().toString()),
                        Integer.parseInt(taskEndDayEdit.getText().toString()),
                        Integer.parseInt(taskEndHourEdit.getText().toString()),
                        Integer.parseInt(taskEndMinuteEdit.getText().toString()));

                boolean shouldBreak = false;
                if(endDate.isBeforeNow() || endDate.isBefore(startDate))
                {
                    ((TextView)findViewById(R.id.dialogText)).setText("Invalid end time." +
                            " End time must be after current time and start time.");
                    return;
                }

                Duration duration = new Duration(Integer.parseInt(taskDurationEdit.getText().toString()));

                Task newTask = new Task(taskNameEdit.getText().toString(), startDate,
                        endDate, duration);
                Intent tasks_intent = new Intent(NewTaskActivity.this, MainActivity.class);
                startActivity(tasks_intent);
            }
        });
    }

    /**
     * Sets the navigation flow for the activity
     */
    void setDateTimePickerOrdering()
    {
        View[] order = {findViewById(R.id.taskNameEdit),
        findViewById(R.id.taskStartMonthEdit),
        findViewById(R.id.taskStartDayEdit),
        findViewById(R.id.taskStartYearEdit),
        findViewById(R.id.taskStartHourEdit),
        findViewById(R.id.taskStartMinuteEdit),
        findViewById(R.id.taskEndMonthEdit),
        findViewById(R.id.taskEndDayEdit),
        findViewById(R.id.taskEndYearEdit),
        findViewById(R.id.taskEndHourEdit),
        findViewById(R.id.taskEndMinuteEdit),
        findViewById(R.id.taskDurationEdit)};
        for(int i = 0; i < order.length - 1; i++)
        {
            order[i].setNextFocusDownId(order[i+1].getId());
        }
    }

    /**
     * Populates name as "New Task"
     * Start dateTime as current Time
     * End dateTime as current Time + 1 day
     * Duration as 60 minutes
     */
    void populateDefaultValues()
    {
        DateTime current = new DateTime();
        ((EditText)findViewById(R.id.taskNameEdit)).setText("New Task");
        ((EditText)findViewById(R.id.taskStartMonthEdit)).setText("" + current.getMonthOfYear());
        ((EditText)findViewById(R.id.taskStartDayEdit)).setText("" + current.getDayOfMonth());
        ((EditText)findViewById(R.id.taskStartYearEdit)).setText("" + current.getYear());
        ((EditText)findViewById(R.id.taskStartHourEdit)).setText("" + current.getHourOfDay());
        ((EditText)findViewById(R.id.taskStartMinuteEdit)).setText("" + current.getMinuteOfHour());
        DateTime end = current.plusDays(1);
        ((EditText)findViewById(R.id.taskEndMonthEdit)).setText("" + end.getMonthOfYear());
        ((EditText)findViewById(R.id.taskEndDayEdit)).setText("" + end.getDayOfMonth());
        ((EditText)findViewById(R.id.taskEndYearEdit)).setText("" + end.getYear());
        ((EditText)findViewById(R.id.taskEndHourEdit)).setText("" + end.getHourOfDay());
        ((EditText)findViewById(R.id.taskEndMinuteEdit)).setText("" + end.getMinuteOfHour());
        ((EditText)findViewById(R.id.taskDurationEdit)).setText("60");
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
