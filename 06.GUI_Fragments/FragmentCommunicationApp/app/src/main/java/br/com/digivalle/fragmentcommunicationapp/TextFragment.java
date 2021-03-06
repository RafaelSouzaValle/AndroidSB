package br.com.digivalle.fragmentcommunicationapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TextFragment extends Fragment implements View.OnClickListener {

    private EditText editText;
    private OnInvertListener listener;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        if (!(activity instanceof OnInvertListener)) {
            throw new RuntimeException("A activity deve implementar a interface TextFragment.OnInvertListener");
        }

        listener = (OnInvertListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);

        editText = view.findViewById(R.id.editTextTextPersonName);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(listener != null) {
            String texto = editText.getText().toString();
            listener.onInvert(texto);
        }
    }

    public interface OnInvertListener {
        void onInvert(String text);
    }
}