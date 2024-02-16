import android.graphics.Canvas;
import android.graphics.Color;

/**
 * @Author Alex Burns
 * Date:2/13/24
 */

public class Face {
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    //calls randomizer on face objects
    public Face(){
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

        //I currently have 9 hairstyle options I was told to make this random
        hairStyle = (int) (Math.random() * 9);
    }

    //will be used to draw on the canvas but was instructed to leave blank for now
    public void onDraw(Canvas c){

    }

    //helper methods for onDraw
    public int getSkinColor(){ return skinColor; }
    public int getEyeColor(){ return eyeColor; }
    public int getHairColor(){ return hairColor; }
    public int getHairStyle(){ return hairStyle; }
}
