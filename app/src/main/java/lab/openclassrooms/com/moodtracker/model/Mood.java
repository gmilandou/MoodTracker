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

   /* public void setMoodId(int moodId) {
        this.moodId = moodId;
    }*/

    public String getMoodMessage() {

        return moodMessage;
    }

    /*public void setMoodMessage(String moodMessage) {

        this.moodMessage = moodMessage;
    }*/
}