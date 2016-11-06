package techkids.vn.flickrgetdemo.jsonmodels;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 10/12/16.
 */

public class FlickrFeed {

    @SerializedName("title")
    private String title;

    @SerializedName("items")
    private ArrayList<FlickrItem> items;

    public String getTitle() {
        return title;
    }

    public List<FlickrItem> getItems() {
        return items;
    }
}
