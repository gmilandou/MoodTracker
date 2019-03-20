package lab.openclassrooms.com.moodtracker.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import lab.openclassrooms.com.moodtracker.init.Constants;
import lab.openclassrooms.com.moodtracker.R;
import lab.openclassrooms.com.moodtracker.model.Mood;

public class MoodHistoryAdapter extends RecyclerView.Adapter<MoodHistoryAdapter.myViewHolder> {

    private final List<Mood> moodlist;
    private final Context context;
    private final int height;
    private final int width;

    public class myViewHolder extends RecyclerView.ViewHolder {
        public final ImageView moodMessage;
        public final TextView moodId;


        public myViewHolder(View view) {
            super(view);
            moodMessage = view.findViewById(R.id.moodcomment);
            moodId = view.findViewById(R.id.moodtime);

        }
    }


    public MoodHistoryAdapter(List<Mood> moodlist, int height, int width, Context context) {
        this.moodlist = moodlist;
        this.context = context;
        this.height = height;
        this.width = width;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mood_layout, parent, false);

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        final Mood mood = moodlist.get(position);


        holder.itemView.getLayoutParams().height = height/7;

        if (mood.getMoodMessage() == null || mood.getMoodMessage().isEmpty()) {
            holder.moodMessage.setVisibility(View.GONE);
        }

        if (mood.getMoodId() != -1) {
            holder.itemView.setBackgroundResource(Constants.slideColors[mood.getMoodId()]);
            holder.itemView.getLayoutParams().width = (int) (Constants.widthMultiplier[mood.getMoodId()] * width);
        }

        holder.moodMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mood.getMoodMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //holder.moodId.setText(String.valueOf(mood.getMoodId()));
        String dayText = context.getString(getDay(position));

        holder.moodId.setText(dayText);

    }

    private int getDay(int index) {
        switch (index) {
            case 1:
                return R.string.days_ago_one;
            case 2:
                return R.string.days_ago_two;
            case 3:
                return R.string.days_ago_three;
            case 4:
                return R.string.days_ago_four;
            case 5:
                return R.string.days_ago_five;
            case 6:
                return R.string.days_ago_six;
            default:
                return R.string.days_ago_today;
        }
    }

    @Override
    public int getItemCount() {
        return moodlist.size();
    }
}