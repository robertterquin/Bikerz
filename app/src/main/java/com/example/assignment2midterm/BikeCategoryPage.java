package com.example.assignment2midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BikeCategoryPage extends AppCompatActivity {

    private boolean isHeartFilled = false;
    private ImageView heartImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bike_category_page);
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

        heartImageView = findViewById(R.id.heart_button);
        heartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHeartFilled) {
                    heartImageView.setImageResource(R.drawable.hollow_heart); // Hollow heart
                } else {
                    heartImageView.setImageResource(R.drawable.heart); // Red heart
                }
                isHeartFilled = !isHeartFilled;
            }
        });

        clickListener();
    }

    public void clickListener() {
        ImageView imageMountain = findViewById(R.id.iv_Mountain);
        ImageView imageRoad = findViewById(R.id.iv_Road);
        ImageView imageGravel = findViewById(R.id.iv_Gravel);
        ImageView imageFolding = findViewById(R.id.iv_Folding);
        ImageView imageFat = findViewById(R.id.iv_Fat);
        ImageView imageFixed = findViewById(R.id.iv_Fixed);

        imageMountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMountainActivity();
            }
        });

        imageRoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoadActivity();
            }
        });

        imageGravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGravelActivity();
            }
        });

        imageFolding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoldingActivity();
            }
        });

        imageFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFatActivity();
            }
        });

        imageFixed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFixedActivity();
            }
        });
    }


    public void openMountainActivity() {
        startActivity(new Intent(BikeCategoryPage.this, MountainActivity.class));
    }

    public void openRoadActivity() {
        startActivity(new Intent(BikeCategoryPage.this, RoadActivity.class));
    }

    public void openGravelActivity() {
        startActivity(new Intent(BikeCategoryPage.this, GravelActivity.class));
    }

    public void openFoldingActivity() {
        startActivity(new Intent(BikeCategoryPage.this, FoldingActivity.class));
    }

    public void openFatActivity() {
        startActivity(new Intent(BikeCategoryPage.this, FatActivity.class));
    }

    public void openFixedActivity() {
        startActivity(new Intent(BikeCategoryPage.this, FixedActivity.class));

    }

}


