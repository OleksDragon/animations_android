package com.example.hw_animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Task2Activity extends AppCompatActivity {

    private TextView scaleTextView;
    private boolean isScaledUp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        scaleTextView = findViewById(R.id.scaleTextView);
        Button scaleButton = findViewById(R.id.scaleButton);
        Button backButton = findViewById(R.id.backButton);
        Button forwardButton = findViewById(R.id.forwardButton);
        Button homeButton = findViewById(R.id.homeButton);

        scaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isScaledUp) {
                    // Зменшуємо TextView
                    ScaleAnimation scaleDown = new ScaleAnimation(
                            2f, 1.0f, // Масштаб по X: від 2 до 1.0
                            2f, 1.0f, // Масштаб по Y: від 2 до 1.0
                            ScaleAnimation.RELATIVE_TO_SELF, 0.5f, // Точка опори X (центр)
                            ScaleAnimation.RELATIVE_TO_SELF, 0.5f  // Точка опори Y (центр)
                    );
                    scaleDown.setDuration(2000); // Тривалість 2000 мс
                    scaleDown.setFillAfter(true); // Зберегти кінцевий стан
                    scaleTextView.startAnimation(scaleDown);
                    isScaledUp = false;
                } else {
                    // Збільшуємо TextView
                    ScaleAnimation scaleUp = new ScaleAnimation(
                            1.0f, 2f, // Масштаб по X: від 1.0 до 2
                            1.0f, 2f, // Масштаб по Y: від 1.0 до 2
                            ScaleAnimation.RELATIVE_TO_SELF, 0.5f, // Точка опори X (центр)
                            ScaleAnimation.RELATIVE_TO_SELF, 0.5f  // Точка опори Y (центр)
                    );
                    scaleUp.setDuration(2000); // Тривалість 2000 мс
                    scaleUp.setFillAfter(true); // Зберегти кінцевий стан
                    scaleTextView.startAnimation(scaleUp);
                    isScaledUp = true;
                }
            }
        });


        backButton.setOnClickListener(v -> startActivity(new Intent(this, Task1Activity.class)));
        forwardButton.setOnClickListener(v -> startActivity(new Intent(this, Task2Activity.class)));
        homeButton.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));

    }
}
