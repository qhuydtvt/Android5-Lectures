package techkids.vn.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private EditText etWeight;
    private EditText etHeight;
    private Button btCalculateBMI;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);

        // 1
        setContentView(R.layout.activity_main);

        // 2
        getLayoutReferences();

        // 3
        btCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());

                float bmi = calculateBMI(weight, height);

                tvResult.setText(String.format("Your BMI: %.0f - %s", bmi, getBMIType(bmi)));

                Log.d(TAG, String.format("btCalculateBMI.onClick: %f %f",
                        weight, height));
                Log.d(TAG, String.format("btCalculateBMI.onClick: bmi = %f",
                        bmi));
            }
        });
    }

    String getBMIType(float bmi) {
        if (bmi < 16) {
            return " Severely underweight";
        }
        else if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi < 25) {
            return "Normal";
        }
        else if (bmi < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    float calculateBMI(float weight, float height) {
        height /= 100;
        return weight / (height * height);
    }

    void getLayoutReferences() {
        etHeight = (EditText) findViewById(R.id.et_height);
        etWeight = (EditText) findViewById(R.id.et_weight);
        btCalculateBMI = (Button) findViewById(R.id.btn_calculate_bmi);
        tvResult = (TextView) findViewById(R.id.tv_bmi_result);
    }
}
