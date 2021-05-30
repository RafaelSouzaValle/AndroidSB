package br.com.digivalle.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {


    private List<Item> items = new ArrayList<>();
    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;

        for(int i = 0; i < 100; i++) {
            items.add(new Item(i + 1, "Item " + (i + 1)));
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = items.get(position);
        holder.txtId.setText(String.valueOf(item.getId()));
        holder.txtName.setText(item.getName());
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtId;
        public TextView txtName;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(android.R.id.text1);
            txtName = itemView.findViewById(android.R.id.text2);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            items.remove(pos);
            Toast.makeText(context, "Item removed: " + pos, Toast.LENGTH_LONG).show();
            notifyItemRemoved(pos);
        }
    }
}
