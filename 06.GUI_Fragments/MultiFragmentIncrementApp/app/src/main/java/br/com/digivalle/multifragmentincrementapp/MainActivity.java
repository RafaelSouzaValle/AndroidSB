package br.com.digivalle.multifragmentincrementapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements RightFragment.NumberUpdate {


    LeftFragment leftFragment;
    RightFragment rightFragment;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        button = findViewById(R.id.btn_inc);

        leftFragment = (LeftFragment) fm.findFragmentByTag("LeftFragment");
        if (leftFragment == null) {
            leftFragment = new LeftFragment();
            ft.add(R.id.frame_left, leftFragment, "LeftFragment");
        }

        rightFragment = (RightFragment) fm.findFragmentByTag("RightFragment");
        if (rightFragment == null) {
            rightFragment = new RightFragment();
            ft.add(R.id.frame_right, rightFragment, "RightFragment");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftFragment.increment();
                sendNumber(5);
            }
        });

        ft.commit();
    }

    @Override
    public void sendNumber(int num) {
        rightFragment.increment(num);
    }
}