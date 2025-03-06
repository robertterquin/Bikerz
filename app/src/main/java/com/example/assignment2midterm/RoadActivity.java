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

public class RoadActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_rb1, btn_rb2, btn_rb3, btn_rb4;
    ArrayList<String> orders = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_road);
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
        btn_rb1 = findViewById(R.id.btn_rb1);
        btn_rb2 = findViewById(R.id.btn_rb2);
        btn_rb3 = findViewById(R.id.btn_rb3);
        btn_rb4 = findViewById(R.id.btn_rb4);

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoadActivity.this, ViewCart.class);
                i.putExtra("orders",orders);
                startActivity(i);
            }
        });


        btn_rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Orbea 2023 Orca M30");
                Toast.makeText(RoadActivity.this, "Orbea 2023 Orca M30 has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Giant Propel Advanced");
                Toast.makeText(RoadActivity.this, "Giant Propel Advanced has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Cervelo Caledonia");
                Toast.makeText(RoadActivity.this, "Cervelo Caledonia has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Cervelo Soloist Carbon");
                Toast.makeText(RoadActivity.this, "Cervelo Soloist Carbon has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}