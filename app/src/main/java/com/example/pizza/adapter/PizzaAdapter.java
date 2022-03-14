package com.example.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizza.R;
import com.example.pizza.beans.Pizza;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Pizza> pizzas;
    private LayoutInflater inflater;

    public PizzaAdapter(List<Pizza> pizzas, Activity activity) {
        this.pizzas = pizzas;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int i) {
        return pizzas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i+1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_pizza_item, null);

        TextView nom = view.findViewById(R.id.pizza_title);
        TextView desc = view.findViewById(R.id.pizza_desc);
        TextView duration = view.findViewById(R.id.pizza_duration);
        ImageView photo = view.findViewById(R.id.pizza_image);

        nom.setText(pizzas.get(i).getNom());
        desc.setText(pizzas.get(i).getDesc());
        duration.setText(pizzas.get(i).gettime());
        photo.setImageResource(pizzas.get(i).getPhoto());

        return view;
    }
}
