/**
 *
 * Created by Rafael S Valle - rafaelsouzavalle@gmail.com
 */
package com.example.asynctaskapp;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class CounterTask extends AsyncTask<Integer, Integer, Void> {

    private Button button;
    private TextView textView;

    public CounterTask(Button button, TextView textView) {
        this.button = button;
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        button.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        button.setEnabled(true);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        String c = values[0] + "%";
        textView.setText(c);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];

        for (int i = 0; i <= max; i++) {
            SystemClock.sleep(100);
            publishProgress(i);
        }
        return null;
    }
}

