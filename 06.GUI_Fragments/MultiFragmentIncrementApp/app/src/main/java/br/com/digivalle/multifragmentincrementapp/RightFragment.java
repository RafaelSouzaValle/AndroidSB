package br.com.digivalle.multifragmentincrementapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class RightFragment extends Fragment {

    private int num;
    private TextView textView;
    private NumberUpdate numberUpdate;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        numberUpdate = (NumberUpdate) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);

        textView = view.findViewById(R.id.txt_num_right);

        if(savedInstanceState != null) {
            num = savedInstanceState.getInt("rightNum");
        }

        textView.setText(String.valueOf(num));

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("rightNum", num);
    }

    public void increment (int n) {
        num += n;
        textView.setText(String.valueOf(num));
    }

    public interface NumberUpdate {
        public void sendNumber(int num);
    }
}