package techkids.vn.everydayquote.fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;


import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import techkids.vn.everydayquote.R;
import techkids.vn.everydayquote.constaints.Constants;
import techkids.vn.everydayquote.jsonmodels.QuoteJSONModel;
import techkids.vn.everydayquote.managers.Preferences;
import techkids.vn.everydayquote.models.Quote;
import techkids.vn.everydayquote.network.QuoteLoader;
import techkids.vn.everydayquote.network.QuoteLoaderFinishHandler;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString();

    @BindView(R.id.imv_nature)
    ImageView imvNature;

    @BindView(R.id.tv_quote)
    TextView tvQuote;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_greetings)
    TextView tvGreetings;

    private Quote quote;

    public QuoteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    void initData() {
        tvGreetings.setText(String.format("Hi, %s", Preferences.getInstance().getUsername()));
        if(isConnectingToInternet()) {
            getDataOnline();
        } else {
            getDataOffline();
        }
    }

    void getDataOnline() {
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(Constants.UNPLASH_IMAGE_API, imvNature);

        QuoteLoader.loadQuote(new QuoteLoaderFinishHandler() {
            @Override
            public void onFinish(final QuoteJSONModel jsonModel) {
                QuoteFragment.this.getActivity()
                        .runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvQuote.setText(Html.fromHtml(jsonModel.getContent()));
                                tvTitle.setText(jsonModel.getTitle());
                            }
                        });
            }
        });
    }

    void getDataOffline() {
        /// imvNature.setImageResource(R.drawable.nature_02);
    }

    private boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager)this.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
