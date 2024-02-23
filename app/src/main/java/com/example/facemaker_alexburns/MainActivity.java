package com.example.facemaker_alexburns;

/**
 * @author Alex Burns
 * Date:2/13/24
 */

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity{

    //sliders for the RGB values
    public int redSlider = 0;
    public int greenSlider = 0;
    public int blueSlider = 0;

    public SeekBar seekbarR;
    public SeekBar seekbarB;
    public SeekBar seekbarG;

    //BUTTONS!!!!!!!

    public RadioButton buttonHair;
    public RadioButton buttonEye;
    public RadioButton buttonSkin;
    public Button randomFace;

    //list of hairstyle options
    String[] spinnerOptions = {"Bald", "Bob with bangs", "Long hair with bangs", "Bowl cut"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Face face = findViewById(R.id.faceScreen);
        FaceController controller = new FaceController(face, this);

        /*
           I used the android website to figure this out
           https://developer.android.com/develop/ui/views/components/spinner#java
         */
        Spinner spinner = (Spinner) findViewById(R.id.hairSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,
                android.R.layout.simple_spinner_dropdown_item, this.spinnerOptions);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(controller);

        /*
            I used this to understand RadioGroups
            https://stackoverflow.com/questions/6780981/android-radiogroup-how-to-configure-the-event-listener
        */
        RadioGroup faceparts = findViewById(R.id.faceparts);
        faceparts.setOnCheckedChangeListener(controller);
        faceparts.check(R.id.hairButton); //check hair by default

        /**
         * if this has been turned in and this line is causing every problem known to man
         * I want you to know that I have spent 2 hours trying to get it to work
         * I have SCOURED the internet and I have no clue why it doesn't work
         * I have written a different class to try to make it work 3 different times
         * I dont know what is wrong with it
         */
        //face = findViewById(R.id.faceScreen);
        /**
         * update it works now: it was a problem with the xml something was off with the literal view itself
         */

        seekbarR = findViewById(R.id.redSeekBar);
        seekbarR.setOnSeekBarChangeListener(controller);

        seekbarB = findViewById(R.id.blueSeekBar);
        seekbarB.setOnSeekBarChangeListener(controller);

        seekbarG = findViewById(R.id.greenSeekBar);
        seekbarG.setOnSeekBarChangeListener(controller);

        randomFace = findViewById(R.id.randomButton);
        randomFace.setOnClickListener(controller);
    }
    //troubleshooting comment

}