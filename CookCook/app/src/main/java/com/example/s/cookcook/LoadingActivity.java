package com.example.s.cookcook;

/**
 * Created by Wonkyung on 2015-06-18.
 */
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import java.util.logging.LogRecord;

/**
 * Created by Wonkyung on 2015-06-18.
 */
public class LoadingActivity extends Activity {

    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_load);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2000);
    }
}