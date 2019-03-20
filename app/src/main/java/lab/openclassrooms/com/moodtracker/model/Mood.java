package lab.openclassrooms.com.moodtracker.model;

public class Mood {

    //Mood Constractor
    public Mood(String moodMessage, int moodId) {
        this.moodMessage = moodMessage;
        this.moodId = moodId;
    }

    private final String moodMessage;
    private final int moodId;

    //Get mood Id
    public int getMoodId() {
        return moodId;
    }

    public String getMoodMessage() {

        return moodMessage;
    }
}