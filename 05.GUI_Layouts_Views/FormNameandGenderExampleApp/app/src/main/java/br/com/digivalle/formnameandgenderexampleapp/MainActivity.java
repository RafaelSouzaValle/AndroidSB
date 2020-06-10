package br.com.digivalle.formnameandgenderexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    RadioGroup radioGroup;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    Button buttonClear;
    Button buttonSend;

    TextView textViewNameAnswer;
    TextView textViewGenderAnswer;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editText_name);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonMale = findViewById(R.id.radio_male);
        radioButtonFemale = findViewById(R.id.radio_female);
        buttonClear = findViewById(R.id.button_clear);
        buttonSend = findViewById(R.id.button_send);

        textViewNameAnswer = findViewById(R.id.textView_name_answer);
        textViewGenderAnswer = findViewById(R.id.textView_gender_answer);

        progressBar = findViewById(R.id.progressBar);

        editTextName.setAlpha(0.2f);
        radioButtonMale.setAlpha(0.2f);
        radioButtonFemale.setAlpha(0.2f);
        buttonClear.setAlpha(0.2f);
        buttonSend.setAlpha(0.2f);

        loadUI();
    }

    private void loadUI() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        editTextName.animate().setDuration(2000).alpha(1.0f);
                        radioButtonMale.animate().setDuration(2000).alpha(1.0f);
                        radioButtonFemale.animate().setDuration(2000).alpha(1.0f);
                        buttonClear.animate().setDuration(2000).alpha(1.0f);
                        buttonSend.animate().setDuration(2000).alpha(1.0f);
                        progressBar.animate().setDuration(2000).alpha(0.0f);
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }

    public void loadAnswers(View view) {
        textViewNameAnswer.setText(editTextName.getText().toString());

        if(radioButtonFemale.isChecked()) {
            textViewGenderAnswer.setText(radioButtonFemale.getText());
        } else if (radioButtonMale.isChecked()){
            textViewGenderAnswer.setText(radioButtonMale.getText());
        } else {
            Toast toast = Toast.makeText(this,"Please, check the gender.",Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void clearAnswers(View view) {
        editTextName.setText("");
        radioGroup.clearCheck();
        textViewGenderAnswer.setText("");
        textViewNameAnswer.setText("");
    }
}
