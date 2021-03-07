package com.mysticslice.wander;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class AddEventActivity extends AppCompatActivity {
    EditText eventNameView;
    EditText eventLocationView;
    EditText eventDateView;
    EditText eventUrlView;

    String mEventName;
    String mEventLocation;
    String mEventDate;
    String mCategory;
    String mEventUrl;
    String mDay;
    FireBaseUtils mfireBaseUtils = new FireBaseUtils();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        // implementing spinner for the categories
        Spinner cat_spinner = (Spinner) findViewById(R.id.sp_add_categories);
        ArrayAdapter<CharSequence> cat_adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        cat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cat_spinner.setAdapter(cat_adapter);

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

                eventUrlView = findViewById(R.id.et_add_event_url);
                mEventUrl = eventUrlView.getText().toString();

                mCategory = cat_spinner.getSelectedItem().toString();

                Event addedEvent = new Event(mEventName,mEventLocation,mEventDate,mCategory,mEventUrl,null);

                mfireBaseUtils.pushIntoDatabase(addedEvent);
                Toast.makeText(AddEventActivity.this,"Event Added",Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
