package br.com.digivalle.riciclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ItemAdapter itemAdapter = new ItemAdapter(this);
        itemAdapter.putNumbers(1, 100);

        setListAdapter(itemAdapter);

    }
}