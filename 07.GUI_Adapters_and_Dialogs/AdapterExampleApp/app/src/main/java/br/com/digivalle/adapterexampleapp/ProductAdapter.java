package br.com.digivalle.adapterexampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends BaseAdapter {

    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH);

    private List<Product> products;
    private LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> products) {
        this.products = products;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.product_adapter_layout, parent, false);
        Product product = products.get(position);

        TextView txtNome = view.findViewById(R.id.txt_name);
        TextView txtPrice = view.findViewById(R.id.txt_price);

        txtNome.setText(product.getName());
        txtPrice.setText(nf.format(product.getPrice()));

        return view;
    }
}
