package com.example.hw_animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Task5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        Button animateButton = findViewById(R.id.animateButton);
        Button backButton = findViewById(R.id.backButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button forwardButton = findViewById(R.id.forwardButton);

        animateButton.setOnClickListener(v -> {
            // Анімація зменшення до 80% за 100 мс
            ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(animateButton, "scaleX", 0.5f);
            ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(animateButton, "scaleY", 0.5f);
            scaleDownX.setDuration(500);
            scaleDownY.setDuration(500);

            // Анімація повернення до нормального розміру за 200 мс
            ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(animateButton, "scaleX", 1.0f);
            ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(animateButton, "scaleY", 1.0f);
            scaleUpX.setDuration(1000);
            scaleUpY.setDuration(1000);

            // Комбінуємо анімації в AnimatorSet
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(scaleDownX).with(scaleDownY); // Зменшення одночасно
            animatorSet.play(scaleUpX).with(scaleUpY).after(scaleDownX); // Повернення після зменшення
            animatorSet.start();
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task4Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task6Activity.class)));
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}