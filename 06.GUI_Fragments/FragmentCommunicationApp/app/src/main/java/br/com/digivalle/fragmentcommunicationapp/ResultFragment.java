package br.com.digivalle.fragmentcommunicationapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ResultFragment extends Fragment {

    private TextView textViewInverted;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        textViewInverted = view.findViewById(R.id.textView);

        return view;
    }

    public void invert(String text) {
        if(text != null) {
            String inverted = new StringBuilder(text).reverse().toString();
            textViewInverted.setText(inverted);
        }
    }
}
