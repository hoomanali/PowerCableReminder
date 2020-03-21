package com.alihooman.powercablereminder;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * Monitors device battery's level, charging state, and battery temperature.
 */
class BatteryMonitor {
    private IntentFilter ifilter;
    private Intent batteryStatus;

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
    public boolean batteryFull() {
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
        return status == BatteryManager.BATTERY_STATUS_FULL;
    }
}
