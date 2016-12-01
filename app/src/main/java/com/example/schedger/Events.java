package com.example.schedger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Planner.GenerateSchedule();
// TODO : FIGURE HOW TO CLICK EACH INDIVIDUALLY

        LinearLayout eventsList = (LinearLayout)findViewById(R.id.eventsList);

        for(Event event : Planner.events )
        {
            TextView textView = new TextView(this);
            textView.setText(event.display());
            textView.setBackgroundResource(R.drawable.border);
            textView.setPadding(10, 10, 10, 10);
            // blue if genEvent, gray if not
            textView.setBackgroundResource
                    (event instanceof LinkedEvent ? R.color.lightBlue : R.color.lightGray);
            eventsList.addView(textView);
        }

        LinearLayout layout = (LinearLayout) findViewById(R.id.eventsList);
        layout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Events.this, NewEvent.class));
            }
        });

        Button add = (Button) findViewById(R.id.addEvent);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Events.this, NewEvent.class));
            }
        });
    }

}
