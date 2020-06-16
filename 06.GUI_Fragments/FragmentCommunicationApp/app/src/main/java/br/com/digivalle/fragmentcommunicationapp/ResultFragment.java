package br.com.digivalle.fragmentcommunicationapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    private TextView textViewInverted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
