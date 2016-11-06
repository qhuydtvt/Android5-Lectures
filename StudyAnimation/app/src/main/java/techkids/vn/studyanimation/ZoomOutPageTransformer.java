package techkids.vn.studyanimation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by apple on 11/1/16.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if(position < -1) {
            page.setAlpha(0);
            // Off page (left)
        } else if (position < 1) {
            // In Page
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        } else {
            // Off page (right)
            page.setAlpha(0);
        }
    }
}
