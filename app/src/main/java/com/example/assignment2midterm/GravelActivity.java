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

public class GravelActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_gravel1, btn_gravel2, btn_gravel3, btn_gravel4;
    ArrayList<String> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gravel);
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
        btn_gravel1 = findViewById(R.id. btn_gravel1);
        btn_gravel2 = findViewById(R.id. btn_gravel2);
        btn_gravel3 = findViewById(R.id. btn_gravel3);
        btn_gravel4 = findViewById(R.id. btn_gravel4);

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GravelActivity.this, ViewCart.class);
                i.putExtra("orders",orders);
                startActivity(i);
            }
        });

        btn_gravel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Giant Revolt Advanced");
                Toast.makeText(GravelActivity.this, "Giant Revolt Advanced has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_gravel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Jamis Renegade A1");
                Toast.makeText(GravelActivity.this, "Jamis Renegade A1 has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_gravel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Liv Devote 2");
                Toast.makeText(GravelActivity.this, "Liv Devote 2 has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_gravel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("BMC URS AL TWO");
                Toast.makeText(GravelActivity.this, "BMC URS AL TWO has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}