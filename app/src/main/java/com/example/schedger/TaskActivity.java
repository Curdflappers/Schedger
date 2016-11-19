package com.example.schedger;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
    }
//        @Override
//        public String toString(){
//            return Planner.
//        }
//        tasks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent tasks_intent = new Intent(TaskActivity.this,TaskActivity.class);
//                startActivity(tasks_intent );
//            }
//
//        });
}
