package br.com.digivalle.fragmentbackstackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();

        Fragment1 f1 = new Fragment1();
        Fragment2 f2 = new Fragment2();
        Fragment3 f3 = new Fragment3();

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.top_framelayout, f1, "f1");
        ft.addToBackStack(null);
        ft.commit();

        ft = fm.beginTransaction();
        ft.add(R.id.middle_framelayout, f2, "f2");
        ft.addToBackStack(null);
        ft.commit();

        ft = fm.beginTransaction();
        ft.add(R.id.bottom_framelayout, f3, "f3");
        ft.addToBackStack(null);
        ft.commit();
    }
}