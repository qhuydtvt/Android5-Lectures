package techkids.vn.studyanimation;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new SimplePagerAdapter(this.getSupportFragmentManager()));
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }
}
