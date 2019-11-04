package com.pechatkin.sbt.studyanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ValueAnimator extends AppCompatActivity {

    private static final String ALPHA = "alpha";
    private static final String SCALE = "scale";

    private ImageView imageView;
    private List<Animator> mAnimators;
    private PropertyValuesHolder alphaHolder;
    private PropertyValuesHolder scaleHolder;
    private android.animation.ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        init();

        configureAnimator(animator);
        animator.addUpdateListener(
                animation -> {
                    imageView.setAlpha((Float) animation.getAnimatedValue(ALPHA));
                    Float scale = (Float) animation.getAnimatedValue(SCALE);
                    imageView.setScaleX(scale);
                    imageView.setScaleY(scale);
                }
        );
        mAnimators.add(animator);

        imageView.setOnClickListener((v) -> {
            for (Animator animator : mAnimators) {
                if (animator.isRunning()) {
                    animator.cancel();
                } else {
                    animator.start();
                }
            }
        });
    }

    private void init() {
        imageView = findViewById(R.id.imageView);
        mAnimators = new ArrayList<>();
        alphaHolder = PropertyValuesHolder.ofFloat(ALPHA, 0f, 1f);
        scaleHolder = PropertyValuesHolder.ofFloat(SCALE, 0.5f, 1f);
        animator = android.animation.ValueAnimator.ofPropertyValuesHolder(alphaHolder, scaleHolder);
    }

    private void configureAnimator(android.animation.ValueAnimator animator) {
        animator.setDuration(500);
        animator.setRepeatMode(android.animation.ValueAnimator.REVERSE);
        animator.setRepeatCount(android.animation.ValueAnimator.INFINITE);
    }
}
