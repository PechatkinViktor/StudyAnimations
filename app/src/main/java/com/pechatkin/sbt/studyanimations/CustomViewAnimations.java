package com.pechatkin.sbt.studyanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import com.pechatkin.sbt.studyanimations.financeprogressview.FinanceProgressView;

public class CustomViewAnimations extends AppCompatActivity {

    private FinanceProgressView financeProgressView;
    private ObjectAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_animations);

        init();

        mAnimator.setTarget(financeProgressView);
    }

    private void init() {
        financeProgressView = findViewById(R.id.financeProgress);
        mAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.custom_view_animator);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAnimator.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
         mAnimator.end();
    }
}
