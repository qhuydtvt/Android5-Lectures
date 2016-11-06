package techkids.vn.studyanimation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardFragment extends Fragment {

    private View mRoot;
    private int resColorId = R.color.colorPrimary;

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mRoot = view.findViewById(R.id.root);
        mRoot.setBackgroundResource(resColorId);
        return view;
    }

    public static CardFragment create(int resColorId) {
        CardFragment cardFragment = new CardFragment();
        cardFragment.resColorId = resColorId;
        return cardFragment;
    }
}
