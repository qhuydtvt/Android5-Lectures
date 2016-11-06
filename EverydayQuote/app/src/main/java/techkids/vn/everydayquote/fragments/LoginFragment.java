package techkids.vn.everydayquote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import techkids.vn.everydayquote.R;
import techkids.vn.everydayquote.managers.Preferences;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.bt_next)
    Button btNext;

    @BindView(R.id.et_user_name)
    EditText etUserName;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.bt_next)
    public void onNextClick(View view) {
        String userName = etUserName.getText().toString();
        Preferences.getInstance().setUserName(userName);

        FragmentEvent fragmentEvent = new FragmentEvent(
                new QuoteFragment(),
                false
        );

        EventBus.getDefault().post(fragmentEvent);
    }
}
