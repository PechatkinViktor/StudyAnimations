package com.pechatkin.sbt.studyanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class FrameByFrame extends AppCompatActivity {

    private ImageView mHorseImageView;
    private AnimationDrawable mDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_by_frame);

        init();

        mHorseImageView.post(() -> mDrawable.start());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDrawable.start();
    }

    @Override
    protected void onStop() {
        mDrawable.stop();
        super.onStop();
    }

    private void init() {
        mHorseImageView = findViewById(R.id.horseImageView);
        mDrawable = (AnimationDrawable) mHorseImageView.getDrawable();
    }
}
