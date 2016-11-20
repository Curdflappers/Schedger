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


        LinearLayout eventsList = (LinearLayout )findViewById(R.id.eventsList);


        for( int i = 0; i < Planner.events.size(); i++ )
        {
            TextView textView = new TextView(this);
            textView.setText(Planner.events.get(i).getName() + '\n' + Planner.events.get(i).getComments() + '\n');
            textView.setBackgroundResource(R.drawable.border);
            textView.setPadding(10, 10, 10, 10);
            eventsList.addView(textView);
        }
        Button add = (Button) findViewById(R.id.addEvent);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Events.this, NewEvent.class));
            }
        });
    }

}
