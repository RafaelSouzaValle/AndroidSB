package br.com.digivalle.dialogsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    public void openSimpleDialog(View view) {
        SimpleDialogFragment dialog = new SimpleDialogFragment();
        dialog.show(getSupportFragmentManager(), "simpleDialog");
    }
}