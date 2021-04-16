package br.com.digivalle.listfragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.ListFragment;

import java.util.Objects;

public class FoodFragment extends ListFragment {

    private ArrayAdapter<Food> adapter;
    private OnItemClick listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(!(context instanceof OnItemClick)) {
            throw new RuntimeException("Activity doesn't implements FoodFragment.OnItemClick");
        }

        listener = (OnItemClick) context;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1);

        String[] names = getActivity().getResources().getStringArray(R.array.food_names);
        String[] prices = getActivity().getResources().getStringArray(R.array.food_prices);

        int i = 0;
        for (String name : names) {
            Food food = new Food(name, Double.parseDouble(prices[i]));
            adapter.add(food);
            i++;
        }

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Food food = adapter.getItem(position);

        if(listener != null) {
            listener.onClick(food);
        }
    }

    public interface OnItemClick {
        void onClick(Food food);
    }
}
