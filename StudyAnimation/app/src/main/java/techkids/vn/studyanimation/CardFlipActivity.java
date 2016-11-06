package techkids.vn.studyanimation;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CardFlipActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, new CardFragment())
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_menu, menu);
        menu.findItem(R.id.mni_animate).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                flip();
                return false;
            }
        });
        return true;
    }

    public void flip() {
        CardFragment cardFragment = CardFragment.create(R.color.colorAccent);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();

        fragmentTransaction
                .setCustomAnimations(
                        R.anim.card_flip_left_in,
                        R.anim.card_flip_left_out);
        fragmentTransaction.replace(R.id.fl_container, cardFragment);

        fragmentTransaction.commit();
    }
}
