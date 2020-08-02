package br.com.digivalle.multifragmentincrementapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

public class LeftFragment extends Fragment {

    private int num;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        textView = view.findViewById(R.id.txt_num_left);

        if(savedInstanceState != null) {
            num = savedInstanceState.getInt("leftNum");
        }

        textView.setText(String.valueOf(num));

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("leftNum", num);
    }

    public void increment () {
        num++;
        textView.setText(String.valueOf(num));
    }
}