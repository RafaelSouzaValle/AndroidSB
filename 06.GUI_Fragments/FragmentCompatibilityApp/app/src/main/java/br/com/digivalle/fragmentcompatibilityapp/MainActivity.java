package br.com.digivalle.fragmentcompatibilityapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeftFragment leftFragment = new LeftFragment();
        RightFragment rightFragment = new RightFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.findFragmentById(R.id.left_fragment);
        fm.findFragmentById(R.id.right_fragment);

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.left_fragment, leftFragment, "leftFragment");
        ft.add(R.id.right_fragment, rightFragment, "rightFragment");
        ft.commit();



    }
}