package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;

import com.example.pizza.adapter.PizzaAdapter;
import com.example.pizza.beans.Pizza;
import com.example.pizza.service.PizzaService;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private PizzaService ps = PizzaService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ps.create(new Pizza("BARBECUED CHICKEN PIZZA", "35 min", R.mipmap.pizza1, "descddddddddddddddddddddddddddddddddddddddddddd"));
        ps.create(new Pizza("PIZZA maragrita ", "22 min", R.mipmap.pizza2, "desc"));
        ps.create(new Pizza("CHICKEN PIZZA ", "30 min", R.mipmap.pizza3, "desc"));
        ps.create(new Pizza("Buffer PIZZA ", "20 min", R.mipmap.pizza4, "desc"));
        ps.create(new Pizza("Big pizza ", "35 min", R.mipmap.pizza5, "desc"));
        ps.create(new Pizza("Pizza", "10 min", R.mipmap.pizza1, "desc"));
        ps.create(new Pizza("BARBECUED CHICKEN PIZZA 6", "15 min", R.mipmap.pizza2, "desc"));
        ps.create(new Pizza("BARBECUED CHICKEN PIZZA 6", "18 min", R.mipmap.pizza3, "desc"));


        ListView listView1 = findViewById(R.id.listview1);
        listView1.setAdapter(new PizzaAdapter(ps.findAll(), this));

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, pizza.class);
                String id = String.valueOf(ps.findById(i + 1).getId());

                intent.putExtra("title", ps.findById(i + 1).getNom());
                intent.putExtra("desc", ps.findById(i + 1).getDesc());
                intent.putExtra("image", ps.findById(i + 1).getPhoto());
                intent.putExtra("duration", ps.findById(i + 1).gettime());
                intent.putExtra("pizza_id", id);
                startActivity(intent);
                Toast toast = Toast.makeText(getApplicationContext(), ps.findById(i + 1).getNom(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

//        ListAdapter listAdapter = new ListAdapter(MainActivity.this, ps);

        findViewById(R.id.addpizza_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent2 = new Intent(MainActivity.this, Addpizza.class);
                startActivity(intent2);
            }
        });

        Intent getdatafromadd = this.getIntent();
        if (getdatafromadd.getStringExtra("type") != null) {
            String type = getdatafromadd.getStringExtra("type");

            if (type.equals("delete")) {
                int id= Integer.parseInt(getdatafromadd.getStringExtra("id"));
                ps.delete(ps.findById(id));
                Toast toast0 = Toast.makeText(getApplicationContext(), "pizza supprimé", Toast.LENGTH_SHORT);
                toast0.show();

//                ps.delete(ps.findById(id));
            } else if (type.equals("add")) {
                ps.create(new Pizza(getdatafromadd.getStringExtra("title"), getdatafromadd.getStringExtra("duration"), R.mipmap.pizza1, getdatafromadd.getStringExtra("desc")));
                Toast toast0 = Toast.makeText(getApplicationContext(), "pizza ajouté", Toast.LENGTH_SHORT);
                toast0.show();

            }
        }


    }


}