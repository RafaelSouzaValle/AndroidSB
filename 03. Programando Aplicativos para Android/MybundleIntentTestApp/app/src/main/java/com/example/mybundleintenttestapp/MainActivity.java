package com.example.mybundleintenttestapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button01);


    }

    public void nextActivity(View view) {

        int num = Integer.valueOf((String)button.getText());

        Bundle bundle = new Bundle();
        bundle.putInt("num01", num);

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtras(bundle);

        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();

            int num = bundle.getInt("num01");
            System.out.println("Resultado recebido: " + num);

            button.setText(String.valueOf(num));
        }

    }
}
