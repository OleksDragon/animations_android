package com.example.hw_animation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Task9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task9);

        Button slideBackButton = findViewById(R.id.slideBackButton);
        Button fadeBackButton = findViewById(R.id.fadeBackButton);
        Button scaleBackButton = findViewById(R.id.scaleBackButton);
        Button slideForwardButton = findViewById(R.id.slideForwardButton);
        Button fadeForwardButton = findViewById(R.id.fadeForwardButton);
        Button scaleForwardButton = findViewById(R.id.scaleForwardButton);
        Button backButton = findViewById(R.id.backButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button forwardButton = findViewById(R.id.forwardButton);

        slideBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task8Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });

        fadeBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task8Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        });

        scaleBackButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task8Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
        });

        slideForwardButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task10Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        fadeForwardButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task10Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        });

        scaleForwardButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task10Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.scale_in, R.anim.scale_out);
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task8Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task10Activity.class)));
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}