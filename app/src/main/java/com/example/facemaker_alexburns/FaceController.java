package com.example.facemaker_alexburns;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements View.OnClickListener,
        AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener {
    private MainActivity main;
    private Face face;

    public FaceController(Face face, MainActivity myactivity){
        this.face = face;
        this.main = myactivity;
    }

    public void onCheckedChanged(RadioGroup group, int checkedId){
        //get checked button
        RadioButton checkedPart = group.findViewById(checkedId);
        boolean isChecked = checkedPart.isChecked();
        if (isChecked)
        {
            //update rgb seekbars to match colors of specific buttons
            if (checkedPart.getId() == R.id.hairButton){
                updateColors(face.getHairColor());
            }
            else if (checkedPart.getId() == R.id.eyeButton){
                updateColors(face.getEyeColor());
            }
            else if (checkedPart.getId() == R.id.skinButton){
                updateColors(face.getSkinColor());
            }
            this.face.invalidate();

        }

    }
    //update all colors
    public void updateColors(int color){
        updateColor(R.id.redSeekBar, getRed(color));
        updateColor(R.id.greenSeekBar, getGreen(color));
        updateColor(R.id.blueSeekBar, getBlue(color));
    }
    //check one color by giving it an id
    public void updateColor(int id, int color){
        SeekBar seekbar = main.findViewById(id);
        seekbar.setProgress(color);
    }




    @Override
    public void onClick(View v) {
        this.face.randomizes();

        //get radiogroup
        RadioGroup faceparts = main.findViewById(R.id.faceparts);

        //figure out which button is checked and update
        int checkedId = faceparts.getCheckedRadioButtonId();
        onCheckedChanged(faceparts, checkedId);

        //update spinner
        Spinner spinner = main.findViewById(R.id.hairSpinner);
        spinner.setSelection(this.face.getHairStyle());

        this.face.invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        face.setHairStyle(position);
        face.invalidate();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        RadioGroup parts = main.findViewById(R.id.faceparts);
        int checkedID = parts.getCheckedRadioButtonId();
        int seekBarId = seekBar.getId();

        //update buttons
        if (checkedID == R.id.hairButton){
            this.face.hairColor = mixColor(seekBarId, progress, this.face.getHairColor());
            this.face.randomHairColor.setColor(this.face.getHairColor());
        }
        else if (checkedID == R.id.eyeButton){
            this.face.eyeColor = mixColor(seekBarId, progress, this.face.getEyeColor());
            this.face.randomEyeColor.setColor(this.face.getEyeColor());
        }
        else if (checkedID == R.id.skinButton){
            this.face.skinColor = mixColor(seekBarId, progress, this.face.getSkinColor());
            this.face.randomSkinColor.setColor(this.face.getSkinColor());
        }

        face.invalidate();
    }

    public int mixColor(int seekBarId, int progress, int color){
        if (seekBarId == R.id.redSeekBar){
            return Color.argb(255, progress, getGreen(color), getBlue(color));
        }
        else if (seekBarId == R.id.greenSeekBar){
            return Color.argb(255,  getRed(color), progress, getBlue(color));
        }
        else if (seekBarId == R.id.blueSeekBar){
            return Color.argb(255,  getRed(color), getGreen(color), progress);
        }
        return color;
    }

    // required methods for class implementation, not used
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
    public int getRed(int color){
        return  (color >> 16) & 255;
    }

    public int getGreen(int color){
        return  (color >> 8) & 255;
    }

    public int getBlue(int color){
        return color & 255;
    }
}