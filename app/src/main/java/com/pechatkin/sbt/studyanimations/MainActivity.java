package com.pechatkin.sbt.studyanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickGoTo(R.id.animationFrameToFrame, FrameByFrame.class);
        onClickGoTo(R.id.valueAnimator, ValueAnimator.class);
        onClickGoTo(R.id.objectAnimator, ObjectAnimator.class);
        onClickGoTo(R.id.customViewAnimations, CustomViewAnimations.class);
    }

    private void onClickGoTo(int viewId, Class<? extends Activity> whereToGo) {
        findViewById(viewId).setOnClickListener((v) ->
                startActivity(new Intent(this, whereToGo))
        );
    }
}
