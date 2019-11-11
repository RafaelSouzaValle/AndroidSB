package com.example.logging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "INFO Message");
        Log.d(TAG, "DEBUG Message");
        Log.w(TAG, "WARNING Message");
        Log.e(TAG, "ERROR Message");
        Log.v(TAG, "VERBOSE Message");
    }
}
