package com.example.hw_animation;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Task6Activity extends AppCompatActivity {

    private ImageView fadeImageView;
    private boolean isVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task6);

        fadeImageView = findViewById(R.id.fadeImageView);
        Button fadeButton = findViewById(R.id.fadeButton);
        Button backButton = findViewById(R.id.backButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button forwardButton = findViewById(R.id.forwardButton);

        fadeButton.setOnClickListener(v -> {
            float startAlpha = isVisible ? 1.0f : 0.0f;
            float endAlpha = isVisible ? 0.0f : 1.0f;
            ObjectAnimator fadeAnimator = ObjectAnimator.ofFloat(fadeImageView, "alpha", startAlpha, endAlpha);
            fadeAnimator.setDuration(1000);
            fadeAnimator.start();
            isVisible = !isVisible;
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task5Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task7Activity.class)));
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}