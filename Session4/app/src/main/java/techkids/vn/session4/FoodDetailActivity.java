package techkids.vn.session4;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class FoodDetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_FOOD = "Food";
    private static final String TAG = FoodDetailActivity.class.toString();
    public static final int REQUEST_CODE_DEFAULT = 0;

    private Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        getDataFromIntent();
        openDetailFragment();
        getReferences();
        setupUI();
    }

    private void openDetailFragment() {
        FoodDetailFragment foodDetailFragment = new FoodDetailFragment();
        foodDetailFragment.setFood(food);
        foodDetailFragment.setTvAddressOnClickListener(this);

        // 1
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 2
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_food_detail_container, foodDetailFragment);

        // 4
        fragmentTransaction.commit();
    }

    private void setupUI() {

    }

    private void getReferences() {
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra(EXTRA_FOOD);
        Log.d(TAG, food.getTitle());
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "tvAddress onclick Listener");


        Intent intent = new Intent();
        intent.putExtra("Website", food.getAddress());
        setResult(0, intent);


        finish();
    }
}
