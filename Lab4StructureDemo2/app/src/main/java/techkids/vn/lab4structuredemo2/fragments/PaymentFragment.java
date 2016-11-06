package techkids.vn.lab4structuredemo2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techkids.vn.lab4structuredemo2.MainActivity;
import techkids.vn.lab4structuredemo2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment {


    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).showActionBar(true);
        ((MainActivity)getActivity()).showSendMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

}
