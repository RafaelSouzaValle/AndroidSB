package br.com.digivalle.dateandtimepickersampleapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDateTime;

@RequiresApi(api = Build.VERSION_CODES.O)
public class TimePicker extends DialogFragment {

    private LocalDateTime dateTime = LocalDateTime.now();
    private TimePickerDialog.OnTimeSetListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(!(context instanceof TimePickerDialog.OnTimeSetListener)) {
            throw new RuntimeException("The activity needs to implements the TimePickerDialog.OnTimeSetListener interface");
        }

        listener = (TimePickerDialog.OnTimeSetListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),
                listener, dateTime.getHour(), dateTime.getMinute(), false);
    }
}
