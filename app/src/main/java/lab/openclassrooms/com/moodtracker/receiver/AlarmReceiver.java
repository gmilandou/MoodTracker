package lab.openclassrooms.com.moodtracker.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by gmilandou on 09/02/2019.
 */

@SuppressWarnings("DefaultFileTemplate")
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences preferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        //Retriving the existing mood before adding new mood
        String dayOneMood = preferences.getString("mMood1", null);
        String dayTwoMood = preferences.getString("mMood2", null);
        String dayThreeMood = preferences.getString("mMood3", null);
        String dayFourMood = preferences.getString("mMood4", null);
        String dayFiveMood = preferences.getString("mMood5", null);
        String daySixMood = preferences.getString("mMood6", null);
        String daySevenMood;

        //Retrieving existing colors
        int dayOneColor = preferences.getInt("mMood1Color", -1);
        int dayTwoColor = preferences.getInt("mMood2Color", -1);
        int dayThreeColor = preferences.getInt("mMood3Color", -1);
        int dayFourColor = preferences.getInt("mMood4Color", -1);
        int dayFiveColor = preferences.getInt("mMood5Color", -1);
        int daySixColor = preferences.getInt("mMood6Color", -1);
        int daySevenColor;

        daySevenMood = daySixMood;
        daySixMood = dayFiveMood;
        dayFiveMood = dayFourMood;
        dayFourMood = dayThreeMood;
        dayThreeMood = dayTwoMood;
        dayTwoMood = dayOneMood;

        ///Colors
        daySevenColor = daySixColor;
        daySixColor = dayFiveColor;
        dayFiveColor = dayFourColor;
        dayFourColor = dayThreeColor;
        dayThreeColor = dayTwoColor;
        dayTwoColor = dayOneColor;
        dayOneColor = -1;

        //Update moods
        editor.putString("mMood7", daySevenMood);
        editor.putString("mMood6", daySixMood);
        editor.putString("mMood5", dayFiveMood);
        editor.putString("mMood4", dayFourMood);
        editor.putString("mMood3", dayThreeMood);
        editor.putString("mMood2", dayTwoMood);
        editor.putString("mMood1", null);
        //Saving Mood colors
        editor.putInt("mMood7Color", daySevenColor);
        editor.putInt("mMood6Color", daySixColor);
        editor.putInt("mMood5Color", dayFiveColor);
        editor.putInt("mMood4Color", dayFourColor);
        editor.putInt("mMood3Color", dayThreeColor);
        editor.putInt("mMood2Color", dayTwoColor);
        editor.putInt("mMood1Color", dayOneColor);
        Log.d("Information:", "onReceive: Swap mood completed");
        editor.apply();
    }
}