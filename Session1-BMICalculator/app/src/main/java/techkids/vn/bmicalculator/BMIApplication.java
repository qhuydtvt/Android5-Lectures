package techkids.vn.bmicalculator;

import android.app.Application;
import android.util.Log;

/**
 * Created by apple on 9/11/16.
 */
public class BMIApplication extends Application {

    private static final String TAG = BMIApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();

        // Confgure database, sharedefault
        Log.d(TAG, "onCreate");
    }
}
