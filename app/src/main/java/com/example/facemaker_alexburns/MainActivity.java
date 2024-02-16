package com.example.facemaker_alexburns;

/**
 * @Author Alex Burns
 * Date:2/13/24
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
           I used the android website to figure this out
           https://developer.android.com/develop/ui/views/components/spinner#java
         */
        Spinner spinner = (Spinner) findViewById(R.id.hairSpinner);

        // uses string array and a simple spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hairstyles,
                android.R.layout.simple_spinner_item);
        // tells it which layout to use when looking at the options
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // applies everything
        spinner.setAdapter(adapter);
    }
}