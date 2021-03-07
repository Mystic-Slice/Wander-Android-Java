package com.mysticslice.wander;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class AddEventActivity extends AppCompatActivity {
    EditText eventNameView;
    EditText eventLocationView;
    EditText eventDateView;

    String mEventName;
    String mEventLocation;
    String mEventDate;
    FireBaseUtils mfireBaseUtils = new FireBaseUtils();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        Button addEventButton = (Button) findViewById(R.id.bt_add_addevent);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventNameView = findViewById(R.id.et_add_event_name);
                mEventName = eventNameView.getText().toString();

                eventLocationView = findViewById(R.id.et_add_event_location);
                mEventLocation = eventLocationView.getText().toString();

                eventDateView = findViewById(R.id.et_add_event_date);
                mEventDate = eventDateView.getText().toString();

                Event addedEvent = new Event(mEventName,mEventLocation,mEventDate,"Drama","google.com",null);

                mfireBaseUtils.pushIntoDatabase(addedEvent);
                Toast.makeText(AddEventActivity.this,"Event Added",Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
