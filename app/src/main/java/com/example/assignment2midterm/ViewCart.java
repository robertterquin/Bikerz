package com.example.assignment2midterm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ViewCart extends AppCompatActivity {

    ArrayList<String> order = new ArrayList<>();
    ListView lv_orders;
    private boolean isHeartFilled = false;
    private ImageView heartImageView;
    Button btn_clearCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_cart);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lv_orders = findViewById(R.id.lv_orders);
        ImageView backButton = findViewById(R.id.back_button);
        heartImageView = findViewById(R.id.iv_heart);
        btn_clearCart = findViewById(R.id.btn_clear_cart); // Clear Cart Button

        backButton.setOnClickListener(v -> onBackPressed());

        heartImageView.setOnClickListener(v -> {
            if (isHeartFilled) {
                heartImageView.setImageResource(R.drawable.hollow_heart);
            } else {
                heartImageView.setImageResource(R.drawable.heart);
            }
            isHeartFilled = !isHeartFilled;
        });

        // Retrieve cart data
        SharedPreferences prefs = getSharedPreferences("MyCart", MODE_PRIVATE);
        Set<String> cartSet = prefs.getStringSet("cart_items", new HashSet<>());
        order = new ArrayList<>(cartSet);

        // Ensure items are properly formatted
        if (order.isEmpty()) {
            order.add("Your cart is empty.");
        }

        // Display cart items in the ListView
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(ViewCart.this, android.R.layout.simple_list_item_1, order);
        lv_orders.setAdapter(myAdapter);

        // Handle Clear Cart Button
        btn_clearCart.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.remove("cart_items");
            editor.apply();

            order.clear();
            order.add("Your cart is empty.");
            myAdapter.notifyDataSetChanged();

            Toast.makeText(ViewCart.this, "Cart has been cleared!", Toast.LENGTH_SHORT).show();
        });
    }
}
