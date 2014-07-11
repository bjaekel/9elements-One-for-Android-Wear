package com.nineelements.nineelementsonewatch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class NineWatchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("9elements One", "onCreate() does nothing since it's a wear app");

        setContentView(R.layout.activity_nine_watch);
    }
}
