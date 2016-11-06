package techkids.vn.everydayquote.network;

import android.text.Html;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.everydayquote.constaints.Constants;
import techkids.vn.everydayquote.fragments.QuoteFragment;
import techkids.vn.everydayquote.jsonmodels.QuoteJSONModel;

/**
 * Created by apple on 10/11/16.
 */



public class QuoteLoader {
    private static OkHttpClient client = new OkHttpClient();
    public static void loadQuote(final QuoteLoaderFinishHandler handler) {
        Request request = new Request.Builder().url(Constants.QUOTE_API).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                QuoteJSONModel[] quoteJSONModels = new Gson().fromJson(body, QuoteJSONModel[].class);
                if(quoteJSONModels.length > 0 ) {
                    QuoteJSONModel quoteJSONModel = quoteJSONModels[0];
                    handler.onFinish(quoteJSONModel);
                }
            }
        });
    }
}
