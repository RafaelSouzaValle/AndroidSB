package br.com.digivalle.multifragmentcommunitatorapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements Communicator {


    LeftFragment leftFragment = new LeftFragment();
    RightFragment rightFragment = new RightFragment();
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frag_left, leftFragment, "LeftFragment");
        ft.add(R.id.frag_right, rightFragment, "RightFragment");
        ft.commit();
    }

    @Override
    public void changeContent() {
        rightFragment.setContentView(leftFragment.getContentText(), leftFragment.getColorId());
    }
}