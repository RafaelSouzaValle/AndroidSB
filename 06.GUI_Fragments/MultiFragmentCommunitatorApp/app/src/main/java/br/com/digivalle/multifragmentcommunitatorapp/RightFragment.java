package br.com.digivalle.multifragmentcommunitatorapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class RightFragment extends Fragment {

    private TextView textView;
    private View layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        textView = view.findViewById(R.id.text_content);
        layout = view.findViewById(R.id.layout_content);

        return view;
    }

    public void setContentView(String string, int color) {
        textView.setText(string);
        layout.setBackgroundColor(color);
    }
}