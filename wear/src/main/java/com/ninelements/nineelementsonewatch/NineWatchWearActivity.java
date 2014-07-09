package com.ninelements.nineelementsonewatch;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ninelements.nineelementsonewatch.models.TimeToWordsEnglish;

import java.lang.*;
import java.util.Calendar;

import firstwatch.com.nineelements.nineelementsone.R;

public class NineWatchWearActivity extends Activity {
    private final static IntentFilter intentFilter;
    private boolean isDimmed = false;
    private TimeToWordsEnglish timeToWords;
    private com.ninelements.nineelementsonewatch.models.Character[][] characterArray;
    private TextView[][] textViews;

    static {
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        intentFilter.addAction(Intent.ACTION_TIME_CHANGED);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("9elements One", "onCreate();");

        createLayout();

        timeInfoReceiver.onReceive(this, registerReceiver(null, intentFilter));
        registerReceiver(timeInfoReceiver, intentFilter);

    }

    public BroadcastReceiver timeInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent intent) {
            Log.v("WatchFace", "timeChanged();");
            updateLayout();
        }
    };

    public void createLayout() {
        timeToWords = new TimeToWordsEnglish();
        timeToWords.setModelTime(Calendar.getInstance());
        characterArray = timeToWords.getCharacterArray();

        setContentView(R.layout.activity_nine_watch_wear);

        LinearLayout verticalLinearLayout = (LinearLayout)findViewById(R.id.verticalLinearLayout);

        textViews = new TextView[timeToWords.getWidth()][timeToWords.getHeight()];

        for (int i = 0; i < timeToWords.getHeight(); i++) {
            LinearLayout horizontalLinearLayout = new LinearLayout(this);

            horizontalLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            horizontalLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            verticalLinearLayout.addView(horizontalLinearLayout);

            for (int j = 0; j < timeToWords.getWidth(); j++) {

                TextView textView = new TextView(this);
                com.ninelements.nineelementsonewatch.models.Character character = characterArray[i][j];
                textView.setTextSize(15);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.weight = 1;

                textView.setLayoutParams(params);
                updateTextViewForCharacter(textView, character);

                horizontalLinearLayout.addView(textView);
                textViews[j][i] = textView;

            }
        }
    }

    public void updateLayout() {
        timeToWords.setModelTime(Calendar.getInstance());
        characterArray = timeToWords.getCharacterArray();

        for (int i = 0; i < timeToWords.getHeight(); i++) {
            for (int j = 0; j < timeToWords.getWidth(); j++) {
                com.ninelements.nineelementsonewatch.models.Character character = characterArray[i][j];
                TextView textView = textViews[j][i];

                updateTextViewForCharacter(textView, character);
            }
        }
    }

    public void updateTextViewForCharacter(TextView textView, com.ninelements.nineelementsonewatch.models.Character character) {
        textView.setText("" + character.getCharacter());

        if(character.isOn()) {
            textView.setTextColor(Color.parseColor("#ff0000"));
        } else {
            if(!isDimmed) {
                textView.setTextColor(Color.parseColor("#3a3a3a"));
            } else {
                textView.setTextColor(Color.parseColor("#000000"));
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v("9elements One", "onPause();");
        isDimmed = true;
        updateLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("9elements One", "onResume();");
        isDimmed = false;
        updateLayout();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("9elements One", "onDestroy();");
        unregisterReceiver(timeInfoReceiver);
    }
}
