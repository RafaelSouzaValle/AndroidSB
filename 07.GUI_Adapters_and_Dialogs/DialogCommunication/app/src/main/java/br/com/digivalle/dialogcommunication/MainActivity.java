package br.com.digivalle.dialogcommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ExitDialog.ExitListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        ExitDialog dialog = new ExitDialog();
        dialog.show(getSupportFragmentManager(), "exitDialog");

    }

    @Override
    public void onExit() {
        finish();
    }
}