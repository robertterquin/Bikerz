package com.example.assignment2midterm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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

public class MountainActivity extends AppCompatActivity {

    ImageView iv_cart, backButton;
    Button btn_mtb1, btn_mtb2, btn_mtb3, btn_mtb4;
    TextView mtb1_price, mtb2_price, mtb3_price, mtb4_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mountain);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        iv_cart = findViewById(R.id.iv_cart);
        backButton = findViewById(R.id.back_button);
        btn_mtb1 = findViewById(R.id.btn_mtb1);
        btn_mtb2 = findViewById(R.id.btn_mtb2);
        btn_mtb3 = findViewById(R.id.btn_mtb3);
        btn_mtb4 = findViewById(R.id.btn_mtb4);

        // Get price TextViews
        mtb1_price = findViewById(R.id.mtb1_price);
        mtb2_price = findViewById(R.id.mtb2_price);
        mtb3_price = findViewById(R.id.mtb3_price);
        mtb4_price = findViewById(R.id.mtb4_price);

        backButton.setOnClickListener(v -> onBackPressed());

        iv_cart.setOnClickListener(view -> {
            Intent i = new Intent(MountainActivity.this, ViewCart.class);
            startActivity(i);
        });

        // Add item with price to cart and update total price
        btn_mtb1.setOnClickListener(view -> addToCart("TREK Marlin 4 Gen 2", mtb1_price.getText().toString()));
        btn_mtb2.setOnClickListener(view -> addToCart("Cannondale Habit HT 2", mtb2_price.getText().toString()));
        btn_mtb3.setOnClickListener(view -> addToCart("Orbea Alma H10", mtb3_price.getText().toString()));
        btn_mtb4.setOnClickListener(view -> addToCart("Scott Spark 930", mtb4_price.getText().toString()));
    }

    private void addToCart(String item, String price) {
        SharedPreferences prefs = getSharedPreferences("MyCart", MODE_PRIVATE);
        Set<String> cart = prefs.getStringSet("cart_items", new HashSet<>());

        Set<String> updatedCart = new HashSet<>(cart);
        updatedCart.add(item + " - " + price); // Store name and price

        // Update total price
        double currentTotal = prefs.getFloat("total_price", 0);
        double itemPrice = extractPrice(price);
        double newTotal = currentTotal + itemPrice;

        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("cart_items", updatedCart);
        editor.putFloat("total_price", (float) newTotal); // Store updated total price
        editor.apply();

        Toast.makeText(this, item + " added to cart!", Toast.LENGTH_SHORT).show();
    }

    private double extractPrice(String price) {
        try {
            return Double.parseDouble(price.replace("₱", "").replace(",", "").trim());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
