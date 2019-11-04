package com.pechatkin.sbt.studyanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

public class ViewAnimations extends AppCompatActivity {

    private View mView;
    private ScaleAnimation scaleAnimation;
    private AlphaAnimation alphaAnimation;
    private AnimationSet animations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animations);

        init();

        scale();

        alpha();

        animations.addAnimation(scaleAnimation);
        animations.addAnimation(alphaAnimation);

        mView.startAnimation(animations);
    }



    private void alpha() {
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setDuration(500);
    }

    private void scale() {
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setDuration(500);
    }

    private void init() {
        mView = findViewById(R.id.imageView);
        scaleAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f);
        alphaAnimation = new AlphaAnimation(0f, 1f);
        animations = new AnimationSet(false);
    }
}
