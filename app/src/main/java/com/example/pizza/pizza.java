package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizza.beans.Pizza;

public class pizza extends AppCompatActivity {
    String pizzaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        Intent intent=this.getIntent();
        if(intent!=null){
            TextView title=findViewById(R.id.pizza_title);
            TextView desc=findViewById(R.id.pizza_desc);
            TextView duration=findViewById(R.id.pizza_duree);
            ImageView image=findViewById(R.id.pizza_image);

            title.setText(intent.getStringExtra("title"));
            desc.setText(intent.getStringExtra("desc"));
            duration.setText(intent.getStringExtra("duration"));
            image.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_background));

             pizzaid=intent.getStringExtra("pizza_id");

        }

        findViewById(R.id.delete_pizza).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast0 = Toast.makeText(getApplicationContext(), "pizza supprimé", Toast.LENGTH_SHORT);
                toast0.show();

                Intent intent = new Intent(pizza.this, MainActivity.class);
                intent.putExtra("id",pizzaid);
                intent.putExtra("type","delete");

                startActivity(intent);

            }
        });
    }
}