package techkids.vn.session4;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    private static final String TAG = FoodListActivity.class.toString();
    private List<Food> foodList;

    private ListView lvFood;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        initData();
        getReferences();
        setupUI();
        addListeners();
    }

    private void initData() {
        foodList = Food.getFoodList();
    }

    private void getReferences() {
        lvFood = (ListView) findViewById(R.id.lv_food);
    }

    private void setupUI() {
        // 1
        ArrayAdapter<Food> foodAdapter = new ArrayAdapter<Food>(
                this, android.R.layout.simple_list_item_1,
                foodList
        );

        // 2
        lvFood.setAdapter(foodAdapter);
    }

    private void addListeners() {
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foodList.get(position);

                if (findViewById(R.id.fl_container) == null) {
                    // Default
                    Intent intent = new Intent(FoodListActivity.this, FoodDetailActivity.class);

                    intent.putExtra(FoodDetailActivity.EXTRA_FOOD, food);

//                    startActivity(intent);
                    startActivityForResult(intent, FoodDetailActivity.REQUEST_CODE_DEFAULT);
                }
                else {
                    // XLarge
                    FoodDetailFragment foodDetailFragment = new FoodDetailFragment();
                    foodDetailFragment.setFood(food);

                    // 1
                    FragmentManager fragmentManager = getSupportFragmentManager();

                    // 2
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fl_container, foodDetailFragment);

                    // 3
                    fragmentTransaction.addToBackStack(null);

                    // 4
                    fragmentTransaction.commit();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data != null) {
            Log.d(TAG, data.getStringExtra("Website"));

            if(resultCode == 0) {
                String googleSearchString = String.format("https://google.com/search?q=%s",
                        data.getStringExtra("Website"));
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(googleSearchString));
                startActivity(intent);
                Log.d(TAG, "ok :(");
            } else {
                Log.d(TAG, "Not ok :(");
            }
        } else {
            Log.d(TAG, "NOthing found");
        }
    }
}
