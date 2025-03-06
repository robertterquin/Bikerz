package com.example.assignment2midterm;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.HashSet;
import java.util.Set;

public class FoldingActivity extends AppCompatActivity {

    ImageView iv_cart, backButton;
    Button btn_folding1, btn_folding2, btn_folding3, btn_folding4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_folding);

        // Apply window insets for a better UI layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        iv_cart = findViewById(R.id.iv_cart);
        backButton = findViewById(R.id.back_button);
        btn_folding1 = findViewById(R.id.btn_folding1);
        btn_folding2 = findViewById(R.id.btn_folding2);
        btn_folding3 = findViewById(R.id.btn_folding3);
        btn_folding4 = findViewById(R.id.btn_folding4);

        // Back Button Functionality
        backButton.setOnClickListener(v -> onBackPressed());

        // Open Cart Page
        iv_cart.setOnClickListener(view -> {
            Intent i = new Intent(FoldingActivity.this, ViewCart.class);
            startActivity(i);
        });

        // Add items to cart
        btn_folding1.setOnClickListener(view -> addToCart("Dahon Suv D6 (Blue)"));
        btn_folding2.setOnClickListener(view -> addToCart("Dahon Suv D6 (White)"));
        btn_folding3.setOnClickListener(view -> addToCart("Qix Jpn (Green)"));
        btn_folding4.setOnClickListener(view -> addToCart("Vybe D7 Cloud (White)"));
    }

    // Function to add items to SharedPreferences
    private void addToCart(String item) {
        SharedPreferences prefs = getSharedPreferences("MyCart", MODE_PRIVATE);
        Set<String> cart = prefs.getStringSet("cart_items", new HashSet<>());

        // Ensure the cart maintains previous items
        Set<String> updatedCart = new HashSet<>(cart);
        updatedCart.add(item);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("cart_items", updatedCart);
        editor.apply();

        // Confirmation message
        Toast.makeText(this, item + " added to cart!", Toast.LENGTH_SHORT).show();
    }
}
