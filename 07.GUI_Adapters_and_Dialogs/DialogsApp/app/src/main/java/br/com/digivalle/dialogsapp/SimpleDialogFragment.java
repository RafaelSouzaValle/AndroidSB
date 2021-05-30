package br.com.digivalle.dialogsapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Choose a band")
                .setItems(R.array.bands,this)
                .create();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String[] bands = getActivity().getResources().getStringArray(R.array.bands);
        String band = bands[which];

        Toast.makeText(getActivity(), "You chose " + band, Toast.LENGTH_LONG).show();
    }
}
