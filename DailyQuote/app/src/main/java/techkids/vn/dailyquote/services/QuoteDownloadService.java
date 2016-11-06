package techkids.vn.dailyquote.services;

import android.app.IntentService;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.dailyquote.constants.Constants;
import techkids.vn.dailyquote.jsonmodels.QuoteJSONModel;
import techkids.vn.dailyquote.managers.DbHelper;
import techkids.vn.dailyquote.models.Quote;

/**
 * Created by apple on 10/13/16.
 */

public class QuoteDownloadService extends IntentService {
    private static final int QUOTE_NUM = 10;
    private static final String TAG = QuoteDownloadService.class.toString();

    public QuoteDownloadService(){
        super(null);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request
                .Builder()
                .url(Constants.QUOTE_API_10)
                .build();
        try {
            Log.d(TAG, "Trying to connect");
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            QuoteJSONModel[] quoteJSONModels = new Gson().fromJson(body, QuoteJSONModel[].class);
            for(QuoteJSONModel quoteJSONModel : quoteJSONModels) {
                DbHelper.getInstance().insertQuote(
                        new Quote(quoteJSONModel.getContent(),
                        quoteJSONModel.getTitle()));
            }
        } catch (IOException e) {
            Log.d(TAG, String.format("Failed to connect %s", e));
            e.printStackTrace();
        }
    }
}
