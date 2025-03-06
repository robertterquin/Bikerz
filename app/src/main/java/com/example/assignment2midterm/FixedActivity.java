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

public class FixedActivity extends AppCompatActivity {

    ImageView iv_cart, backButton;
    Button btn_fixed1, btn_fixed2, btn_fixed3, btn_fixed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fixed);

        // Apply window insets for better UI layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        iv_cart = findViewById(R.id.iv_cart);
        backButton = findViewById(R.id.back_button);
        btn_fixed1 = findViewById(R.id.btn_fixed1);
        btn_fixed2 = findViewById(R.id.btn_fixed2);
        btn_fixed3 = findViewById(R.id.btn_fixed3);
        btn_fixed4 = findViewById(R.id.btn_fixed4);

        // Back Button Functionality
        backButton.setOnClickListener(v -> onBackPressed());

        // Open Cart Page
        iv_cart.setOnClickListener(view -> {
            Intent i = new Intent(FixedActivity.this, ViewCart.class);
            startActivity(i);
        });

        // Add items to cart
        btn_fixed1.setOnClickListener(view -> addToCart("Core-Line - Earthstone"));
        btn_fixed2.setOnClickListener(view -> addToCart("4130 - Matte Black"));
        btn_fixed3.setOnClickListener(view -> addToCart("6061 Black Label v3 (Black)"));
        btn_fixed4.setOnClickListener(view -> addToCart("6061 Black Label v3 (Violet)"));
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
