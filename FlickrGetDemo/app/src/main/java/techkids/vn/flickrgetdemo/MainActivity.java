package techkids.vn.flickrgetdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.flickrgetdemo.jsonmodels.FlickrFeed;
import techkids.vn.flickrgetdemo.jsonmodels.FlickrItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private ListView lvFlickr;
    private ArrayAdapter<FlickrItem> feedArrayAdapter;
    private ArrayList<FlickrItem> flickrItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickrItems = new ArrayList<>();
        getReferences();
        setupUI();
        getContent();
    }

    private void setupUI() {
        feedArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                flickrItems);
        lvFlickr.setAdapter(feedArrayAdapter);
    }

    private void getReferences() {
        lvFlickr = (ListView)findViewById(R.id.lv_flickr);
    }

    public void getContent() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request
                .Builder()
                .url("http://www.flickr.com/services/feeds/photos_public.gne?tags=girl&format=json&title=girl")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string()
                        .replace("jsonFlickrFeed(","")
                        .replace("})", "}");

                final FlickrFeed flickrFeed = new Gson().fromJson(body, FlickrFeed.class);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(FlickrItem item : flickrFeed.getItems()) {
                            Log.d(TAG, item.getImageLink());
                            flickrItems.add(item);
                            feedArrayAdapter.notifyDataSetChanged();
                        }
                    }
                });

//                Log.d(TAG, flickrFeed.getTitle());
            }
        });
    }
}
