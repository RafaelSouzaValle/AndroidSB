/**
 *
 * Created by Rafael S Valle - rafaelsouzavalle@gmail.com
 */
package com.example.regressivecounterasynctaskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.counter_textview);
    }

    public void start(View view) {
        MyTask task = new MyTask(button, textView);
        task.execute(10);
    }
}
