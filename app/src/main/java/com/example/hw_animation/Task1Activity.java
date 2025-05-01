package com.example.hw_animation;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Task1Activity extends AppCompatActivity {
    private ImageView ballImageView;
    private boolean isMoved = false;
    private float originalX;
    private float originalY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        ballImageView = findViewById(R.id.ballImageView);
        Button moveButton = findViewById(R.id.moveButton);
        Button backButton = findViewById(R.id.backButton);
        Button forwardButton = findViewById(R.id.forwardButton);
        Button homeButton = findViewById(R.id.homeButton);

        // Зберігаємо початкові координати
        ballImageView.post(() -> {
            originalX = ballImageView.getX();
            originalY = ballImageView.getY();
        });

        moveButton.setOnClickListener(v -> {
            if (!isMoved) {
                // Переміщення в правий нижній кут
                float targetX = getResources().getDisplayMetrics().widthPixels - ballImageView.getWidth() - 50; // 50dp відступ від краю
                float targetY = getResources().getDisplayMetrics().heightPixels - ballImageView.getHeight() - 200; // 200dp відступ від низу

                ObjectAnimator animatorX = ObjectAnimator.ofFloat(ballImageView, "x", targetX);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(ballImageView, "y", targetY);
                animatorX.setDuration(1000);
                animatorY.setDuration(1000);
                animatorX.start();
                animatorY.start();
                isMoved = true;
            } else {
                // Повернення до початкової позиції
                ObjectAnimator animatorX = ObjectAnimator.ofFloat(ballImageView, "x", originalX);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(ballImageView, "y", originalY);
                animatorX.setDuration(1000);
                animatorY.setDuration(1000);
                animatorX.start();
                animatorY.start();
                isMoved = false;
            }
        });

        backButton.setOnClickListener(v -> finish());
        // forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task2Activity.class)));
        homeButton.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}