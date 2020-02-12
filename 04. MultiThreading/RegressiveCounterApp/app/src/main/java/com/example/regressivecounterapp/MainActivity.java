package com.example.regressivecounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MAX = 10;

    Button button;
    TextView textView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.counter_textview);
        handler = new Handler();
    }

    public void start(View view) {
        count();
    }

    private void count() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        button.setEnabled(false);
                        textView.setText(String.valueOf(MAX));
                    }
                });
                updateButtonText();
            }
        }).start();
    }

    private void updateButtonText() {
        for (int i = MAX; i > 0; i--) {
            SystemClock.sleep(1000);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Integer c = Integer.valueOf(textView.getText().toString());
                    c--;
                    textView.setText(c.toString());
                }
            });
        }

        handler.post(new Runnable() {
            @Override
            public void run() {
                button.setEnabled(true);
            }
        });
    }
}
