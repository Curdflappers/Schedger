package com.example.schedger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        LinearLayout events = (LinearLayout )findViewById(R.id.events);

        for( int i = 0; i < Planner.events.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(Planner.events.get(i).getName());
            events.addView(textView);
        }
    }

}
