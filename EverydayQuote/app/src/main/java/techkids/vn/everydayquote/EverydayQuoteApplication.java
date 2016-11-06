package techkids.vn.everydayquote;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import techkids.vn.everydayquote.managers.Preferences;

/**
 * Created by apple on 10/11/16.
 */

public class EverydayQuoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        Preferences.init(this);
    }
}
