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

public class FixedActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_fixed1, btn_fixed2 ,btn_fixed3, btn_fixed4;
    ArrayList<String> orders = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fixed);
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
        btn_fixed1 = findViewById(R.id.btn_fixed1);
        btn_fixed2 = findViewById(R.id.btn_fixed2);
        btn_fixed3 = findViewById(R.id.btn_fixed3);
        btn_fixed4 = findViewById(R.id.btn_fixed4);

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FixedActivity.this, ViewCart.class);
                i.putExtra("orders",orders);
                startActivity(i);
            }
        });

        btn_fixed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Core-Line - Earthstone");
                Toast.makeText(FixedActivity.this, "Core-Line - Earthstone has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_fixed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("4130 - Matte Black");
                Toast.makeText(FixedActivity.this, "4130 - Matte Black has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_fixed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("6061 Black Label v3 (Black)");
                Toast.makeText(FixedActivity.this, "6061 Black Label v3 (Black) has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_fixed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("6061 Black Label v3 (Violet)");
                Toast.makeText(FixedActivity.this, "6061 Black Label v3 (Violet) has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}