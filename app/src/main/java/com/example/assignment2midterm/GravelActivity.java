package com.example.assignment2midterm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.Set;

public class GravelActivity extends AppCompatActivity {

    ImageView iv_cart, backButton;
    Button btn_gravel1, btn_gravel2, btn_gravel3, btn_gravel4;
    TextView gb1_price, gb2_price, gb3_price, gb4_price;

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

        iv_cart = findViewById(R.id.iv_cart);
        backButton = findViewById(R.id.back_button);
        btn_gravel1 = findViewById(R.id.btn_gravel1);
        btn_gravel2 = findViewById(R.id.btn_gravel2);
        btn_gravel3 = findViewById(R.id.btn_gravel3);
        btn_gravel4 = findViewById(R.id.btn_gravel4);

        // 🔹 Get price TextViews
        gb1_price = findViewById(R.id.gb1_price);
        gb2_price = findViewById(R.id.gb2_price);
        gb3_price = findViewById(R.id.gb3_price);
        gb4_price = findViewById(R.id.gb4_price);

        backButton.setOnClickListener(v -> onBackPressed());

        iv_cart.setOnClickListener(view -> {
            Intent i = new Intent(GravelActivity.this, ViewCart.class);
            startActivity(i);
        });

        // 🔹 Add item with price to cart
        btn_gravel1.setOnClickListener(view -> addToCart("Giant Revolt Advanced", gb1_price.getText().toString()));
        btn_gravel2.setOnClickListener(view -> addToCart("Jamis Renegade A1", gb2_price.getText().toString()));
        btn_gravel3.setOnClickListener(view -> addToCart("Liv Devote 2", gb3_price.getText().toString()));
        btn_gravel4.setOnClickListener(view -> addToCart("BMC URS AL TWO", gb4_price.getText().toString()));
    }

    private void addToCart(String item, String price) {
        SharedPreferences prefs = getSharedPreferences("MyCart", MODE_PRIVATE);
        Set<String> cart = prefs.getStringSet("cart_items", new HashSet<>());

        Set<String> updatedCart = new HashSet<>(cart);
        updatedCart.add(item + " - " + price); // Store name and price

        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("cart_items", updatedCart);
        editor.apply();

        Toast.makeText(this, item + " added to cart!", Toast.LENGTH_SHORT).show();
    }
}
