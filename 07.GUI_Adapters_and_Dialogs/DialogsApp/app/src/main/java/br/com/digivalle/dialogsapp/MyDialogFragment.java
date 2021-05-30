package br.com.digivalle.dialogsapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Question")
                .setMessage("Can you understand how dialog works?")
                .setPositiveButton("Yes", this)
                .setNegativeButton("No", this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        String message = null;
        if(which == DialogInterface.BUTTON_POSITIVE) {
            message = "You chose yes.";
        } else {
            message = "You chose no.";
        }

        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
