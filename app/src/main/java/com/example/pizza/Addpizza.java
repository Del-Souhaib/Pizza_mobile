package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Addpizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpizza);

        findViewById(R.id.update_pizza_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name=findViewById(R.id.update_pizza_name);
                TextView desc=findViewById(R.id.update_pizza_desc);
                TextView duration=findViewById(R.id.update_pizza_duration);

                Intent intent = new Intent(Addpizza.this, MainActivity.class);
                intent.putExtra("title",name.getText().toString());
                intent.putExtra("desc",desc.getText().toString());
                intent.putExtra("duration",duration.getText().toString());
                intent.putExtra("type","add");

                startActivity(intent);

            }
        });
    }
}