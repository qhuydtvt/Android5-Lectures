package techkids.vn.session3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
//    private Button btnSubmit;
//    private EditText etWeight;
//    private EditText etHeight;

    private final String[] STUDENT_LIST = new String[] {
            "Hậu", "Hùng", "Kiên", "Dương", "Tuyên"
    };

    private ArrayList<String> studentArrayList =
            new ArrayList<>(Arrays.asList(STUDENT_LIST));

    private ListView lvStudent;
    private Button btAdd;
    private EditText etName;
    private ArrayAdapter<String> studentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1
        setContentView(R.layout.activity_main);

        // 2
        getReferences();

        // 3
        setupUIProperties();

        // 4
        addListeners();
    }



    private void setupUIProperties() {
//        btnSubmit.setText(R.string.send_it);
//        etHeight.requestFocus();
//        btnSubmit.setVisibility(View.VISIBLE);

        // 1
        studentListAdapter = new ArrayAdapter<>(
                this,
                R.layout.simple_list_item,
                studentArrayList);

        // 2
        lvStudent.setAdapter(studentListAdapter);
    }

    private void getReferences() {
//        btnSubmit = (Button) findViewById(R.id.btn_submit);
//        etWeight = (EditText) findViewById(R.id.et_weight);
//        etHeight = (EditText)findViewById(R.id.et_height);
        lvStudent = (ListView) findViewById(R.id.lv_student);
        btAdd = (Button) findViewById(R.id.bt_add);
        etName = (EditText) findViewById(R.id.et_name);
    }

    private void addListeners() {
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "btnSubmit: onClick");
//            }
//        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1
                String newName = etName.getText().toString();

                // 2
                studentArrayList.add(newName);
//
//                // 3
                studentListAdapter.notifyDataSetChanged();
//
//                // 4
                etName.setText("");
            }
        });

        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {
                Log.d(TAG, String.format("onItemLongClick: %d", position));
                studentArrayList.remove(position);

                studentListAdapter.notifyDataSetChanged();
                return true;
            }
        });

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("onItemClick: %d", position));
                // 1
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                // 2
                intent.putExtra(DetailActivity.SELECTED_STUDENT_IDX, position);

                // 3
                startActivity(intent);
            }
        });
    }
}
