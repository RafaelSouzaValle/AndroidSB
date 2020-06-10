/**
 *
 *
 * @author: Rafael Souza Valle - rafaelsouzavalle@gmail.com
 *
 */

package br.com.digivalle.guiprogressbarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview_message);
        progressBar = findViewById(R.id.progress);

        textView.setAlpha(0.3f);

        loadContent();
    }

    private void loadContent() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.animate().setDuration(5000).alpha(1.0f);
                        progressBar.animate().setDuration(5000).alpha(0.0f);
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }
}
