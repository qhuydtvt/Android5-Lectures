package techkids.vn.everydayquote.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by apple on 10/11/16.
 */

public class FragmentEvent {
    private Fragment fragment;
    private boolean addToBackstack;

    public FragmentEvent(Fragment fragment, boolean addToBackstack) {
        this.fragment = fragment;
        this.addToBackstack = addToBackstack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAddToBackstack() {
        return addToBackstack;
    }

    public void setAddToBackstack(boolean addToBackstack) {
        this.addToBackstack = addToBackstack;
    }
}
