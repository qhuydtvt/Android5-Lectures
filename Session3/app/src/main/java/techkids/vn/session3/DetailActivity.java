package techkids.vn.session3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.toString();
    public static final String SELECTED_STUDENT_IDX = "SelectedStudentIndex";

    private TextView tvDescription;

    private final String[] STUDENT_DESCRIPTION = new String[] {
            "5cm - dài vãi", "Không ạ", "2 giây", "Gay", "Lắc đầu"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        getReferences();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        // 1
        Intent intent = getIntent();

        // 2
        int position = intent.getIntExtra(SELECTED_STUDENT_IDX, -1);

        // 3
        String description = STUDENT_DESCRIPTION[position];

        // 4
        tvDescription.setText(description);

        Log.d(TAG, String.format("intent's extra: %d", position));
    }

    public void getReferences() {
        tvDescription = (TextView) findViewById(R.id.tv_description);
    }
}
