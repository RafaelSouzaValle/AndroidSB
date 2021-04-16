package br.com.digivalle.listfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements FoodFragment.OnItemClick {

    static final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private TextFragment textFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_text);
    }

    @Override
    public void onClick(Food food) {
        textFragment.setText(food.getName() + " " + numberFormat.format(food.getPrice()));
    }
}