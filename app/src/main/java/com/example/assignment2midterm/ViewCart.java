package com.example.assignment2midterm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ViewCart extends AppCompatActivity {

    ArrayList<String> order = new ArrayList<>();
    ListView lv_orders;

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

        Intent i = getIntent();

        order = i.getStringArrayListExtra("orders");

        ArrayAdapter myAdapter = new ArrayAdapter(ViewCart.this, android.R.layout.simple_list_item_1, order);
        lv_orders.setAdapter(myAdapter);

    }
}