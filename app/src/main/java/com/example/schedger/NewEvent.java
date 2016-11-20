package com.example.schedger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Defines behavior for New Event Activity
 */
public class NewEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        createSaveButtonListener();
        setDateTimePickerOrdering();
        populateDefaultValues();
    }

    void createSaveButtonListener()
    {
        ImageButton saveEventButton = (ImageButton)findViewById(R.id.saveEventButton);
        saveEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText eventNameEdit = (EditText) findViewById(R.id.eventNameEdit);
                EditText eventStartDayEdit = (EditText) findViewById(R.id.eventStartDayEdit);
                EditText eventStartMonthEdit = (EditText) findViewById(R.id.eventStartMonthEdit);
                EditText eventStartYearEdit = (EditText) findViewById(R.id.eventStartYearEdit);
                EditText eventStartMinuteEdit = (EditText) findViewById(R.id.eventStartMinuteEdit);
                EditText eventStartHourEdit = (EditText) findViewById(R.id.eventStartHourEdit);
                EditText eventEndDayEdit = (EditText) findViewById(R.id.eventEndDayEdit);
                EditText eventEndMonthEdit = (EditText) findViewById(R.id.eventEndMonthEdit);
                EditText eventEndYearEdit = (EditText) findViewById(R.id.eventEndYearEdit);
                EditText eventEndMinuteEdit = (EditText) findViewById(R.id.eventEndMinuteEdit);
                EditText eventEndHourEdit = (EditText) findViewById(R.id.eventEndHourEdit);

                DateTime startDate = new DateTime(
                        Integer.parseInt(eventStartYearEdit.getText().toString()),
                        Integer.parseInt(eventStartMonthEdit.getText().toString()),
                        Integer.parseInt(eventStartDayEdit.getText().toString()),
                        Integer.parseInt(eventStartHourEdit.getText().toString()),
                        Integer.parseInt(eventStartMinuteEdit.getText().toString()));
                DateTime endDate = new DateTime(
                        Integer.parseInt(eventEndYearEdit.getText().toString()),
                        Integer.parseInt(eventEndMonthEdit.getText().toString()),
                        Integer.parseInt(eventEndDayEdit.getText().toString()),
                        Integer.parseInt(eventEndHourEdit.getText().toString()),
                        Integer.parseInt(eventEndMinuteEdit.getText().toString()));

                boolean shouldBreak = false;
                if(endDate.isBeforeNow() || endDate.isBefore(startDate))
                {
                    ((TextView)findViewById(R.id.dialogText)).setText("Invalid end time." +
                            " End time must be after current time and start time.");
                    return;
                }

                Event newEvent = new Event(eventNameEdit.getText().toString(), startDate,
                        endDate, "", "", false);
                Intent events_intent = new Intent(NewEvent.this, MainActivity.class);
                startActivity(events_intent);
            }
        });
    }

    void setDateTimePickerOrdering()
    {
        View[] order = {findViewById(R.id.eventNameEdit),
                findViewById(R.id.eventStartMonthEdit),
                findViewById(R.id.eventStartDayEdit),
                findViewById(R.id.eventStartYearEdit),
                findViewById(R.id.eventStartHourEdit),
                findViewById(R.id.eventStartMinuteEdit),
                findViewById(R.id.eventEndMonthEdit),
                findViewById(R.id.eventEndDayEdit),
                findViewById(R.id.eventEndYearEdit),
                findViewById(R.id.eventEndHourEdit),
                findViewById(R.id.eventEndMinuteEdit),
            findViewById(R.id.eventCommentsEdit),
            findViewById(R.id.saveEventButton)};


        for(int i = 0; i < order.length - 1; i++)
        {
            order[i].setNextFocusDownId(order[i+1].getId());
        }
    }

    /**
     * Populate to be an event that starts now and ends in one hour
     */
    void populateDefaultValues()
    {
        DateTime current = new DateTime();
        ((EditText)findViewById(R.id.eventNameEdit)).setText("New Event");
        ((EditText)findViewById(R.id.eventStartMonthEdit)).setText("" + current.getMonthOfYear());
        ((EditText)findViewById(R.id.eventStartDayEdit)).setText("" + current.getDayOfMonth());
        ((EditText)findViewById(R.id.eventStartYearEdit)).setText("" + current.getYear());
        ((EditText)findViewById(R.id.eventStartHourEdit)).setText("" + current.getHourOfDay());
        ((EditText)findViewById(R.id.eventStartMinuteEdit)).setText("" + current.getMinuteOfHour());
        DateTime end = current.plusHours(1);
        ((EditText)findViewById(R.id.eventEndMonthEdit)).setText("" + end.getMonthOfYear());
        ((EditText)findViewById(R.id.eventEndDayEdit)).setText("" + end.getDayOfMonth());
        ((EditText)findViewById(R.id.eventEndYearEdit)).setText("" + end.getYear());
        ((EditText)findViewById(R.id.eventEndHourEdit)).setText("" + end.getHourOfDay());
        ((EditText)findViewById(R.id.eventEndMinuteEdit)).setText("" + end.getMinuteOfHour());
    }
}
