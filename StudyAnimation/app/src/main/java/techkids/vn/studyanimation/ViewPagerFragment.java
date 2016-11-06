package techkids.vn.studyanimation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {

    private View mRoot;
    private int resColor;

    public ViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        mRoot = view.findViewById(R.id.root);
        mRoot.setBackgroundResource(resColor);
        return view;
    }

    public static ViewPagerFragment create(int resColor) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        viewPagerFragment.resColor = resColor;
        return viewPagerFragment;
    }
}
