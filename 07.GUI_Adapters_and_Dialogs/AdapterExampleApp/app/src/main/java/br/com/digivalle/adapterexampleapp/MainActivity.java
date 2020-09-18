package br.com.digivalle.adapterexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = ArrayAdapter.createFromResource(this,R.array.products, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
    }
}