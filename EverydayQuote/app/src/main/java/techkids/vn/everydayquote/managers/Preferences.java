package techkids.vn.everydayquote.managers;

import android.content.Context;
import android.content.SharedPreferences;

import techkids.vn.everydayquote.jsonmodels.QuoteJSONModel;
import techkids.vn.everydayquote.models.Quote;

/**
 * Created by apple on 10/11/16.
 */

public class Preferences {
    private SharedPreferences sharedPreferences;
    private final static String PREF_NAME = "quote";
    private final static String IMAGE_COUNT_KEY = "ImageCount";
    private final static String USER_NAME_KEY = "UserName";

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public int getImageCount() {
        int imageCount = sharedPreferences.getInt(IMAGE_COUNT_KEY, -1);
        if (imageCount == -1) {
            imageCount = 0;
        }
        return imageCount;
    }

    public void updateImageCount(int imageCount) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(IMAGE_COUNT_KEY, imageCount);
        editor.commit();
    }

    public String getUsername() {
        String userName = sharedPreferences.getString(USER_NAME_KEY, null);
        return userName;
    }

    public void setUserName(String userName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME_KEY, userName);
        editor.commit();
    }

    private static Preferences preferences;
    public static void init(Context context) {
        if(preferences == null) {
            preferences = new Preferences(context);
        }
    }

    public static Preferences getInstance() {
        return preferences;
    }
}
