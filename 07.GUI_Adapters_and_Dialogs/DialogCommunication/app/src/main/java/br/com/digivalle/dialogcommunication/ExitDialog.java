package br.com.digivalle.dialogcommunication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ExitDialog extends DialogFragment implements DialogInterface.OnClickListener {
    private ExitListner listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(!(context instanceof ExitListner)) {
            throw new RuntimeException("The activity needs to implements the ExitDialog.ExitListener interface");
        }

        listener = (ExitListner) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Do you wanna exit?")
                .setPositiveButton("Yes", this)
                .setNegativeButton("No", this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == DialogInterface.BUTTON_POSITIVE && listener != null) {
            listener.onExit();
        }
    }

    public interface ExitListner {
        public void onExit();
    }
}
