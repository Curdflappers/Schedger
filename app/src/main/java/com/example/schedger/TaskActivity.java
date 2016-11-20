package com.example.schedger;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class TaskActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ArrayList<Task> taskArrayList = Planner.tasks;
        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(getListView().getContext(),
                android.R.layout.simple_list_item_1, taskArrayList);
        setListAdapter(adapter);

        LinearLayout tasks = (LinearLayout) findViewById(R.id.tasks);

        Button add = (Button) findViewById(R.id.addTask);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(TaskActivity.this, NewTaskActivity.class));
            }
        });
    }
}
