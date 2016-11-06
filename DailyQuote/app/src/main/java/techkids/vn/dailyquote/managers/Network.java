package techkids.vn.dailyquote.managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import okhttp3.Request;

/**
 * Created by apple on 10/13/16.
 */

public class Network {
    private ConnectivityManager connectivityManager;
    private Network(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }


    public boolean isConnectedToInternet() {
        boolean connected = false;
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()){
                connected = true;
            }
        }
        return connected;
    }

    private static Network instance;
    public static Network getInstance() {
        return instance;
    }
    public static void init(Context context) {
        instance = new Network(context);
    }
}
