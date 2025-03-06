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

public class MountainActivity extends AppCompatActivity {

    ImageView iv_cart, backButton;
    Button btn_mtb1, btn_mtb2, btn_mtb3, btn_mtb4;

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

        backButton.setOnClickListener(v -> onBackPressed());

        iv_cart.setOnClickListener(view -> {
            Intent i = new Intent(MountainActivity.this, ViewCart.class);
            startActivity(i);
        });

        btn_mtb1.setOnClickListener(view -> addToCart("TREK Marlin 4 Gen 2"));
        btn_mtb2.setOnClickListener(view -> addToCart("Cannondale Habit HT 2"));
        btn_mtb3.setOnClickListener(view -> addToCart("Orbea Alma H10"));
        btn_mtb4.setOnClickListener(view -> addToCart("Scott Spark 930"));
    }

    private void addToCart(String item) {
        SharedPreferences prefs = getSharedPreferences("MyCart", MODE_PRIVATE);
        Set<String> cart = prefs.getStringSet("cart_items", new HashSet<>());

        Set<String> updatedCart = new HashSet<>(cart);
        updatedCart.add(item);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("cart_items", updatedCart);
        editor.apply();

        Toast.makeText(this, item + " added to cart!", Toast.LENGTH_SHORT).show();
    }
}
