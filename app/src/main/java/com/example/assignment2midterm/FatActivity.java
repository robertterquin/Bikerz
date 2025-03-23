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

public class FatActivity extends AppCompatActivity {

    ImageView iv_cart, backButton;
    Button btn_fat1, btn_fat2, btn_fat3, btn_fat4;
    TextView fat1_price, fat2_price, fat3_price, fat4_price;

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

        iv_cart = findViewById(R.id.iv_cart);
        backButton = findViewById(R.id.back_button);
        btn_fat1 = findViewById(R.id.btn_fat1);
        btn_fat2 = findViewById(R.id.btn_fat2);
        btn_fat3 = findViewById(R.id.btn_fat3);
        btn_fat4 = findViewById(R.id.btn_fat4);

        fat1_price = findViewById(R.id.fat1_price);
        fat2_price = findViewById(R.id.fat2_price);
        fat3_price = findViewById(R.id.fat3_price);
        fat4_price = findViewById(R.id.fat4_price);

        backButton.setOnClickListener(v -> onBackPressed());

        iv_cart.setOnClickListener(view -> {
            Intent i = new Intent(FatActivity.this, ViewCart.class);
            startActivity(i);
        });

        // 🔹 Add item with price to cart
        btn_fat1.setOnClickListener(view -> addToCart("Silverback Scoop", fat1_price.getText().toString()));
        btn_fat2.setOnClickListener(view -> addToCart("Scott Big Jon", fat2_price.getText().toString()));
        btn_fat3.setOnClickListener(view -> addToCart("Zeus Fat Bike", fat3_price.getText().toString()));
        btn_fat4.setOnClickListener(view -> addToCart("Alpha Fat Bike", fat4_price.getText().toString()));
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
