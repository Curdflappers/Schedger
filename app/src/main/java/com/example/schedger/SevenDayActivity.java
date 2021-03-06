package com.example.schedger;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.DateTimeConstants;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * Created by Payton on 11/19/2016.
 */

public class SevenDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_day);

        LinearLayout monday = (LinearLayout) findViewById(R.id.Monday);
        LinearLayout tuesday = (LinearLayout) findViewById(R.id.Tuesday);
        LinearLayout wednesday = (LinearLayout) findViewById(R.id.Wednesday);
        LinearLayout thursday = (LinearLayout) findViewById(R.id.Thursday);
        LinearLayout friday = (LinearLayout) findViewById(R.id.Friday);
        LinearLayout saturday = (LinearLayout) findViewById(R.id.Saturday);
        LinearLayout sunday = (LinearLayout) findViewById(R.id.Sunday);

        ArrayList<Task> mondays = new ArrayList<Task>();
        ArrayList<Task> tuesdays = new ArrayList<Task>();
        ArrayList<Task> wednesdays = new ArrayList<Task>();
        ArrayList<Task> thursdays = new ArrayList<Task>();
        ArrayList<Task> fridays = new ArrayList<Task>();
        ArrayList<Task> saturdays = new ArrayList<Task>();
        ArrayList<Task> sundays = new ArrayList<Task>();

        if (Planner.events.size() > 0) {

            for (int i = 0; i < Planner.tasks.size(); i++) {
                Task task = Planner.tasks.get(i);
                switch(task.getStart().getDayOfWeek()) {
                    case(DateTimeConstants.MONDAY):
                        mondays.add(task); break;
                    case(DateTimeConstants.TUESDAY):
                        tuesdays.add(task); break;
                    case(DateTimeConstants.WEDNESDAY):
                        wednesdays.add(task); break;
                    case(DateTimeConstants.THURSDAY):
                        thursdays.add(task); break;
                    case(DateTimeConstants.FRIDAY):
                        fridays.add(task); break;
                    case(DateTimeConstants.SATURDAY):
                        saturdays.add(task); break;
                    case(DateTimeConstants.SUNDAY):
                        sundays.add(task); break;
                }
            }
            int time = 7;
            for (int i = 0; i < mondays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = mondays.get(i);
                if (temp.getStart().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, temp.getStart().getHourOfDay() - time));
                    monday.addView(spacerText);
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, temp.getEnd().getHourOfDay() - time));
                textView.setText(mondays.get(i).getName());
                textView.setBackgroundResource(R.color.red);
                time += temp.getStart().getHourOfDay() - time;
                time += temp.getEnd().getHourOfDay() - temp.getStart().getHourOfDay();
                monday.addView(textView);

                if (i == mondays.size()-1) {
                    if (16 - temp.getEnd().getHourOfDay() > 0) {
                        TextView finalView = new TextView(this);
                        finalView.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 16 - time));
                        monday.addView(finalView);
                    }
                }
            }
            time = 7;
            for (int i = 0; i < tuesdays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = tuesdays.get(i);
                if (temp.getStart().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, temp.getStart().getHourOfDay() - time));
                    tuesday.addView(spacerText);
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, temp.getEnd().getHourOfDay() - time));
                textView.setText(tuesdays.get(i).getName());
                textView.setBackgroundResource(R.color.red);
                tuesday.addView(textView);

                if (i == tuesdays.size()-1) {
                    if (16 - temp.getEnd().getHourOfDay() > 0) {
                        TextView finalView = new TextView(this);
                        finalView.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 16 - time));
                        tuesday.addView(finalView);
                    }
                }
            }

            time = 7;
            for (int i = 0; i < wednesdays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = wednesdays.get(i);
                if (temp.getStart().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, temp.getStart().getHourOfDay() - time));
                    wednesday.addView(spacerText);
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, temp.getEnd().getHourOfDay() - time));
                textView.setText(tuesdays.get(i).getName());
                textView.setBackgroundResource(R.color.red);
                wednesday.addView(textView);

                if (i == wednesdays.size()-1) {
                    if (16 - temp.getEnd().getHourOfDay() > 0) {
                        TextView finalView = new TextView(this);
                        finalView.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 16 - time));
                        wednesday.addView(finalView);
                    }
                }
            }

            time = 7;
            for (int i = 0; i < thursdays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = thursdays.get(i);
                if (temp.getStart().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, temp.getStart().getHourOfDay() - time));
                    thursday.addView(spacerText);
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, temp.getEnd().getHourOfDay() - time));
                textView.setText(thursdays.get(i).getName());
                textView.setBackgroundResource(R.color.red);
                thursday.addView(textView);

                if (i == thursdays.size()-1) {
                    if (16 - temp.getEnd().getHourOfDay() > 0) {
                        TextView finalView = new TextView(this);
                        finalView.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 16 - time));
                        thursday.addView(finalView);
                    }
                }
            }

            time = 7;
            for (int i = 0; i < fridays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = fridays.get(i);
                if (temp.getStart().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, temp.getStart().getHourOfDay() - time));
                    friday.addView(spacerText);
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, temp.getEnd().getHourOfDay() - time));
                textView.setText(thursdays.get(i).getName());
                textView.setBackgroundResource(R.color.red);
                friday.addView(textView);

                if (i == fridays.size()-1) {
                    if (16 - temp.getEnd().getHourOfDay() > 0) {
                        TextView finalView = new TextView(this);
                        finalView.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 16 - time));
                        friday.addView(finalView);
                    }
                }
            }

            time = 7;
            for (int i = 0; i < saturdays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = saturdays.get(i);
                if (temp.getStart().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, temp.getStart().getHourOfDay() - time));
                    saturday.addView(spacerText);
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, temp.getEnd().getHourOfDay() - time));
                textView.setText(thursdays.get(i).getName());
                textView.setBackgroundResource(R.color.red);
                saturday.addView(textView);

                if (i == saturdays.size()-1) {
                    if (16 - temp.getEnd().getHourOfDay() > 0) {
                        TextView finalView = new TextView(this);
                        finalView.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 16 - time));
                        saturday.addView(finalView);
                    }
                }
            }

            time = 7;
            for (int i = 0; i < sundays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = sundays.get(i);
                if (temp.getStart().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, temp.getStart().getHourOfDay() - time));
                    sunday.addView(spacerText);
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, temp.getEnd().getHourOfDay() - time));
                textView.setText(thursdays.get(i).getName());
                textView.setBackgroundResource(R.color.red);
                sunday.addView(textView);

                if (i == sundays.size()-1) {
                    if (16 - temp.getEnd().getHourOfDay() > 0) {
                        TextView finalView = new TextView(this);
                        finalView.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 16 - time));
                        sunday.addView(finalView);
                    }
                }
            }
        }
    }
}
