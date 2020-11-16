package br.com.digivalle.adapterexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    //private ArrayAdapter<CharSequence> adapter;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //adapter = ArrayAdapter.createFromResource(this,R.array.products, android.R.layout.simple_list_item_1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        adapter.add("Keyboard");
        adapter.add("mouse");
        adapter.add("Memory");

        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = adapter.getItem(position);
        Toast toast = Toast.makeText(this, "Selected item " + item, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }
}