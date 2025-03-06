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

public class FoldingActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_folding1, btn_folding2,btn_folding3, btn_folding4;
    ArrayList<String> orders = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_folding);
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
        btn_folding1 = findViewById(R.id. btn_folding1);
        btn_folding2 = findViewById(R.id.btn_folding2);
        btn_folding3 = findViewById(R.id. btn_folding3);
        btn_folding4 = findViewById(R.id. btn_folding4);

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FoldingActivity.this, ViewCart.class);
                i.putExtra("orders",orders);
                startActivity(i);
            }
        });

        btn_folding1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Dahon Suv D6 (Blue)");
                Toast.makeText(FoldingActivity.this, "Dahon Suv D6 (Blue) has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_folding2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Dahon Suv D6 (White)");
                Toast.makeText(FoldingActivity.this, "Dahon Suv D6 (White) has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_folding3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Qix Jpn (Green)");
                Toast.makeText(FoldingActivity.this, "Qix Jpn (Green) has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_folding4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Vybe D7 Cloud (White)");
                Toast.makeText(FoldingActivity.this, "Vybe D7 Cloud (White) has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}