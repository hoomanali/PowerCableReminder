package com.alihooman.powercablereminder;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

import java.io.Console;

/**
 * Monitors device battery's level, charging state, and battery temperature.
 */
class BatteryMonitor {
    private IntentFilter ifilter;
    private Intent batteryStatus;
    private final String TAG = "[BatteryMonitor] ";

    /**
     * Constructor for BatteryMonitor class. Initializes the IntentFilter and battery status
     * intent.
     * @param context The current activity context.
     */
    public BatteryMonitor(Context context) {
        ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        batteryStatus = context.registerReceiver(null, ifilter);
    }

    /**
     * Determines if device battery is full.
     * @return True if battery is full.
     */
    public boolean isBatteryFull() {
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        return status == BatteryManager.BATTERY_STATUS_FULL;
    }

    /**
     * Reterns the battery's current charge as a percentage of capacity.
     * @return Percent charge remaining in battery.
     */
    public float getBatteryLevel() {
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPercent = level * 100 / (float)scale;

        return batteryPercent;
    }

}
