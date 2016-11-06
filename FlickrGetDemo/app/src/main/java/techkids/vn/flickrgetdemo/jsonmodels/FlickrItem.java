package techkids.vn.flickrgetdemo.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 10/12/16.
 */

public class FlickrItem {
    @SerializedName("title")
    private String title;

    @SerializedName("date_taken")
    private String dateTaken;

    @SerializedName("media")
    private Media media;

    public String getImageLink() {
        return media.getLink();
    }

    private class Media {
        @SerializedName("m")
        private String link;

        public String getLink() {
            return link;
        }
    }

    @Override
    public String toString() {
        return getImageLink();
    }
}
