package techkids.vn.dailyquote.fragments;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.dailyquote.R;
import techkids.vn.dailyquote.constants.Constants;
import techkids.vn.dailyquote.jsonmodels.QuoteJSONModel;
import techkids.vn.dailyquote.managers.DbHelper;
import techkids.vn.dailyquote.managers.FileManager;
import techkids.vn.dailyquote.managers.Network;
import techkids.vn.dailyquote.managers.Preference;
import techkids.vn.dailyquote.models.AlertDialogEvent;
import techkids.vn.dailyquote.models.Quote;
import techkids.vn.dailyquote.models.ServiceEvent;
import techkids.vn.dailyquote.services.QuoteDownloadService;
import techkids.vn.dailyquote.services.UnplashDownloadService;

import static techkids.vn.dailyquote.constants.Constants.QUOTE_API;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString();

    @BindView(R.id.imv_background)
    ImageView imvBackground;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_username)
    TextView tvUserName;

    private Random random;


    public QuoteFragment() {
        // Required empty public constructor
        random = new Random();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }

    private void updateQuote(final QuoteJSONModel quoteJSONMOdel) {
        Activity parent = getActivity();

        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(quoteJSONMOdel.getTitle());
                tvContent.setText(Html.fromHtml(quoteJSONMOdel.getContent()));
            }
        });
    }

    private void setupUI() {
        // Username
        tvUserName.setText(String.format("Hi, %s", Preference.getInstance().getUsername()));

        if (Network.getInstance().isConnectedToInternet()) {
            Log.d(TAG, "Getting data online");
            getDataOnline();
        } else {
            Log.d(TAG, "Getting data offline");
            getDataOffline();
        }
    }

    private void getDataOnline() {
        loadImageOnline();
        loadQuoteOnline();
        runDownloadImageTasks();
        runDownloadQuoteTasks();
    }

    private void getDataOffline() {
        loadQuoteOffline();
        loadImageOffline();
    }

    private void loadImageOffline() {
        int imageCount = Preference.getInstance().getImageCount();
        if (imageCount > 0) {
            int imageIndex = random.nextInt(imageCount);
            File imageFile = FileManager.getInstance().getUnplashImage(imageIndex);
            ImageLoader.getInstance().displayImage(
                    (Uri.fromFile(imageFile)).toString(),
                    imvBackground
            );
        }
    }

    private void loadQuoteOffline() {
        Quote quote = DbHelper.getInstance().selectRandomQuote();
        if(quote != null) {
            tvContent.setText(Html.fromHtml(quote.getContent()));
            tvTitle.setText(quote.getTitle());
        } else {
            AlertDialogEvent alertDialogEvent = new AlertDialogEvent(
                    "No internet connection",
                    "Please connect to a network",
                    true,
                    "OK"
            );
            EventBus.getDefault().post(alertDialogEvent);
        }
    }

    private void loadQuoteOnline() {
        ImageLoader.getInstance().displayImage(
                Constants.UNPLASH_API,
                imvBackground
        );
    }

    private void loadImageOnline() {
        // 1 Create Client
        OkHttpClient client = new OkHttpClient();

        // 2 Create Request
        Request request = new Request
                .Builder()
                .url(QUOTE_API)
                .build();

        // 3 Send and handle
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 4
                Log.d(TAG, "onResponse");
                String bodyString = response.body().string();
                Log.d(TAG, String.format("bodyString: %s", bodyString));

                // Create Gson
                Gson gson = new Gson();

                // Parse
                QuoteJSONModel[] quotes = gson.fromJson(bodyString, QuoteJSONModel[].class);

                if (quotes.length > 0) {
                    QuoteFragment.this.updateQuote(quotes[0]);
                }
            }
        });
    }

    private void runDownloadImageTasks() {
        if (Preference.getInstance().getImageCount() == - 1) {
            ServiceEvent serviceEvent = new ServiceEvent(UnplashDownloadService.class);
            EventBus.getDefault().post(serviceEvent);
        }
    }

    private void runDownloadQuoteTasks() {
        ServiceEvent serviceEvent = new ServiceEvent(QuoteDownloadService.class);
        EventBus.getDefault().post(serviceEvent);
    }
}
