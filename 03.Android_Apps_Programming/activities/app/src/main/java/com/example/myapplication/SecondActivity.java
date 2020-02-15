package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String mensagem = getIntent().getStringExtra("texto");
        TextView textView = findViewById(R.id.txt);

        textView.setText(mensagem);


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("num",1000);

        setResult(RESULT_OK, intent);
        finish();
    }
}
