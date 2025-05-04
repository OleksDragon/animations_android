package com.example.hw_animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView titleTextView;
    private ImageView mainImageView;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Знаходимо елементи
        titleTextView = findViewById(R.id.titleTextView);
        mainImageView = findViewById(R.id.mainImageView);
        LinearLayout buttonLayout = findViewById(R.id.buttonLayout);
        Button task1Button = findViewById(R.id.task1Button);
        Button task2Button = findViewById(R.id.task2Button);
        Button task3Button = findViewById(R.id.task3Button);
        Button task4Button = findViewById(R.id.task4Button);
        Button task5Button = findViewById(R.id.task5Button);
        Button task6Button = findViewById(R.id.task6Button);
        Button task7Button = findViewById(R.id.task7Button);
        Button task8Button = findViewById(R.id.task8Button);
        Button task9Button = findViewById(R.id.task9Button);
        Button task10Button = findViewById(R.id.task10Button);

        // Масив кнопок
        buttons = new Button[]{task1Button, task2Button, task3Button, task4Button, task5Button,
                task6Button, task7Button, task8Button, task9Button, task10Button};

        // Початкова невидимість елементів
        titleTextView.setVisibility(View.INVISIBLE);
        mainImageView.setVisibility(View.INVISIBLE);
        for (Button button : buttons) {
            button.setVisibility(View.INVISIBLE);
        }

        // Завантаження анімацій
        Animation slideDownTitle = AnimationUtils.loadAnimation(this, R.anim.slide_down_title);
        Animation scaleUpImage = AnimationUtils.loadAnimation(this, R.anim.scale_up_image);
        Animation slideDownButton = AnimationUtils.loadAnimation(this, R.anim.slide_down_button);

        // Послідовний запуск анімацій
        slideDownTitle.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                titleTextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Після завершення анімації TextView запускаємо анімацію ImageView
                scaleUpImage.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mainImageView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Після завершення анімації ImageView запускаємо анімацію кнопок
                        animateButtons(0);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });
                mainImageView.startAnimation(scaleUpImage);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        // Запускаємо першу анімацію
        titleTextView.startAnimation(slideDownTitle);

        // Обробники натискань кнопок
        task1Button.setOnClickListener(v -> startActivity(new Intent(this, Task1Activity.class)));
        task2Button.setOnClickListener(v -> startActivity(new Intent(this, Task2Activity.class)));
        task3Button.setOnClickListener(v -> startActivity(new Intent(this, Task3Activity.class)));
        task4Button.setOnClickListener(v -> startActivity(new Intent(this, Task4Activity.class)));
        task5Button.setOnClickListener(v -> startActivity(new Intent(this, Task5Activity.class)));
        task6Button.setOnClickListener(v -> startActivity(new Intent(this, Task6Activity.class)));
        task7Button.setOnClickListener(v -> startActivity(new Intent(this, Task7Activity.class)));
        task8Button.setOnClickListener(v -> startActivity(new Intent(this, Task8Activity.class)));
        task9Button.setOnClickListener(v -> startActivity(new Intent(this, Task9Activity.class)));
        task10Button.setOnClickListener(v -> startActivity(new Intent(this, Task10Activity.class)));
    }

    // Рекурсивна функція для анімації кнопок
    private void animateButtons(final int index) {
        if (index >= buttons.length) return; // Умова завершення

        Animation slideDownButton = AnimationUtils.loadAnimation(this, R.anim.slide_down_button);
        slideDownButton.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                buttons[index].setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Запускаємо анімацію наступної кнопки
                animateButtons(index + 1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        buttons[index].startAnimation(slideDownButton);
    }
}