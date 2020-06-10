package com.example.handlers;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MyHandler extends Handler {

    public static final int MSG_UPDATE_UI = 100;

    private TextView textView;
    private Button button;

    public MyHandler(TextView textView, Button button) {
        this.textView = textView;
        this.button = button;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        if(msg.what == MSG_UPDATE_UI) {
            button.setEnabled(true);
            textView.setText("Finished!");
        }
    }
}
