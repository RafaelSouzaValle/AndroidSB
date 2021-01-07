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

    //private ArrayAdapter<CharSequence> adapter; //version 1
    //private ArrayAdapter<String> adapter;//version 2
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //adapter = ArrayAdapter.createFromResource(this,R.array.products, android.R.layout.simple_list_item_1); //version 1
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1); //version 2

//        version 2
//        adapter.add("Keyboard");
//        adapter.add("mouse");
//        adapter.add("Memory");

        adapter = new ProductAdapter(this, Product.getProducts());

        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        String item = adapter.getItem(position); //version 2

        Product product = (Product) adapter.getItem(position);

        Toast toast = Toast.makeText(this, "Selected item " +
                product.getName() + " " + product.getPrice(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();
    }
}