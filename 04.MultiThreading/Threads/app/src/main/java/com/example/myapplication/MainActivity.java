package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageTextView = findViewById(R.id.message_text_view);
    }

    public void process(View view) {
        messageTextView.setText("Processing something.");

        executeSomethingLazy();
    }

    public void executeSomethingLazy() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Put UIThread to sleep to simulate there are something complex running
                SystemClock.sleep(7000);

                //Sendo UI response
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        messageTextView.setText("Process Finished");
                    }
                });
            }
        }).start();
    }
}
