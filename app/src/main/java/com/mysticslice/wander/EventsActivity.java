package com.mysticslice.wander;

import android.content.Intent;
import android.net.Uri;
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
    ArrayList<Event> events = new ArrayList<Event>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Wander);
        setContentView(R.layout.activity_events);


        FireBaseUtils firebaseUtils = new FireBaseUtils();

        EventAdapter adapter = new EventAdapter(this,events);

        events = firebaseUtils.getFromDatabase(adapter,events);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event currentEvent = events.get(position);
                Uri eventUrl = Uri.parse(currentEvent.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, eventUrl);
                startActivity(websiteIntent);
            }
        });
    }
}
