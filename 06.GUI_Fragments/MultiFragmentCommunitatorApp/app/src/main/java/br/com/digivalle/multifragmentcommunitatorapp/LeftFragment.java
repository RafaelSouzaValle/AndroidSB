package br.com.digivalle.multifragmentcommunitatorapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment {

    private Communicator communicator;
    private String contentText;
    private int colorId = Color.GREEN;

    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);

        Button button01 = view.findViewById(R.id.button01);
        Button button02 = view.findViewById(R.id.button02);
        Button button03 = view.findViewById(R.id.button03);
        Button button04 = view.findViewById(R.id.button04);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentText = "Text 01";
                colorId = Color.BLACK;
                communicator.changeContent();
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentText = "Text 02";
                colorId = Color.BLUE;
                communicator.changeContent();
            }
        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentText = "Text 03";
                colorId = Color.YELLOW;
                communicator.changeContent();
            }
        });

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentText = "Text 04";
                colorId = Color.GREEN;
                communicator.changeContent();
            }
        });

        return view;
    }

    public String getContentText() {
        return contentText;
    }

    public int getColorId() {
        return colorId;
    }
}