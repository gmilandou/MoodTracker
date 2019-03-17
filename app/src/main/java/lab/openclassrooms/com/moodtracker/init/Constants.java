package lab.openclassrooms.com.moodtracker.init;

//import android.content.Context;
//import android.util.DisplayMetrics;

import lab.openclassrooms.com.moodtracker.R;

/**
 * Created by GMILANDOU on 24/11/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
public class Constants {

    // Arrays of moods
    public final String[] slideMoods = {
            "super_happy",
            "happy",
            "normal",
            "disapointed",
            "sad",
    };


    //Arrays for Slide images
    public static final int[] slideImages = {
            R.mipmap.smiley_sad,
            R.mipmap.smiley_disappointed,
            R.mipmap.smiley_normal,
            R.mipmap.smiley_happy,
            R.mipmap.smiley_super_happy,
    };


    //With multiplier
    public static final float[] widthMultiplier = {
            0.2f,
            0.4f,
            0.6f,
            0.8f,
            1f,
    };

    //Arrays for Slide color
    public static final int[] slideColors = {
            R.color.faded_red,
            R.color.warm_grey,
            R.color.cornflower_blue_65,
            R.color.light_sage,
            R.color.banana_yellow,
    };

    //Pixel converter
  /*  public static float convertPixelsToDp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }*/

}
