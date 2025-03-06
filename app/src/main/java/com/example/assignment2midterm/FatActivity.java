package com.example.assignment2midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class FatActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_fat1, btn_fat2 ,btn_fat3, btn_fat4;
    ArrayList<String> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        iv_cart = findViewById(R.id.iv_cart);
        btn_fat1 = findViewById(R.id. btn_fat1);
        btn_fat2 = findViewById(R.id.btn_fat2);
        btn_fat3 = findViewById(R.id. btn_fat3);
        btn_fat4 = findViewById(R.id. btn_fat4);

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FatActivity.this, ViewCart.class);
                i.putExtra("orders",orders);
                startActivity(i);
            }
        });

        btn_fat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Silverback Scoop");
                Toast.makeText(FatActivity.this, "Silverback Scoop has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_fat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Scott Big Jon");
                Toast.makeText(FatActivity.this, "Scott Big Jon has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_fat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Zeus Fat Bike");
                Toast.makeText(FatActivity.this, "Zeus Fat Bike has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_fat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Alpha Fat Bike");
                Toast.makeText(FatActivity.this, "Alpha Fat Bike has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}