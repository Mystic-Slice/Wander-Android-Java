package com.mysticslice.wander;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ArrayList<Event> events = new ArrayList<Event>();

        FireBaseUtils firebaseUtils = new FireBaseUtils();

        EventAdapter adapter = new EventAdapter(this,events);

        events = firebaseUtils.getFromDatabase(adapter,events);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EventsActivity.this,"The list item clicked is at position "+String.valueOf(position)
                        ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
