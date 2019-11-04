package com.pechatkin.sbt.studyanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ObjectAnimator extends AppCompatActivity {

    public static final String TRANSLATION_Y = "translationY";
    public static final String ROTATION = "rotation";

    private List<Animator> mAnimators;
    ImageView imageView;
    float translationY;
    android.animation.ObjectAnimator rotationAnimator;
    android.animation.ObjectAnimator translationAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);

        init();

        rotateAnimation();

        translationAnimation();
    }

    private void translationAnimation() {
        translationAnimator.setRepeatCount(android.animation.ObjectAnimator.INFINITE);
        translationAnimator.setRepeatMode(android.animation.ObjectAnimator.REVERSE);
        translationAnimator.setDuration(500);
        mAnimators.add(translationAnimator);
    }

    private void rotateAnimation() {
        rotationAnimator.setRepeatCount(android.animation.ObjectAnimator.INFINITE);
        rotationAnimator.setRepeatMode(android.animation.ObjectAnimator.REVERSE);
        rotationAnimator.setDuration(500);
        mAnimators.add(rotationAnimator);
    }

    private void init() {
        mAnimators = new ArrayList<>();
        imageView = findViewById(R.id.imageView);
        translationY = getResources().getDimension(R.dimen.translationY);
        rotationAnimator = android.animation.ObjectAnimator.ofFloat(imageView, ROTATION, 0f, 360f);
        translationAnimator = android.animation.ObjectAnimator.ofFloat(imageView, TRANSLATION_Y, 0f, translationY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (Animator animator : mAnimators) {
            animator.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        for (Animator animator : mAnimators) {
            animator.end();
        }
    }
}
