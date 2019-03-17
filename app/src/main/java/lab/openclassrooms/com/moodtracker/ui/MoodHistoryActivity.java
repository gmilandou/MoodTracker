package lab.openclassrooms.com.moodtracker.ui;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.List;
import lab.openclassrooms.com.moodtracker.R;
import lab.openclassrooms.com.moodtracker.model.Mood;
import lab.openclassrooms.com.moodtracker.view.MoodHistoryAdapter;

public class MoodHistoryActivity extends AppCompatActivity {


    // --Commented out by Inspection (10/03/2019 19:38):MoodHistoryActivity history_layout;
    // --Commented out by Inspection (10/03/2019 19:38):Mood moodItem;

    // --Commented out by Inspection (10/03/2019 19:38):private ArrayList<Integer> moodColor = new ArrayList<>();
    // --Commented out by Inspection (10/03/2019 19:38):private ArrayList<String> mMsg = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_layout);
        initRecyclerView();

    }

    //Fetch the ToolBar Height
    private int getToolBarHeight() {
        int[] attrs = new int[] {R.attr.actionBarSize};
        TypedArray ta = obtainStyledAttributes(attrs);
        int toolBarHeight = ta.getDimensionPixelSize(0, -1);
        ta.recycle();
        return toolBarHeight;
    }

    //Fetch the status of the Bar height
    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }



    private void initRecyclerView() {

        SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);//getPreferences(MODE_PRIVATE);

        List<Mood> moodList = new ArrayList<>();

        moodList.add(new Mood(preferences.getString("mMood1", null), preferences.getInt("mMood1Color", -1)));
        moodList.add(new Mood(preferences.getString("mMood2", null), preferences.getInt("mMood2Color", -1)));
        moodList.add(new Mood(preferences.getString("mMood3", null), preferences.getInt("mMood3Color", -1)));
        moodList.add(new Mood(preferences.getString("mMood4", null), preferences.getInt("mMood4Color", -1)));
        moodList.add(new Mood(preferences.getString("mMood5", null), preferences.getInt("mMood5Color", -1)));
        moodList.add(new Mood(preferences.getString("mMood6", null), preferences.getInt("mMood6Color", -1)));
        moodList.add(new Mood(preferences.getString("mMood7", null), preferences.getInt("mMood7Color", -1)));


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        int AvailableHeight = height - getToolBarHeight() - getStatusBarHeight();

        RecyclerView recyclerView = findViewById(R.id.history);
        MoodHistoryAdapter adapter = new MoodHistoryAdapter(moodList, AvailableHeight, width,  MoodHistoryActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
