package br.com.digivalle.spinnerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add("***Select the Country***");
        adapter.add("England");
        adapter.add("Japan");
        adapter.add("Brazil");
        adapter.add("Czech");
        adapter.add("Germany");

        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String c = adapter.getItem(position);
        Toast.makeText(this, "Selected country: " + c, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Select the country: ", Toast.LENGTH_LONG).show();
    }
}