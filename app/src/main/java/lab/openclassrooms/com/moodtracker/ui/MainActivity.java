package lab.openclassrooms.com.moodtracker.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.ShareActionProvider;
import android.widget.Toast;
//import java.util.ArrayList;
import java.util.Calendar;
//import java.util.List;
import lab.openclassrooms.com.moodtracker.R;
//import lab.openclassrooms.com.moodtracker.init.Constants;
//import lab.openclassrooms.com.moodtracker.model.Mood;
import lab.openclassrooms.com.moodtracker.receiver.AlarmReceiver;
import lab.openclassrooms.com.moodtracker.view.MoodPagerAdapter;

@SuppressWarnings("SameReturnValue")
public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        MoodPagerAdapter sliderAdapter = new MoodPagerAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        viewPager.setCurrentItem(3);

        initMoodHistory();
    }


    public void history(final View view) {
        Intent intent = new Intent(this, MoodHistoryActivity.class);
        this.startActivity(intent);
    }


    ///Getting the user Mood comments for storage.

    @SuppressWarnings("SameReturnValue")
    public String myMood(final View view) {
        input = new EditText(this);
        //final List<Mood> moodList = new ArrayList<>();
        new AlertDialog.Builder(this)
                .setMessage("Comment")

                .setView(input)

                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Insertion of Mood using shared preferences
                        SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);//getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        int newColor = viewPager.getCurrentItem();
                        String newMood = input.getText().toString();

                        editor.putString("mMood1", newMood);
                        editor.putInt("mMood1Color", newColor);
                        editor.apply();

                    }
                }).create().show();

        return "";
    }

    //Initialising moodHistory
    private void initMoodHistory() {
        initAlarmManager();
    }

    private void initAlarmManager() {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmPendingIntent);

        }
    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_icon, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        SharedPreferences preferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String dayOneMood = preferences.getString("mMood1", null);

        if (dayOneMood == null) {
            Toast.makeText(this, "You do not have a mood for today!", Toast.LENGTH_SHORT).show();

            return true;
        }

        switch (item.getItemId()) {
            case R.id.share_button:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Hy buddy this is my mood: " + dayOneMood;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Today's Mood");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Share via "));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}