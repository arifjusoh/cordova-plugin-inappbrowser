package com.eghl.sdk;
/*
 * Created by Jezer Crespo on 2/20/2017.
 */


import android.util.Log;

/**
 * ELogger class that can be shown or hidden.
 * The default is hidden. Error logs cannot be hidden.
 */

public class ELogger {
    public static boolean log = false;


    public static void d(String tag, String message) {
        if(log)
            Log.d(tag, message);
    }
    public static void e(String tag, String message,Throwable e) {
            Log.e(tag, message,e);
    }
    public static void e(String tag, String message) {
            Log.e(tag, message);
    }
    public static void w(String tag, String message) {
        Log.w(tag, message);
    }

    /**
     * Sets the log printing status.
     *
     * @param b whether you want debug logs or not.
     */
    public static void setLoggable(boolean b) {
        log = b;
    }
}
