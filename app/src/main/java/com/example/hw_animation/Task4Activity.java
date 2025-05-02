package com.example.hw_animation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Task4Activity extends AppCompatActivity {

    private ImageView rootLayout;
    private boolean isColorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        rootLayout = findViewById(R.id.imageView);
        Button colorButton = findViewById(R.id.colorButton);
        Button backButton = findViewById(R.id.backButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button forwardButton = findViewById(R.id.forwardButton);

        colorButton.setOnClickListener(v -> {
            int startColor = isColorChanged ? Color.RED : Color.GREEN;
            int endColor = isColorChanged ? Color.GREEN : Color.RED;

            ValueAnimator colorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), startColor, endColor);
            colorAnimator.setDuration(3000);
            colorAnimator.addUpdateListener(animation -> {
                rootLayout.setBackgroundColor((int) animation.getAnimatedValue());
            });
            colorAnimator.start();
            isColorChanged = !isColorChanged;
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task3Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task5Activity.class)));
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}