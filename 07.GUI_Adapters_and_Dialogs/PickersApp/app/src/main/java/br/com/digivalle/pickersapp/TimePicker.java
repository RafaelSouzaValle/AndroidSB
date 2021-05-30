package br.com.digivalle.pickersapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new TimePickerDialog(getActivity(), this,15, 45, false);

    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        String message = String.format("You chose the time %02d:%02d", hourOfDay, minute);

        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}
