package br.com.digivalle.dialogsapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CheckboxDialogFragment extends DialogFragment implements DialogInterface.OnMultiChoiceClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        boolean[] selectedItems = {false, true, false, true};

        return new AlertDialog.Builder(getActivity())
                .setTitle("Choose a band")
                .setMultiChoiceItems(R.array.bands, selectedItems, this)
                .create();

    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        String[] bands = getActivity().getResources().getStringArray(R.array.bands);
        String band = bands[which];

        if(isChecked) {
            Toast.makeText(getActivity(), "You chose " + band, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "You not chose " + band, Toast.LENGTH_LONG).show();
        }


    }
}
