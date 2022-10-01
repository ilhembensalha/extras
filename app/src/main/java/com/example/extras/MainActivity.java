package com.example.extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onButtonClick(view);
            }
        });

        Button Button2 = (Button) findViewById(R.id.button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onButtonClick2(view);
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onButtonClick3(view);
            }
        });

    }
    public void onButtonClick(View view) {

        // get the text to pass
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String textToPass = editText.getText().toString();

        // start the SecondActivity
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(Intent.EXTRA_TEXT, textToPass);
        startActivity(intent);
    }
    public void onButtonClick2(View view) {

        // get the text to pass
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
    public void onButtonClick3(View view) {
        Date myDate;
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
        try {
            myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-31");
        } catch (ParseException e) {
            myDate = new Date();
        }
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, myDate.getTime());
        //intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, DateTime);
        intent.putExtra(CalendarContract.Events.ALL_DAY, true);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Descripttion");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
        startActivity(Intent.createChooser(intent, "Add to calendar"));
    }

}