package com.example.hw_animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Task7Activity extends AppCompatActivity {

    private ImageView animatedImageView;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task7);

        animatedImageView = findViewById(R.id.animatedImageView);
        Button startButton = findViewById(R.id.startButton);
        Button stopButton = findViewById(R.id.stopButton);
        Button backButton = findViewById(R.id.backButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button forwardButton = findViewById(R.id.forwardButton);

        startButton.setOnClickListener(v -> {
            // Зупиняємо попередню анімацію, якщо вона активна
            if (animatorSet != null) {
                animatorSet.cancel();
            }

            // Переміщення по осі X
            ObjectAnimator translationX = ObjectAnimator.ofFloat(animatedImageView, "translationX", 0f, 850f);
            translationX.setDuration(4000);

            // Обертання на 360 градусів
            ObjectAnimator rotation = ObjectAnimator.ofFloat(animatedImageView, "rotation", 0f, 720f);
            rotation.setDuration(4000);

            // Зменшення до 50%
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(animatedImageView, "scaleX", 1.0f, 0.5f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(animatedImageView, "scaleY", 1.0f, 0.5f);
            scaleX.setDuration(4000);
            scaleY.setDuration(4000);

            // Комбінуємо анімації
            animatorSet = new AnimatorSet();
            animatorSet.playTogether(translationX, rotation, scaleX, scaleY);
            animatorSet.start();
        });

        stopButton.setOnClickListener(v -> {
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task6Activity.class);
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