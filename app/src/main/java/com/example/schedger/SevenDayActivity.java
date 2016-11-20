package com.example.schedger;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        int time = 7;

        if (Planner.tasks.size() > 0) {
            for (int i = 0; i < Planner.tasks.size(); i++) {
                TextView textView = new TextView(this);
                TextView textViewSpacer = new TextView(this);
                TextView textViewSpacerFinal = new TextView(this);
                Task temp = Planner.tasks.get(i);
                if (Planner.tasks.get(i).getDay() == 1) {
                    monday.addView(textView);
                } else if (Planner.tasks.get(i).getDay() == 2) {
                    if (temp.getStartTime().getHourOfDay() - time > 0)
                    {
                        textViewSpacer.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.WRAP_CONTENT,
                                        0, 1 * (temp.getStartTime().getHourOfDay() - time)));
                        textViewSpacer.setHeight((temp.getStartTime().getHourOfDay() - time) * 10);
                        tuesday.addView(textViewSpacer);
                        time = time + (temp.getStartTime().getHourOfDay() - time);
                    }
                    textView.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.WRAP_CONTENT,
                                    0, 1));
                    textView.setText(Planner.tasks.get(i).getName().toString());
                    textView.setBackgroundResource(R.color.red);
                    tuesday.addView(textView);
                } else if (Planner.tasks.get(i).getDay() == 3) {
                    wednesday.addView(textView);
                } else if (Planner.tasks.get(i).getDay() == 4) {
                    thursday.addView(textView);
                } else if (Planner.tasks.get(i).getDay() == 5) {
                    friday.addView(textView);
                } else if (Planner.tasks.get(i).getDay() == 6) {
                    saturday.addView(textView);
                } else if (Planner.tasks.get(i).getDay() == 7) {

                    textView.setText(Planner.tasks.get(i).getName().toString());
                    textView.setBackgroundResource(R.color.red);
                    sunday.addView(textView);
                }
            }
        }
    }
}
