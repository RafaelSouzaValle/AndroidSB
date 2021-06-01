package br.com.digivalle.dateandtimepickersampleapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private TextView dateTextView;
    private String date;
    private String time;
    private String hourFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTextView = findViewById(R.id.textView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void openDate(View view) {
        DatePicker datePicker = new DatePicker();
        datePicker.show(getSupportFragmentManager(), "datePicker");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void openTime(View view) {
        TimePicker timePicker = new TimePicker();
        timePicker.show(getSupportFragmentManager(), "timePicker");

    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        date = "" + year + "/" + month + "/" + dayOfMonth;
        refreshDateTextView();
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        view.setIs24HourView(true);
        if(hourOfDay > 12) {
            hourFormat = "PM";
        } else {
            hourFormat = "AM";
        }
        view.setIs24HourView(false);
        time = "" + hourOfDay + ":" + minute + " " + hourFormat;
        refreshDateTextView();
    }

    private void refreshDateTextView() {
        String dateTime = date + " " + time;
        dateTextView.setText(dateTime);
    }
}