package techkids.vn.studyanimation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by apple on 11/1/16.
 */

public class SimplePagerAdapter extends FragmentPagerAdapter {

    private int[] RES_COLORS = {
            R.color.colorPrimary,
            R.color.colorPrimaryDark,
            R.color.colorAccent,
            R.color.colorWhite
    };
    public SimplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ViewPagerFragment.create(RES_COLORS[position % 4]);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
