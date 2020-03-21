package com.alihooman.powercablereminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BatteryMonitor batteryMonitor;
    TextView batteryFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * UI Components
         */
        batteryFull = findViewById(R.id.batteryFull);

        /*
         * Objects
         */
        batteryMonitor = new BatteryMonitor(this);

        //TODO Test battery checks.
        if(batteryMonitor.batteryFull()) {
            batteryFull.setText("Battery full");
        } else {
            batteryFull.setText("Not full");
        }
    }

}
