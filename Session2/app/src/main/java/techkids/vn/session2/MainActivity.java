package techkids.vn.session2;


import android.hardware.Camera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgFlashLight;
    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1
        getCamera();

        // 2
        setContentView(R.layout.activity_main);

        // 3
        getReferences();

        // 4
        addListeners();
    }

    private void getCamera() {
        try {
            camera = Camera.open();
        }
        catch (RuntimeException e) {
            Log.e(TAG, String.format("Could not open camera: %s", e.getMessage()));
        }
    }

    private void getReferences() {
        tgFlashLight = (ToggleButton) findViewById(R.id.tb_flash_light);
    }

    private void addListeners () {
        tgFlashLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.d(TAG, String.format("tgbFlashLight check changed : %s", isChecked));
                if (isChecked) {
                    // 1
                    Camera.Parameters params = camera.getParameters();

                    // 2
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

                    // 3
                    camera.setParameters(params);
                } else {
                    // 1
                    Camera.Parameters params = camera.getParameters();

                    // 2
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);

                    // 3
                    camera.setParameters(params);
                }
            }
        });
    }

    @Override
    protected void onStart() { //visible
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() { // active
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
