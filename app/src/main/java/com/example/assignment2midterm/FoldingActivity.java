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

public class FoldingActivity extends AppCompatActivity {

    ImageView iv_cart, backButton;
    Button btn_folding1, btn_folding2, btn_folding3, btn_folding4;
    TextView fb1_price, fb2_price, fb3_price, fb4_price;

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

        iv_cart = findViewById(R.id.iv_cart);
        backButton = findViewById(R.id.back_button);
        btn_folding1 = findViewById(R.id.btn_folding1);
        btn_folding2 = findViewById(R.id.btn_folding2);
        btn_folding3 = findViewById(R.id.btn_folding3);
        btn_folding4 = findViewById(R.id.btn_folding4);

        // 🔹 Get price TextViews
        fb1_price = findViewById(R.id.fb1_price);
        fb2_price = findViewById(R.id.fb2_price);
        fb3_price = findViewById(R.id.fb3_price);
        fb4_price = findViewById(R.id.fb4_price);

        backButton.setOnClickListener(v -> onBackPressed());

        iv_cart.setOnClickListener(view -> {
            Intent i = new Intent(FoldingActivity.this, ViewCart.class);
            startActivity(i);
        });

        // 🔹 Add item with price to cart
        btn_folding1.setOnClickListener(view -> addToCart("Dahon Suv D6 (Blue)", fb1_price.getText().toString()));
        btn_folding2.setOnClickListener(view -> addToCart("Dahon Suv D6 (White)", fb2_price.getText().toString()));
        btn_folding3.setOnClickListener(view -> addToCart("Qix Jpn (Green)", fb3_price.getText().toString()));
        btn_folding4.setOnClickListener(view -> addToCart("Vybe D7 Cloud (White)", fb4_price.getText().toString()));
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
