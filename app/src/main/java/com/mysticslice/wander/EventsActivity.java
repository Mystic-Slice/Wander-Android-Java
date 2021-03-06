package com.mysticslice.wander;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        final ArrayList<Event> events = new ArrayList<Event>();
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "10/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "15/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "25/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));
        events.add(new Event("SF hacks - Hackathon","R S Puram", "05/03/2021","something.com",null));

        EventAdapter adapter = new EventAdapter(this,events);

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
