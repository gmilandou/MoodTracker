package lab.openclassrooms.com.moodtracker.ui;


import android.support.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import lab.openclassrooms.com.moodtracker.R;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by GMILANDOU on 20/03/2019.
 */
@SuppressWarnings("DefaultFileTemplate")
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void checkButtonClickHistory() {

        onView(withId(R.id.history)).check(matches(isClickable()));
    }


    @Test
    public void checkButtonClickAddMood() {

        onView(withId(R.id.addMood)).check(matches(isClickable()));

    }

}