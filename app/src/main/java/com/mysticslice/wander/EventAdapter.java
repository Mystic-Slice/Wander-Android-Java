package com.mysticslice.wander;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EventAdapter extends ArrayAdapter<Event> {
    int mImageResourceId;

    public EventAdapter(Activity context, ArrayList<Event> Events){
        super(context,0,Events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        // Getting the current event in context
        Event currentEvent = getItem(position);

        //Setting the event name
        TextView eventName = (TextView) listItemView.findViewById(R.id.tv_event_name);
        eventName.setText(currentEvent.getEventName());

        //Setting the event location
        TextView eventLocation = (TextView) listItemView.findViewById(R.id.tv_event_location);
        eventLocation.setText(currentEvent.getLocation());

        //Setting the date
        TextView eventDate = (TextView) listItemView.findViewById(R.id.tv_event_date);
        eventDate.setText(currentEvent.getDate());

        //Setting the day
        TextView eventDay = (TextView) listItemView.findViewById(R.id.tv_event_day);
        eventDay.setText(currentEvent.getDay());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.iv_category_image);

        switch (currentEvent.getCategory()){
            case "Drama":
                mImageResourceId = R.drawable.drama;
                break;
            case "Party":
                mImageResourceId = R.drawable.party;
                break;
            case "Seminar":
                mImageResourceId = R.drawable.seminar;
                break;
            case "Stand-up":
                mImageResourceId = R.drawable.stand_up;
                break;
            case "Music":
                mImageResourceId = R.drawable.music;
                break;
            default:
                mImageResourceId = R.drawable.wander_logo;
                break;

        }
        imageView.setImageResource(mImageResourceId);


        return listItemView;
    }
}
