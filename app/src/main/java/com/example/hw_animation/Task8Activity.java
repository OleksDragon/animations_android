package com.example.hw_animation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class Task8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task8);

        LottieAnimationView lottieAnimationView = findViewById(R.id.lottieAnimationView);
        Button playButton = findViewById(R.id.playButton);
        Button backButton = findViewById(R.id.backButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button forwardButton = findViewById(R.id.forwardButton);

        playButton.setOnClickListener(v -> {
            if (lottieAnimationView.isAnimating()) {
                lottieAnimationView.cancelAnimation();
            } else {
                lottieAnimationView.playAnimation();
            }
        });

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Task7Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task9Activity.class)));
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}