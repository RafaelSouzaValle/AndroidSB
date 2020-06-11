package br.com.digivalle.fragmentdynamicapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeftFragment leftFragment = new LeftFragment();
        RightFragment rightFragment = new RightFragment();

        FragmentManager fm = getFragmentManager();
        @SuppressLint("CommitTransaction")
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.left_fragment, leftFragment, "leftFragment");
        ft.add(R.id.right_fragment, rightFragment, "rightFragment");
        ft.commit();
    }
}