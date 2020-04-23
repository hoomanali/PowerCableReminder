package com.alihooman.powercablereminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BatteryMonitor batteryMonitor;
    TextView batteryFull;
    TextView batteryLevel;
    TextView cableConnected;
    TextView cableNotConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * UI Components
         */
        batteryFull = findViewById(R.id.batteryFull);
        batteryLevel = findViewById(R.id.batteryLevel);
        cableConnected = findViewById(R.id.cabledConnected);
        cableNotConnected = findViewById(R.id.cabledNotConnected);

        /*
         * Objects
         */
        batteryMonitor = new BatteryMonitor(this);

        /*
         * Battery full check
         */
        if(batteryMonitor.isBatteryFull()) {
            batteryFull.setText("Battery full");
        } else {
            batteryFull.setText("Not full");
        }

        /*
         * Battery level check
         */
        String batteryPercentage = "" + batteryMonitor.getBatteryLevel() + "%";
        batteryLevel.setText(batteryPercentage);

        /*
         * Power cable check
         */
        if(batteryMonitor.isPowerCableConnected()) {
            cableConnected.setText("Cable is connected.");
        }
        if(batteryMonitor.isPowerCableDisconnected()) {
            cableNotConnected.setText("Cable is not connected.");
        }
    }

}
