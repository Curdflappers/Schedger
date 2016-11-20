package com.example.schedger;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

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

        if (Planner.tasks.size() > 0) {

            for (int i = 0; i < Planner.tasks.size(); i++) {
                if (Planner.tasks.get(i).getDay() == 1)
                {
                    mondays.add(Planner.tasks.get(i));
                }





//                if (Planner.tasks.get(i).getDay() == 1) {
//                    monday.addView(textView);
//                } else if (Planner.tasks.get(i).getDay() == 2) {
//                    if (temp.getStartTime().getHourOfDay() - time > 0)
//                    {
//                        textViewSpacer.setLayoutParams(new LinearLayout.LayoutParams
//                                (LinearLayout.LayoutParams.WRAP_CONTENT,
//                                        0, 1 * (temp.getStartTime().getHourOfDay() - time)));
//                        tuesday.addView(textViewSpacer);
//                        time = time + (temp.getStartTime().getHourOfDay() - time);
//                    }
//                    textView.setLayoutParams(new LinearLayout.LayoutParams
//                            (LinearLayout.LayoutParams.WRAP_CONTENT,
//                                    0, 1));
//                    textView.setText(Planner.tasks.get(i).getName().toString());
//                    textView.setBackgroundResource(R.color.red);
//                    tuesday.addView(textView);
//                    if ((i+1) == Planner.tasks.size())
//                    {
//                        textViewSpacer.setLayoutParams(new LinearLayout.LayoutParams
//                                (LinearLayout.LayoutParams.WRAP_CONTENT,
//                                        0, 16 - time));
//                        tuesday.addView(textViewSpacerFinal);
//                    }
//                    else if (Planner.tasks.get(i+1).getDay() != 2)
//                    {
//                        textViewSpacer.setLayoutParams(new LinearLayout.LayoutParams
//                                (LinearLayout.LayoutParams.WRAP_CONTENT,
//                                        0, 11 - time));
//                        tuesday.addView(textViewSpacerFinal);
//                    }
//                } else if (Planner.tasks.get(i).getDay() == 3) {
//                    wednesday.addView(textView);
//                } else if (Planner.tasks.get(i).getDay() == 4) {
//                    thursday.addView(textView);
//                } else if (Planner.tasks.get(i).getDay() == 5) {
//                    friday.addView(textView);
//                } else if (Planner.tasks.get(i).getDay() == 6) {
//                    saturday.addView(textView);
//                } else if (Planner.tasks.get(i).getDay() == 7) {
//
//                    textView.setText(Planner.tasks.get(i).getName().toString());
//                    textView.setBackgroundResource(R.color.red);
//                    sunday.addView(textView);
//                }
            }
            int time = 7;
            for (int i = 0; i < mondays.size(); i++)
            {
                TextView textView = new TextView(this);
                Task temp = Planner.tasks.get(i);
                if (temp.getStartTime().getHourOfDay() - time > 0)
                {
                    TextView spacerText = new TextView(this);
                    spacerText.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, 1 * (temp.getStartTime().getHourOfDay() - time)));
                    monday.addView(spacerText);
                }
                

                if (i == 0) {
                    if (mondays.get(i).getStartTime().getHourOfDay() - time > 0) {
                        textViewSpacer.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 1 * (temp.getStartTime().getHourOfDay() - time)));
                        monday.addView(textViewSpacer);
                        time += (temp.getStartTime().getHourOfDay() - time);
                        time += (mondays.get(i).getEndTime().getHourOfDay() -
                                mondays.get(i).getStartTime().getHourOfDay());
                    }
                    textView.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, 1 * (temp.getStartTime().getHourOfDay() - time)));
                }

                if (mondays.get(i).getStartTime().getHourOfDay() - time > 0)
                {
                    textViewSpacer.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, 1 * (temp.getStartTime().getHourOfDay() - time)));
                    monday.addView(textViewSpacer);
                    time += (temp.getStartTime().getHourOfDay() - time);
                    time += (mondays.get(i).getEndTime().getHourOfDay() -
                            mondays.get(i).getStartTime().getHourOfDay());
                }
                textView.setLayoutParams(new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT,
                                0, 1 * (temp.getStartTime().getHourOfDay() - time)));

            }
        }
    }
}
