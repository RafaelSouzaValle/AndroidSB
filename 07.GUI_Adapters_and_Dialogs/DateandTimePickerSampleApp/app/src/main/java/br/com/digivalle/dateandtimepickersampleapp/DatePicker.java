package br.com.digivalle.dateandtimepickersampleapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.O)
public class DatePicker extends DialogFragment {

    private LocalDateTime dateTime = LocalDateTime.now();
    private DatePickerDialog.OnDateSetListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(!(context instanceof DatePickerDialog.OnDateSetListener)) {
            throw new RuntimeException("The activity needs to implements the DatePickerDialog.OnDateSetListener interface");
        }

        listener = (DatePickerDialog.OnDateSetListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new DatePickerDialog(Objects.requireNonNull(getActivity()),
                listener, dateTime.getYear(), dateTime.getMonthValue() - 1, dateTime.getDayOfMonth());
    }
}
