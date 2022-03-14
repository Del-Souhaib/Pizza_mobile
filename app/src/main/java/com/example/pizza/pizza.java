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
    TextView title,desc,duration;
    ImageView image;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        intent=this.getIntent();
        if(intent!=null){
             title=findViewById(R.id.pizza_title);
             desc=findViewById(R.id.pizza_desc);
             duration=findViewById(R.id.pizza_duree);
             image=findViewById(R.id.pizza_image);

            title.setText(intent.getStringExtra("title"));
            desc.setText(intent.getStringExtra("desc"));
            duration.setText(intent.getStringExtra("duration"));
            image.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_background));

             pizzaid=intent.getStringExtra("pizza_id");

        }

        findViewById(R.id.delete_pizza).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(pizza.this, MainActivity.class);
                intent1.putExtra("id",pizzaid);
                intent1.putExtra("type","delete");

                startActivity(intent);

            }
        });


        findViewById(R.id.update_pizza).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(pizza.this, Updatepizza.class);
                intent1.putExtra("pizza_id",pizzaid);
                intent1.putExtra("name",intent.getStringExtra("title"));
                intent1.putExtra("desc",intent.getStringExtra("desc"));
                intent1.putExtra("duration",intent.getStringExtra("duration"));
                intent1.putExtra("image",intent.getIntExtra("image",R.drawable.ic_launcher_background));

                startActivity(intent1);

            }
        });
    }
}