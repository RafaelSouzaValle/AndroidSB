package com.example.mybundleintenttestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_2);

        int num = bundle.getInt("num01");
        num++;
        button = findViewById(R.id.button02);
        button.setText(String.valueOf(num));
    }

    public void back(View view) {
        int num = Integer.valueOf(button.getText().toString());

        Intent intent = new Intent();

        Bundle bundle = new Bundle();
        num++;
        bundle.putInt("num01",num);
        System.out.println("Valor devolvido para Main foi: " + num);
        intent.putExtras(bundle);

        setResult(RESULT_OK, intent);
        finish();
    }


}
