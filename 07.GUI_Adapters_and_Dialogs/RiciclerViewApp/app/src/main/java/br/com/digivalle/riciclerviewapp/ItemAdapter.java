package br.com.digivalle.riciclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends BaseAdapter implements View.OnClickListener {

    private List<Integer> list = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void putNumbers(int min, int max) {
        for(int i = min; i <= max; i++) {
            list.add(i);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if(view == null) {
            view = layoutInflater.inflate(R.layout.activity_main, parent, false);
            holder = new ViewHolder();
            holder.textView = view.findViewById(R.id.txt_number);
            holder.button = view.findViewById(R.id.btn_info);
            holder.button.setOnClickListener(this);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String number = String.valueOf(list.get(position));
        holder.textView.setText(number);

        holder.button.setTag(number);

        return view;
    }

    private static class ViewHolder {
        public TextView textView;
        public Button button;
    }

    @Override
    public void onClick(View v) {
        String message = "You clicked on " + v.getTag();
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
