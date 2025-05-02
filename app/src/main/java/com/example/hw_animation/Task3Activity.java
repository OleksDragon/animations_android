package com.example.hw_animation;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Task3Activity extends AppCompatActivity {

    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        logoImageView = findViewById(R.id.logoImageView);
        Button moveButton = findViewById(R.id.moveButton);
        Button backButton = findViewById(R.id.backButton);
        Button forwardButton = findViewById(R.id.forwardButton);
        Button homeButton = findViewById(R.id.homeButton);


        moveButton.setOnClickListener(v -> {
            ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(logoImageView, "rotation", 0f, 360f);
            rotationAnimator.setDuration(1000);
            rotationAnimator.start();
        });


        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task2Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task1Activity.class)));
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}
