package lab.openclassrooms.com.moodtracker.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import lab.openclassrooms.com.moodtracker.init.Constants;
import lab.openclassrooms.com.moodtracker.R;

/**
 * Created by GMILANDOU on 31/08/2018.
 */

@SuppressWarnings("DefaultFileTemplate")
public class MoodPagerAdapter extends PagerAdapter {

    private final Context context;

    public MoodPagerAdapter(Context context) {
        this.context = context;
    }

    private final Constants constants = new Constants();

    @Override
    public int getCount() {
       return constants.slideMoods.length;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slideImage);
        RelativeLayout slideColorView = view.findViewById(R.id.slideColor);

        slideImageView.setImageResource(Constants.slideImages[position]);
        slideColorView.setBackgroundResource(Constants.slideColors[position]);
        slideColorView.setBackgroundResource(Constants.slideColors[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout) object);
    }

}
