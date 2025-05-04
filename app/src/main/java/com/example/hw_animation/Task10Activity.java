package com.example.hw_animation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class Task10Activity extends AppCompatActivity {
    private SpringAnimation springyScaleXAnimation;
    private SpringAnimation springyScaleYAnimation;
    private SpringAnimation throwScaleXAnimation;
    private SpringAnimation throwScaleYAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task10);

        Button backButton = findViewById(R.id.backButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button forwardButton = findViewById(R.id.forwardButton);

        ImageView springyImageView = findViewById(R.id.springyImageView);
        ImageView throwImageView = findViewById(R.id.throwImageView);

        // Налаштування анімацій для "пружності"
        springyScaleXAnimation = new SpringAnimation(springyImageView, SpringAnimation.SCALE_X)
                .setSpring(new SpringForce(1f)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY));

        springyScaleYAnimation = new SpringAnimation(springyImageView, SpringAnimation.SCALE_Y)
                .setSpring(new SpringForce(1f)
                        .setStiffness(SpringForce.STIFFNESS_MEDIUM)
                        .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY));

        // Налаштування анімацій для "кидання"
        throwScaleXAnimation = new SpringAnimation(throwImageView, SpringAnimation.SCALE_X)
                .setSpring(new SpringForce(1f)
                        .setStiffness(SpringForce.STIFFNESS_VERY_LOW)
                        .setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY));

        throwScaleYAnimation = new SpringAnimation(throwImageView, SpringAnimation.SCALE_Y)
                .setSpring(new SpringForce(1f)
                        .setStiffness(SpringForce.STIFFNESS_VERY_LOW)
                        .setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY));

        // Обробка натискання на springyImageView
        springyImageView.setOnClickListener(v -> {
            springyImageView.setScaleX(0.5f);
            springyImageView.setScaleY(0.5f);
            springyScaleXAnimation.start();
            springyScaleYAnimation.start();
        });

        // Обробка натискання на throwImageView
        throwImageView.setOnClickListener(v -> {
            throwImageView.setScaleX(0.3f);
            throwImageView.setScaleY(0.3f);
            throwScaleXAnimation.start();
            throwScaleYAnimation.start();
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task9Activity.class);
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