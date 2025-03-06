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

public class MountainActivity extends AppCompatActivity {

    ImageView iv_cart;
    Button btn_mtb1, btn_mtb2, btn_mtb3, btn_mtb4;
    ArrayList<String> orders = new ArrayList<>();


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
        btn_mtb1 = findViewById(R.id.btn_mtb1);
        btn_mtb2 = findViewById(R.id.btn_mtb2);
        btn_mtb3 = findViewById(R.id.btn_mtb3);
        btn_mtb4 = findViewById(R.id.btn_mtb4);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        iv_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MountainActivity.this, ViewCart.class);
                i.putExtra("orders",orders);
                startActivity(i);
            }
        });


        btn_mtb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("TREK Marlin 4 Gen 2");
                Toast.makeText(MountainActivity.this, "TREK Marlin 4 Gen 2 has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });



        btn_mtb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Cannondale Habit HT 2 ");
                Toast.makeText(MountainActivity.this, "Cannondale Habit HT 2 has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_mtb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Orbea Alma H10");
                Toast.makeText(MountainActivity.this, "Orbea Alma H10 has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_mtb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orders.add("Scott Spark 930");
                Toast.makeText(MountainActivity.this, "Scott Spark 9302 has been added to the cart.", Toast.LENGTH_SHORT).show();
            }
        });



    }
}