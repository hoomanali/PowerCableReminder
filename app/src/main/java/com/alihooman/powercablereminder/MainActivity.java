package com.alihooman.powercablereminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BatteryMonitor batteryMonitor;
    TextView batteryFull;
    TextView batteryLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * UI Components
         */
        batteryFull = findViewById(R.id.batteryFull);
        batteryLevel = findViewById(R.id.batteryLevel);

        /*
         * Objects
         */
        batteryMonitor = new BatteryMonitor(this);

        //TODO Test battery checks.
        if(batteryMonitor.isBatteryFull()) {
            batteryFull.setText("Battery full");
        } else {
            batteryFull.setText("Not full");
        }

        String batteryPercentage = "" + batteryMonitor.getBatteryLevel() + "%";
        batteryLevel.setText(batteryPercentage);
    }

}
