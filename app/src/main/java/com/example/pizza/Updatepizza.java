package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Updatepizza extends AppCompatActivity {
    Intent intent;
    TextView name, desc, duration;
    ImageView image;
    String pizza_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepizza);

        intent = this.getIntent();
        if (intent != null) {
            pizza_id = intent.getStringExtra("pizza_id");
            name = findViewById(R.id.update_pizza_name);
            desc = findViewById(R.id.update_pizza_desc);
            duration = findViewById(R.id.update_pizza_duration);
            image = findViewById(R.id.update_pizza_image2);
            name.setText(intent.getStringExtra("name"));
            desc.setText(intent.getStringExtra("desc"));
            image.setImageResource(intent.getIntExtra("image", R.drawable.ic_launcher_background));
            duration.setText(intent.getStringExtra("duration"));
        }
        findViewById(R.id.update_pizza_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = findViewById(R.id.update_pizza_name);
                desc = findViewById(R.id.update_pizza_desc);
                duration = findViewById(R.id.update_pizza_duration);
                image = findViewById(R.id.update_pizza_image2);

                Intent intent1 = new Intent(Updatepizza.this, MainActivity.class);
                intent1.putExtra("type", "update");
                intent1.putExtra("name", name.getText().toString());
                intent1.putExtra("desc", desc.getText().toString());
                intent1.putExtra("duration", duration.getText().toString());
                intent1.putExtra("pizza_id", pizza_id);

                startActivity(intent1);

            }
        });
    }
}