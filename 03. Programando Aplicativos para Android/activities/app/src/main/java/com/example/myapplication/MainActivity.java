package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("texto","Texto enviado pela MainActivity");
        //startActivity(intent);

        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10) {
            int num = data.getIntExtra("num", -1);
            Toast.makeText(this,"O retorno da outra Activity foi " + num, Toast.LENGTH_LONG).show();

            Button button = findViewById(R.id.btn);
            button.setEnabled(false);
        }
    }
}
