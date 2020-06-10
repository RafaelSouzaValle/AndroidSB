
/**
 *
 * Created by Rafael S Valle - rafaelsouzavalle@gmail.com
 */package com.example.regressivecounterasynctaskapp;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class MyTask extends AsyncTask <Integer, Integer, Void> {


    Button button;
    TextView textView;

    public MyTask(Button button, TextView textView) {
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
        textView.setText("...");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        String c = values[0].toString();
        textView.setText(c);
    }

    @Override
    protected Void doInBackground(Integer... integers) {

        for (int i = integers[0]; i >= 0; i--) {
            SystemClock.sleep(1000);
            publishProgress(i);
        }

        return null;
    }
}
