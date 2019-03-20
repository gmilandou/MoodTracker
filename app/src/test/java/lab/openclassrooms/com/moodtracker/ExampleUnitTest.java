package lab.openclassrooms.com.moodtracker;

import org.junit.Test;

import lab.openclassrooms.com.moodtracker.init.Constants;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void compareSizeMultiplierColor() throws Exception {
        assertEquals(Constants.widthMultiplier.length, Constants.slideColors.length);
    }

    @Test
    public void compareSizeMultiplierImage() throws Exception {
        assertEquals(Constants.widthMultiplier.length, Constants.slideImages.length);
    }


}


