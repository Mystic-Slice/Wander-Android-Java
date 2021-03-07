package com.mysticslice.wander;

import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseUtils {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mEventsDatabaseReference;
    private ChildEventListener mChildEventListener;

    public void pushIntoDatabase(Event event){
        // Gaining access to the database
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mEventsDatabaseReference = mFirebaseDatabase.getReference().child("events");

        mEventsDatabaseReference.push().setValue(event);
    }

    public ArrayList<Event> getFromDatabase(ArrayAdapter<Event> adapter,ArrayList<Event> events){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mEventsDatabaseReference = mFirebaseDatabase.getReference().child("events");

        mEventsDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue() != null){
                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        Event newEvent = snapshot1.getValue(Event.class);
                        events.add(newEvent);
                        Log.i("eveents","asdfa" + newEvent.getEventName());
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return events;
    }
}
