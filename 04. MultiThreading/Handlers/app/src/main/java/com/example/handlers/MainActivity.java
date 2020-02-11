package com.example.handlers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textViewStatus;
//  Handler handler;
    private MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = findViewById(R.id.textView_status);
        button = findViewById(R.id.button);

        handler = new MyHandler(textViewStatus,button);
    }

    public void process(View view) {
        button.setEnabled(false);
        textViewStatus.setText("Processando...");

        doSomethingLazy();
    }

    private void doSomethingLazy(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(7000);

//                Using runOnUI
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        button.setEnabled(true);
//                        textViewStatus.setText("Finished!");
//                    }
//                });

//                Using Adroid Handler
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        button.setEnabled(true);
//                        textViewStatus.setText("Finished!");
//                    }
//                });

//              Using My personel Handler and Message
                Message msg = Message.obtain(handler);
                msg.what = MyHandler.MSG_UPDATE_UI;
                handler.sendMessage(msg);

            }
        }).start();
    }
}
