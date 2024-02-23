package com.example.facemaker_alexburns;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * @author Alex Burns
 * Date:2/13/24
 */

public class Face extends SurfaceView{
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    Paint randomEyeColor = new Paint();
    Paint randomHairColor = new Paint();
    Paint randomSkinColor = new Paint();

    //calls randomizer on face objects
    public Face(Context context, AttributeSet attrs){
        super(context, attrs);

        //it said to do this in the lab so I am doing it here as well
        setWillNotDraw(false);
        this.randomizes();

    }
    public void randomizes(){

        //assigns random hex color to skinColor
        skinColor = Color.rgb((int) (Math.random() * 256),
                              (int) (Math.random() * 256),
                              (int) (Math.random() * 256));

        //assigns random hex color to eyeColor
        eyeColor = Color.rgb((int) (Math.random() * 256),
                             (int) (Math.random() * 256),
                             (int) (Math.random() * 256));

        //assigns random hex color to hairColor
        hairColor = Color.rgb((int) (Math.random() * 256),
                              (int) (Math.random() * 256),
                              (int) (Math.random() * 256));

        //I currently have 4 hairstyle options I was told to make this random
        hairStyle = (int) (Math.random() * 4);

        //assigns random color to a paint
        this.randomEyeColor.setColor(eyeColor);
        this.randomHairColor.setColor(hairColor);
        this.randomSkinColor.setColor(skinColor);
    }

    //will be used to draw on the canvas but was instructed to leave blank for now
    public void onDraw(Canvas c){
        //set colors for drawing
        this.randomSkinColor.setColor(skinColor);
        this.randomEyeColor.setColor(eyeColor);
        this.randomHairColor.setColor(hairColor);

        //the head
        c.drawCircle(550.0f, 600.0f, 250.0f, randomSkinColor);

        //the eyes
        c.drawCircle(610.0f, 550.0f, 30.0f, randomEyeColor);
        c.drawCircle(490.0f, 550.0f, 30.0f, randomEyeColor);

        //mouth
        RectF foo = new RectF(480.0f, 600.0f, 620.0f, 700.0f);
        c.drawArc(foo, 0.0f, 180.0f, false, randomEyeColor);

        drawHair(c);
    }

    public void drawHair(Canvas c) {
        if (this.hairStyle == 1){
            //top
            c.drawRect(250.0f, 300.0f, 800.0f, 470.0f, randomHairColor);
            //left side
            c.drawRect(250.0f, 300.0f, 350.0f, 1000.0f, randomHairColor);
            //right side
            c.drawRect(750.0f, 300.0f, 850.0f, 1000.0f, randomHairColor);
        }
        else if (this.hairStyle == 2){
            //top
            c.drawRect(250.0f, 300.0f, 800.0f, 470.0f, randomHairColor);
            //left side
            c.drawRect(250.0f, 300.0f, 350.0f, 1500.0f, randomHairColor);
            //right side
            c.drawRect(750.0f, 300.0f, 850.0f, 1500.0f, randomHairColor);
        }
        else if (this.hairStyle == 3){
            //bowl cut (that slightly defys gravity)
            RectF foo = new RectF(300.0f, 300.0f, 820.0f, 600.0f);
            c.drawArc(foo, 180.0f, 180.0f, false, randomEyeColor);
        }

    }

    //helper methods for onDraw
    public int getSkinColor(){ return skinColor; }
    public int getEyeColor(){ return eyeColor; }
    public int getHairColor(){ return hairColor; }
    public int getHairStyle(){ return hairStyle; }
    public void setHairStyle(int initHairSt){
        this.hairStyle = initHairSt;
    }
    public void setHairColor(int initHairC) { this.hairColor = initHairC;}
    public void setEyeColor(int initEyeC) {this.eyeColor = initEyeC;}
    public void setSkinColor(int initSkinC) {this.skinColor = initSkinC;}
}
